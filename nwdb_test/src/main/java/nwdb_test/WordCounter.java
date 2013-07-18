package nwdb_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
	private HashMap<String, Integer> words; // count of each unique word in string
	
	// Constructor
	WordCounter() {
		words = new HashMap<String, Integer>();
	}
	
	public HashMap<String, Integer> countWords(String paragraph) {
		//  http://docs.oracle.com/javase/tutorial/essential/io/scanning.html
		Scanner s = new Scanner(paragraph);
		while (s.hasNext()) {
			// count occurrences of each unique word in paragraph
			// Don't worry about stopWords; we'll count and remove them from the HashMap later, rather than checking the entire stopWords list for every word encountered here  
			int count = 1;
			String currentWord = s.next();
			if ( words.containsKey(currentWord) ) {
				count = words.get(currentWord) + 1;
			}
			words.put(currentWord, count);
			//System.out.println("Word: " + currentWord + "Count: " + count);
        }
		s.close();
		return words;
	}
	
	public HashMap<String, Integer> removeStopwords() {
		ArrayList<String> Stopwords = new ArrayList<String>();
		Stopwords.add("a");
		Stopwords.add("an");
		Stopwords.add("and");
		
		words.put("stopWordsIgnored", 0); // initialize value of stopWordsIgnored

		// remove stopwords
		// increment value of stopWordsIgnored by the amount removed
		int countStopwords = 0;
		for (String Stopword: Stopwords) {
			countStopwords += words.get(Stopword);
			words.remove(Stopword);
		}
		
		words.put("stopWordsIgnored", countStopwords);
				
		return words;
	}

}
