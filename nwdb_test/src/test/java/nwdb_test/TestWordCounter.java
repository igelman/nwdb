package nwdb_test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestWordCounter {
	private String paragraph;
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
		WordCounter wc = new WordCounter();
		wc.countWords(paragraph);
		
		int word1Count = wc.get("word1");
		int word2Count = wc.get("word2");
		int word3Count = wc.get("word3");
		int word4Count = wc.get("word4");
		int aCount = wc.get("a");
		int anCount = wc.get("an");
		int andCount = wc.get("and");
		Assert.assertEquals("count of word1: " + word1Count,1,word1Count);
		Assert.assertEquals("count of word2: " + word2Count,2,word2Count);
		Assert.assertEquals("count of word3: " + word3Count,3,word3Count);
		Assert.assertEquals("count of word4: " + word4Count,4,word4Count);
		Assert.assertEquals("count of a: " + aCount,1,aCount);
		Assert.assertEquals("count of an: " + anCount,1,anCount);
		Assert.assertEquals("count of and: " + andCount,1,andCount);
	}
	
	@Test
	public void testRemoveStopwords() {
		WordCounter wc = new WordCounter();
		wc.countWords(paragraph);
		wc.removeStopwords();
		
		GsonOutput gson = new GsonOutput(wc);
		String json = gson.getJson();
		System.out.println("wc HashMap: " + json);
		
		Assert.assertFalse("check to see if 'a' is in words", wc.containsKey("a"));
		Assert.assertFalse("check to see if 'an' is in words", wc.containsKey("an"));
		Assert.assertTrue("count of stopwords: " + wc.get("stopWordsIgnored"), wc.get("stopWordsIgnored").equals(3));
	}
	
	@Ignore @Test
	public void testCountStopwords() {
		
	}
	
	

}
