package nwdb_test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testWordCounter {
	private String paragraph;
	private HashMap<String, Integer> words;

	@Before
	public void setUp() throws Exception {
		paragraph = "word1 word2 word2 word3 word3 word3 word4 word4 word4 word4 a an and";
	}

	@After
	public void tearDown() throws Exception {
		paragraph = "";
		//words.clear();
	}

	@Test
	public void testCountAllUniques() {
		wordCounter wc = new wordCounter(paragraph);
		words = wc.countWords();
		
		int word1Count = words.get("word1");
		int word2Count = words.get("word2");
		int word3Count = words.get("word3");
		int word4Count = words.get("word4");
		int aCount = words.get("a");
		int anCount = words.get("an");
		int andCount = words.get("and");
		assertEquals("count of word1: " + word1Count,1,word1Count);
		assertEquals("count of word2: " + word2Count,2,word2Count);
		assertEquals("count of word3: " + word3Count,3,word3Count);
		assertEquals("count of word4: " + word4Count,4,word4Count);
		assertEquals("count of a: " + aCount,1,aCount);
		assertEquals("count of an: " + anCount,1,anCount);
		assertEquals("count of and: " + andCount,1,andCount);
	}
	
	@Test
	public void testRemoveStopwords() {
		wordCounter wc = new wordCounter(paragraph);
		words = wc.countWords();
		words = wc.removeStopwords();
		
		gsonOutput gson = new gsonOutput(words);
		String json = gson.getJson();
		System.out.println("words HashMap: " + json);
		
		assertFalse("check to see if 'a' is in words", words.containsKey("a"));
		assertFalse("check to see if 'an' is in words", words.containsKey("an"));
		assertTrue("count of stopwords: " + words.get("stopWordsIgnored"), words.get("stopWordsIgnored").equals(3));
	}
	
	@Test
	public void testCountStopwords() {
		
	}
	
	

}
