package pub2504.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트가 정수 2개와 연산자(+,-,*,/) 를 보내면
// 연산결과를 클라이언트에게 보내주는 TCP Server

public class TCPCalcServer {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket dataSocket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		BufferedWriter bw = null;

		try {

			// 서버 소켓 만들고 대기 클라이언트가 접속을 시도하면 소켓을 만든다.
			serverSocket = new ServerSocket(5000);
			if (serverSocket != null) {
				System.out.println("ServerSocket 대기중!!!!");
			}

			while (true) {

				// 대기 하였다가 요청이 들어오면 소켓 생성
				dataSocket = serverSocket.accept();
				System.out.println("클라이언트가 접속함!");

				if (dataSocket != null) {

					br = new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));
					pw = new PrintWriter(new OutputStreamWriter(dataSocket.getOutputStream()));

					String response = br.readLine();

					// 내 시스템에 결과 내기
					System.out.println(calcMethod(response));
					// Client 에 보내기
					pw.println(calcMethod(response));
					pw.flush();

				} // if(dataSocket != null)
			} // while(true)
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
				dataSocket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

	private static String calcMethod(String str) {
		String[] strArr = str.split(",");

		switch (strArr[1]) {
		case "+":
			return strArr[0] + "+" + strArr[2] + " 의 연산 결과는 : "
					+ (Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2])) + "입니다.";
		case "-":
			return strArr[0] + "-" + strArr[2] + " 의 연산 결과는 : "
					+ (Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[2])) + "입니다.";
		case "*":
			return strArr[0] + "*" + strArr[2] + " 의 연산 결과는 : "
					+ (Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[2])) + "입니다.";
		case "/":
			return strArr[0] + "/" + strArr[2] + " 의 연산 결과는 : "
					+ (Double.parseDouble(strArr[0]) / Double.parseDouble(strArr[2])) + "입니다.";
		}
		return null;
	} // calcMethod()

} // class
