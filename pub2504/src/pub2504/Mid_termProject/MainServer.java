package pub2504.Mid_termProject;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class MainServer {

	public static void main(String[] args) {

		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
			server.createContext("/products", new ProductHandler());
			server.setExecutor(null);
			server.start();
			System.out.println("서버 시작됨: http://localhost:8888/products");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
