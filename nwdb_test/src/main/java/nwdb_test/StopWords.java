package nwdb_test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StopWords {
	ArrayList<String> sw;
	
	// Constructor
	public StopWords() {
		sw = new ArrayList<String>();
	}
	
	public InputStream inStopWords(String fileName){
		return this.getClass().getClassLoader().getResourceAsStream(fileName);
	}
	
	public ArrayList<String> getStopWords(String fileName) {
		InputStream in = inStopWords(fileName); // Create InputStream from filename
		Scanner s = new Scanner(in); // Scan the stream word by word
		while (s.hasNext()) {
			sw.add(s.next());
		}
		s.close();
		return sw; // Return arrayList of stopwords
	}
}
