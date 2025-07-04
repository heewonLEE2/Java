package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Practice {

	public static void main(String[] args) {

		URI uri = null;
		URL url = null;
		URLConnection conn = null;
		BufferedReader br = null;
		
		try {
			
			uri = new URI("https://apis.zigbang.com/apt/locals/prices/on-danjis?geohash=wydm7");
			url = uri.toURL();
			conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String jsonStr = "";
			String line = "";
			
			while((line=br.readLine()) != null) {
				jsonStr += line;
			}
			
			JsonObject jsonObj = gson.fromJson(jsonStr, JsonObject.class);
			JsonArray jsonArr =jsonObj.get("filtered").getAsJsonArray();
			
			jsonArr.asList().stream().forEach(
					e-> {
					final JsonObject eJsonObj = e.getAsJsonObject();
					
					});
			
			
//			for(JsonElement json : jsonArr) {
//				System.out.println(json);
//			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	} // main
} // class









