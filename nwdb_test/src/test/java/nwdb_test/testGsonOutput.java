package nwdb_test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testGsonOutput {
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
	public void test() {
		gsonOutput gson;
		String json;

		// Check to see if getJson returns a string
		gson = new gsonOutput(words);
		json = gson.getJson();
		
		System.out.println(json);
		assertTrue("json is a string", json instanceof String);
		
	}

}
