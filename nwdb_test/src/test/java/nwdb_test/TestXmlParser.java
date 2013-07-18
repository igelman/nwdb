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
	private String firstDescription = "The Daily Pic: Josephine Meckseper plucks her art from our commodity culture.";
	private String actualFirstDescription = "";
	private String xExpression = "rss/channel/item/description";
	
	private String getActualFirstDescription(InputStream in) {
		XmlParser xp = new XmlParser(in);
		return xp.nodeContent(xExpression);
	}
	
	@Before
	public void setUp() throws Exception { 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	// Test parser on local file
	public void testGetFirstDescriptionFromFile() {
		String fileName = "articles.rss.xml";
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
		actualFirstDescription = getActualFirstDescription(in);
		
		System.out.println("testGetFirstDescriptionFromFile ...");
		System.out.println("Expected: " + firstDescription);
		System.out.println("Actual:   " + actualFirstDescription);
		assertEquals(firstDescription, actualFirstDescription);
	}
	
	@Test
	// Test parser on remote url
	public void testGetFirstDescriptionFromUrl() {
		String url = "http://igelman.com/nwdb/articles.rss.xml";
	
		InputStream in;
		try {
			in = new URL(url).openStream();
			actualFirstDescription = getActualFirstDescription(in);
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
