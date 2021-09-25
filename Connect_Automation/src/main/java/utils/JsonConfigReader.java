package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonConfigReader {

	JSONObject obj;

	public void readJSONConfig() {

		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("config.json")) {

			// Read JSON file
			obj = (JSONObject) jsonParser.parse(reader);
			

		} 
		catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		catch (ParseException par) {
			par.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public String getConfigValue(String sectionName, String key) {
		readJSONConfig();
		String result = "";
		try {
			JSONObject section = (JSONObject) this.obj.get(sectionName);
			result = (String) section.getOrDefault(key, "");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
