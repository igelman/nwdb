package nwdb_test;

import java.util.HashMap;

public class nwdb_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create hashmap to store word counts
		HashMap words = new HashMap();
		
		// Create int to count stopwords
		  // initialize to 0
		
		// Read stopwords.txt into arraylist of words to ignore
		
		// Set number or articles to analyze.
		  // Default is 100.
		  // Take user input for number of articles to analyze		

		// Read content from "http://www.thedailybeast.com/feed/articles.rss.xml?limit=" + articles
		  //String url = "http://www.thedailybeast.com/feed/articles.rss.xml?limit=" + articles;
		// For each "description" element:
		//  Increment stopwords for each stopword encountered 
		//  Add to words each unique non-stopword as key and increment value 

		
		// Output stopwords and words to json

		gsonOutput gson = new gsonOutput("An object");
		String json = gson.getJson();
		
		System.out.println(json);
	}


}
