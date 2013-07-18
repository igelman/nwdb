package nwdb_test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.w3c.dom.NodeList;

public class Nwdb_test {

	public static void main(String[] args) {
		// Set number or articles to analyze.
		int articlesLimit = 100;
		// Extension: Take and arg or user input for number of articles to analyze.
		//  Default is 100
		
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
		
		// Parse item/description nodes (not channel/description)
		XmlParser xp = new XmlParser(in);
		String xExpression = "rss/channel/item/description";
		NodeList xpNodeList = xp.nodeList(xExpression);
		
		// Initialize word counter hashmap
		WordCounter wc = new WordCounter();
		for (int i = 0; i < xpNodeList.getLength(); i++) {
			String currentDescription = xpNodeList.item(i).getFirstChild().getNodeValue(); 
			wc.countWords(currentDescription);
		}
		
		// Remove stopwords from the hashmap
		wc.removeStopwords();
		
		// Output stopwords and words to json
		GsonOutput gson = new GsonOutput(wc);
		String json = gson.getJson();
		
		System.out.println(json);
	}


}
