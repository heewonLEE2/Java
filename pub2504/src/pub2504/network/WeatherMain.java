package pub2504.network;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class WeatherMain {

	// HTTP Client 생성
	private static final HttpClient CLIENT = HttpClient.newHttpClient();
	// 요청 URL
	private static final String REQUEST_URL = "http://apis.data.go.kr/1360000/AsosHourlyInfoService/getWthrDataList?"
			+ "serviceKey=nmjkcT8Dth%2Bs3Q7J%2Bfcbmh1FyAubIheEp81tQdV4b2LI1wHb2vTHbJu7YhGfjr95utZM5szJSjuEdfAZipJrHQ%"
			+ "3D%3D&numOfRows=190&dataType=json&pageNo=1&dataCd=ASOS&dateCd=HR&stnIds=108&"
			+ "endDt=20250608&endHh=01&startHh=01&startDt=20250601";

	public static void main(String[] args) {

		try {
//			final PrintWriter pw = new PrintWriter(new FileWriter(
//					new File("C:\\pub2504\\files\\202506temp.csv")
//					)); 
//
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//			JsonObject jsonObject = gson.fromJson(doGet(), JsonObject.class);
//			JsonArray jsonArray = jsonObject.getAsJsonObject("response").getAsJsonObject("body")
//					.getAsJsonObject("items").getAsJsonArray("item");
//
//			jsonArray.asList().stream().forEach(obj -> {
//				final String line = ((JsonObject) obj).get("tm").getAsString().replaceAll("-", "/").replaceAll(" ", ",")
//						+ "," + ((JsonObject) obj).get("ta").getAsString() + "C";
//				System.out.println(line);
//				pw.println(line);
//			});
//			
//			pw.close();
			Weather weather = gson.fromJson(doGet(), Weather.class);
			System.out.println(doGet());
			System.out.println(weather);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main

	// GET 요청
	private static String doGet() throws Exception {
		// GET 요청 객체 생성
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REQUEST_URL)).GET().build();

		// 응답 객체 생성
		HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
	} // doGet()

} // class
