package nwdb_test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// Converts Object obj to json.
// Based on demos at
//  http://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
//  http://www.mkyong.com/java/how-to-enable-pretty-print-json-output-gson/
public class GsonOutput {
	private Gson gson;
	private String json;

	// Constructor creates a new Gson from object obj
	GsonOutput(Object obj) {
		// Instantiate gson object
		gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(obj);
	}
	
	public String getJson(){
		// convert java object to JSON format,
		// and returned as JSON formatted string
		return json;
	}
	
	
}
