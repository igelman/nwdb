package nwdb_test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestXmlParser {
	private String firstDescription;
	@Before
	public void setUp() throws Exception {
		firstDescription = "The Daily Pic: Josephine Meckseper plucks her art from our commodity culture.";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFirstDescriptionFromFile() {
		String xExpression = "rss/channel/item/description";
		String fileName = "articles.rss.xml";
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
		
		XmlParser xp = new XmlParser(in);
		String actualFirstDescription = xp.nodeContent(xExpression);
		
		System.out.println("testGetFirstDescriptionFromFile ...");
		System.out.println("Expected: " + firstDescription);
		System.out.println("Actual:   " + actualFirstDescription);
		assertEquals(firstDescription, actualFirstDescription);
	}
	
	@Test
	public void testGetFirstDescriptionFromUrl() {
		String xExpression = "rss/channel/item/description";
		String url = "http://igelman.com/nwdb/articles.rss.xml";
		String actualFirstDescription = "";
		InputStream in;
		try {
			in = new URL(url).openStream();
			XmlParser xp = new XmlParser(in);
			actualFirstDescription = xp.nodeContent(xExpression);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		System.out.println("testGetFirstDescriptionFromUrl ...");
		System.out.println("Expected: " + firstDescription);
		System.out.println("Actual:   " + actualFirstDescription);
		assertEquals(firstDescription, actualFirstDescription);
	}
	
	@Ignore @Test
	public void testStaxVsDom() {
		// Implement parser as Stax per http://www.java-samples.com/showtutorial.php?tutorialid=152
	}
	
	@Ignore @Test
	public void testExceptionHandlers() {
		fail("xmlParser() exceptions are not yet implemented");
		// ParserConfigurationException
		// SAXException
		// IOException
		// XPathExpressionException
	}


}
