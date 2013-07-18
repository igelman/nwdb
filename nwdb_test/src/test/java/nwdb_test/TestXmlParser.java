package nwdb_test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestXmlParser {
	private String expectedFirstDescription = "The Daily Pic: Josephine Meckseper plucks her art from our commodity culture.";
	private String actualFirstDescription = "";
	private String xExpression = "rss/channel/item/description";
	private int limit = 5;
	
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
		
		String message = "Expected first description: " + expectedFirstDescription + "\nActual:                     " + actualFirstDescription;
		System.out.println("\ntestGetFirstDesriptionFromFile\n" + message);
		assertEquals(message, expectedFirstDescription, actualFirstDescription);
	}
	
	@Test
	// Test parser on remote url
	public void testGetFirstDescriptionFromUrl() {
		String url = "http://igelman.com/nwdb/articles.rss.xml?limit=" + limit;
	
		InputStream in = null;
		try {
			in = new URL(url).openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actualFirstDescription = getActualFirstDescription(in);

		String message = "Expected first description: " + expectedFirstDescription + "\nActual:                     " + actualFirstDescription;
		System.out.println("\ntestGetFirstDesriptionFromUrl\n" + message);

		assertEquals(message, expectedFirstDescription, actualFirstDescription);
	}
	
	@Test
	// Test list of description nodes
	public void testCountOfDescriptionNodes() {
		int expectedCount = 5;
		String url = "http://igelman.com/nwdb/articles.rss.xml?limit=" + limit;
		
		InputStream in = null;
		try {
			in = new URL(url).openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XmlParser xp = new XmlParser(in);
		int actualCount = xp.nodeList(xExpression).getLength();
		
		String message = "Expected count of description nodes: " + expectedCount + "\nActual count: " + actualCount;
		System.out.println("\ntestCountOfDescriptionNodes\n" + message);
		Assert.assertEquals(message, expectedCount, actualCount);
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
