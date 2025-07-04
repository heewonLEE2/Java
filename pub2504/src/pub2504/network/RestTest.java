package pub2504.network;

/*
	HttpClient를 활용한 REST통신
	ENDPoint : http://localhost:7777/todos
	Node의 Json서버 실행 : npx json-server --watch todos.json --host 0.0.0.0 --port 7777 --static ./public
	
	--host 를 0.0.0.0 으로 모든 ip에 대해 요청을 받겠다고 설정 
	
	
	* window 명령
	- ipconfig /all : 로컬PC IP확인
	- netstat -na | find "7777"  => 포트 열려있나 확인
	- 강사 IP : http://192.168.8.254
*/
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestTest {

	// 요청 URL
	private static final String REQUEST_URL = "http://192.168.8.5:7777/todos/";
	// HTTP Client 생성
	private static final HttpClient CLIENT = HttpClient.newHttpClient();

	public static void main(String[] args) {

		try {

			doGet();
			// doPost();
			// doDelete(6);
			// doPut();
			// doPatch();
			// idDoGet(3);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	} // main

	// ID GET 요청
	private static void idDoGet(int doId) throws Exception {
		// GET 요청 객체 생성
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REQUEST_URL + doId)).GET().build();

		printResponse(request, "GET");
	} // ID doGet()

	// GET 요청
	private static void doGet() throws Exception {
		// GET 요청 객체 생성
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REQUEST_URL)).GET().build();

		printResponse(request, "GET");
	} // doGet()

	// POST 요청
	private static void doPost() throws Exception {
		String requestBody = "{\"id\":\"4\", \"todo\" : \"안녕하세요 이희원이 보내는 Post 요청입니다.4 번\", \"completed\" : true}";
		// POST 요청 객체 생성
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REQUEST_URL))
				.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();

		printResponse(request, "POST");
	} // doPost()

	// DELTE 요청
	private static void doDelete(int deleteId) throws Exception {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REQUEST_URL + deleteId)).DELETE().build();

		printResponse(request, "DELETE");
	}

	// PUT 요청
	private static void doPut(int putId) throws Exception {
		String requestBody = "{\"id\":\"5\", \"todo\" : \"수정된 할일 5번\", \"completed\" : true}";

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REQUEST_URL + putId))
				.header("Content-Type", "application/json").PUT(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();

		printResponse(request, "PUT");
	} // PUT 요청

	// PATCH 요청
	private static void doPatch(int patchId) throws Exception {
		String requestBody = "{\"todo\" : \"patch를 이용한 수정된 할일 2번 친구\"}";

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REQUEST_URL + patchId))
				.header("Content-Type", "application/json")
				.method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody)).build();

		printResponse(request, "PATCH");
	} // PATCH 요청

	// 중복되는 Response 객체 메소드 만들기
	private static void printResponse(HttpRequest request, String requestMethdo) throws Exception {
		// 응답 객체 생성
		HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(requestMethdo + "- Status : " + response.statusCode());
		System.out.println(requestMethdo + "- Body : " + response.body());
	}

} // class
