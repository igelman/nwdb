package nwdb_test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.NodeList;

public class Nwdb_test {

	public static void main(String[] args) {
		// Create hashmap to store word counts
		HashMap words = new HashMap();
		
		// Create int to count stopwords
		  // initialize to 0
		int swCount = 0;
		
		// Read stopwords.txt into arraylist of words to ignore
		StopWords sw = new StopWords();
		ArrayList<String> swList = sw.getStopWords("stopwords.txt");
		
		// Set number or articles to analyze.
		  // Default is 100.
		int articlesLimit = 100;
		  // Take and arg or user input for number of articles to analyze	
		
		// Read content from "http://www.thedailybeast.com/feed/articles.rss.xml?limit=" + articlesLimit
		String url = "http://www.thedailybeast.com/feed/articles.rss.xml?limit=" + articlesLimit;
		InputStream in = null;
		try {
			in = new URL(url).openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XmlParser xp = new XmlParser(in);
		String xExpression = "rss/channel/item/description";
		NodeList xpNodeList = xp.nodeList(xExpression);
		
		// Initialize word counter hashmap
		WordCounter wc = new WordCounter();
		for (int i = 0; i < xpNodeList.getLength(); i++) {
			
			System.out.println(xpNodeList.item(i).getFirstChild().getNodeValue());
		}
		
		
		// For each "description" element:
		//  Increment stopwords for each stopword encountered 
		//  Add to words each unique non-stopword as key and increment value 

		
		// Output stopwords and words to json
		GsonOutput gson = new GsonOutput("An object");
		String json = gson.getJson();
		
		System.out.println(json);
	}


}
