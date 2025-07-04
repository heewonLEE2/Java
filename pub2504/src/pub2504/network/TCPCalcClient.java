package pub2504.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 서버에 정수 2개와 연산자(+,-,*,/) 를 보내고
// 결과를 받아서 출력하는 TCP Client

public class TCPCalcClient {

	public static void main(String[] args) {
		Socket clientSocket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		BufferedWriter bw = null;

		try {

			Scanner scanner = new Scanner(System.in);
			clientSocket = new Socket("192.168.8.5", 5000);

			pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"));
			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));

			System.out.println("연산하고 싶은 정수 2개와 연산자를 ,로 구분해 입력하세요. ex) 3,+,8");
			String str = scanner.nextLine();

			if (str != null) {
				pw.println(str);
				pw.flush();
			}

			System.out.println(br.readLine());

			scanner.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
				clientSocket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main
}// class
