package nwdb_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter extends HashMap<String, Integer> {
	HashMap<String, Integer> words; // count of each unique word in string
	
	// Constructor
	WordCounter() {
		//HashMap<String, Integer> words = new HashMap<String, Integer>();
		//return words;
	}
	
	public void countWords(String paragraph) {
		//  http://docs.oracle.com/javase/tutorial/essential/io/scanning.html
		Scanner s = new Scanner(paragraph);
		while (s.hasNext()) {
			// count occurrences of each unique word in paragraph
			// Don't worry about stopWords; we'll count and remove them from the HashMap later, rather than checking the entire stopWords list for every word encountered here  
			int count = 1;
			String currentWord = s.next();
			if ( this.containsKey(currentWord) ) {
				count = this.get(currentWord) + 1;
			}
			this.put(currentWord, count);
			//System.out.println("Word: " + currentWord + "Count: " + count);
        }
		s.close();
	}

	public void removeStopwords() {
		StopWords sw = new StopWords();
		ArrayList<String> swList = sw.getStopWords("stopwords.txt");
		
		this.put("stopWordsIgnored", 0); // initialize value of stopWordsIgnored

		// remove stopwords
		// increment value of stopWordsIgnored by the amount removed
		int countStopwords = 0;
		for (String stopword: swList) {
			if (this.containsKey(stopword)) {
				countStopwords += this.get(stopword);
				this.remove(stopword);	
			}
		}
		
		this.put("stopWordsIgnored", countStopwords);
	}

}
