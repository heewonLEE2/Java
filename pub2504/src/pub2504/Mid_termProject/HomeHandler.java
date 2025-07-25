//package pub2504.Mid_termProject;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.Reader;
//import java.nio.charset.StandardCharsets;
//
//import com.sun.net.httpserver.HttpExchange;
//import com.sun.net.httpserver.HttpHandler;
//
//public class HomeHandler implements HttpHandler{
//
//	@Override
//	public void handle(HttpExchange exchange) throws IOException {
//		
//        if ("GET".equals(exchange.getRequestMethod())) {
//        	
//        	String filePath = 
//        	Reader reader = new InputStreamReader(null);
//        	
//        	
//        	
//            String response = 
//
//            exchange.getResponseHeaders().add("Content-Type", "text/html");
//            exchange.sendResponseHeaders(200, response.getBytes().length);
//
//            OutputStream os = exchange.getResponseBody();
//            os.write(response.getBytes(StandardCharsets.UTF_8));
//            os.close();
//        }
//	}
//	
//}
//
//
//
//
//
//
//
//
//
