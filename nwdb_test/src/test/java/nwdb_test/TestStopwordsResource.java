package nwdb_test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestStopwordsResource {
	//private ArrayList<String> stopWords = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore @Test
	public void testReadStopwordsFile() {
		fail("Not yet implemented");
	}
	
	// Test method to read from file
	@Test
	public void testStopwordsInputFromFile() {
		StopWords sw = new StopWords();
		InputStream in = sw.inStopWords("stopwords.txt");
		Assert.assertTrue(in instanceof InputStream);
	}
	
	// Test method to create ArrayList
	@Test
	public void testCreateStopwordsArraylist() {
		StopWords sw = new StopWords();
		Assert.assertTrue(sw.getStopWords("stopwords.txt") instanceof ArrayList);
	}
	
	// Test method to populate ArrayList with strings
	@Test
	public void testStopwordsHas35Elements(){
		StopWords sw = new StopWords();
		Assert.assertEquals(35, sw.getStopWords("stopwords.txt").size());
	}

}
