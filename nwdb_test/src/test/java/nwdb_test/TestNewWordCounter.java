package nwdb_test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestNewWordCounter {
	private String paragraph = "word1 word2 word2 word3 word3 word3 word4 word4 word4 word4 a an and";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWordHash() {
		String wordFoo = "foo";
		int countFoo = 1000;
		String wordBar = "bar";
		int countBar = 500;
		
		String expectedMapFoo = "{\"word\":\"foo\", \"count\":1000}"; 
		NewWordCounter nwc = new NewWordCounter();
		HashMap actualMapFoo = nwc.createWordMap(wordFoo);
		System.out.println(actualMapFoo.toString());
		fail("Not yet implemented");
	}



}
