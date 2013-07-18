package nwdb_test;

import java.util.HashMap;
import java.util.Map;

public class NewWordCounter {
	// "words": {
	//    {"word":"foo", "count":1000},
	//    {"word":"bar", "count":500}
	// }
	
	//private HashMap<String, String> word;
	//private HashMap<String, Integer> count;
	
	public HashMap createWordMap(String word) {
		HashMap wordMap = new HashMap();
		wordMap.put("word", word);
		wordMap.put("count", 0);
		return wordMap;
	}
}
