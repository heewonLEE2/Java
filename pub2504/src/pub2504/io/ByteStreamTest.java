package pub2504.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamTest {

	public static void main(String[] args) {

		InputStream is = null;
		OutputStream os = null;

		try {
			// 파일 객체 생성
			File file = new File("C:\\pub2504\\files\\file1.dat");

			// 파일에 바이트를 출력하는 스트림
			os = new FileOutputStream(file);
			os.write(100); // Stream 에 Integer 100을 쓴거다.
			os.flush(); // Stream 에 적은 데이터를 밀어냄.

			// 파일에서 바이트를 입력하는 스트림
			is = new FileInputStream(file);
			System.out.println("읽은 바이트 의 내용: " + is.read()); // 한 바이트 읽어서 출력

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			// finally 에서는 사용한 모든 스트림을 반드시 닫는다.!!
			// Stream 닫는 순서는 일반적으로 사용한 순서의 반대.나중것을 먼저닫고,...
		} finally {
			// finally 에서도 파일을 닫기에서도 try catch 해줘야함
			try {
				is.close();
				os.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main
} // class