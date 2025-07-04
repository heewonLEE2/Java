package pub2504.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ExPubAPI2 {

	// HTTP Client 생성
	private static final HttpClient CLIENT = HttpClient.newHttpClient();
	// 요청 URL
	private static final String REQUEST_URL = "https://apis.data.go.kr/1613000/SubwayInfoService/getSubwaySttnAcctoSchdulList?"
			+ "serviceKey=nmjkcT8Dth%2Bs3Q7J%2Bfcbmh1FyAubIheEp81tQdV4b2LI1wHb2vTHbJu7YhGfjr95utZM5szJSjuEdfAZipJrHQ%"
			+ "3D%3D&pageNo=1&numOfRows=60&_type=json&subwayStationId=MTRARA1A01&dailyTypeCode=01&upDownTypeCode=D";

	public static void main(String[] args) {

		try {


			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			JsonObject jsonObject = gson.fromJson(doGet(), JsonObject.class);
			JsonArray jsonArray = jsonObject.getAsJsonObject("response").getAsJsonObject("body")
					.getAsJsonObject("items").getAsJsonArray("item");
			
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
}
