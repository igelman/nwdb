package nwdb_test;

import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestGsonOutput {
	private HashMap<String, Integer> words;
	
	@Before
	public void setUp() throws Exception {
		words = new HashMap<String, Integer>();
		words.put("word1", 1);
		words.put("word2", 2);
		words.put("word3", 3);
		words.put("word4", 4);
	}

	@After
	public void tearDown() throws Exception {
		words.clear();
	}

	@Test
	public void testJsonIsString() {
		GsonOutput gson;
		String json;

		// Check to see if getJson returns a string
		gson = new GsonOutput(words);
		json = gson.getJson();
		
		System.out.println(json);
		Assert.assertTrue("json is a string", json instanceof String);
		// compare the actual string to expected string to be double sure.
		
	}
	
	@Ignore @Test
	public void testJsonHasCorrectStructure () {
		
	}
	

}
