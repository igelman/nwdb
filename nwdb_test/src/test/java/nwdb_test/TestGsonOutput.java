package nwdb_test;

import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestGsonOutput {
	private HashMap<String, HashMap> output;
	private HashMap<String, Integer> words;
	
	@Before
	public void setUp() throws Exception {
		words = new HashMap<String, Integer>();
		words.put("foo", 1000);
		words.put("bar", 500);
		
		int stopWordsIgnored = 10000;
		
		output = new HashMap<String, HashMap>();

	}

	@After
	public void tearDown() throws Exception {
		output.clear();
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
	public void testJsonHasCorrectStructure() {
		String expectedOutput = "{\n"
			    + "\"words\": [\n"
			    + "          {\n"
			    + "          \"word\": \"foo\",\n"
			    + "          \"count\": 1000\n"
			    + "       },\n"
			    + "       {\n"
			    + "           \"word\": \"bar\",\n"
			    + "           \"count\": 500\n"
			    + "       }\n"
			    + "   ],\n"
			    + "   \"stopWordsIgnored\": 10000\n"
			    + "}";

		Assert.assertEquals(expectedOutput, "");
	}
	

}
