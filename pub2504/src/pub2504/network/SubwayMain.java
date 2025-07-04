package pub2504.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class SubwayMain {

	// HTTP Client 생성
	private static final HttpClient CLIENT = HttpClient.newHttpClient();
	// 요청 URL
	private static final String REQUEST_URL = "https://apis.data.go.kr/1613000/SubwayInfoService/getSubwaySttnAcctoSchdulList?"
			+ "serviceKey=nmjkcT8Dth%2Bs3Q7J%2Bfcbmh1FyAubIheEp81tQdV4b2LI1wHb2vTHbJu7YhGfjr95utZM5szJSjuEdfAZipJrHQ%"
			+ "3D%3D&pageNo=1&numOfRows=250&_type=json&dailyTypeCode=01&upDownTypeCode=D&subwayStationId=";

	private static final String STATION_NAME_URL = "http://apis.data.go.kr/1613000/SubwayInfoService/getKwrdFndSubwaySttnList?serviceKey="
			+ "nmjkcT8Dth%2Bs3Q7J%2Bfcbmh1FyAubIheEp81tQdV4b2LI1wHb2vTHbJu7YhGfjr95utZM5szJSjuEdfAZipJrHQ%3D%3D&numOfRows=10&pageNo=1&_type=json&subwayStationName=";
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static void main(String[] args) {

		try {

			// 열차 ID 가져오기
//         JsonObject subIdObj = gson.fromJson(subwayIdGet("역삼"), JsonObject.class);
//         String name = subIdObj.getAsJsonObject("response").getAsJsonObject("body")
//        		 .getAsJsonObject("items").getAsJsonObject("item").get("subwayStationId").getAsString();
//         System.out.println(stationId); // MTRS12221 열차 ID 가져오기
			System.out.println("원하시는 역 이름을 입력하세요");
			Scanner scanner = new Scanner(System.in);
			String subwayName = scanner.next();

			subwayTimeGet(subwayName);

			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main

	// 지하철 시간 GET 요청
	private static void subwayTimeGet(String subwayName) throws Exception {

		// subwayIdGET 메소드를 이용해서 매개변수에 작성한 역 정보 ID 가져오기
		JsonObject subIdObj = gson.fromJson(subwayIdGet(subwayName), JsonObject.class);
		JsonElement subIditem = subIdObj.getAsJsonObject("response").getAsJsonObject("body").getAsJsonObject("items")
				.get("item");

		JsonArray jsonarr = null;

		// 데이터가 객체이면 배열로 만들고 배열로 받아진 데이터면 배열 그대로 사용하기 위해 모두다 배열로 만들어서
		// 처리하지 않으면 에러가 난다.
		if (subIditem.isJsonArray()) {
			jsonarr = subIditem.getAsJsonArray();
		} else if (subIditem.isJsonObject()) {
			jsonarr = new JsonArray();
			jsonarr.add(subIditem.getAsJsonObject());
		}

		String name = jsonarr.get(0).getAsJsonObject().get("subwayStationId").getAsString();

		// GET 요청 객체 생성
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REQUEST_URL + name)).GET().build();

		// 응답 객체 생성
		HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

		JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

		JsonArray jsonArray = jsonObject.getAsJsonObject("response").getAsJsonObject("body").getAsJsonObject("items")
				.getAsJsonArray("item");

		jsonArray.forEach(e -> {
			JsonObject obj = e.getAsJsonObject();
			String depTime = obj.get("depTime").getAsString();
			System.out
					.println("열차역 아이디 : " + name + ", 지하철역 이름은 : " + subwayName + ", 열차 출발 시간 : " + depTime + " 입니다.");
		});

	} // doGet()

	// 지하철 id 및 지하철 역 이름 GET 요청
	private static String subwayIdGet(String name) throws Exception {
		// GET 요청 객체 생성
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(STATION_NAME_URL + name)).GET().build();

		// 응답 객체 생성
		HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
	} // doGet()
}
