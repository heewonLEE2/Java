package pub2504.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharStreamTest {

	public static void main(String[] args) {

		Writer writer = null;
		Reader reader = null;

		try {
			File file = new File("C:\\pub2504\\files\\file1.text");

			// 파일에 문자를 출력하는 스트림
			writer = new FileWriter(file);
			writer.write(65); // ASCII 코드 65 = A
			writer.flush();

			// 파일에서 문자를 입력하는 스트림
			reader = new FileReader(file);
			System.out.println((char) reader.read());

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			// finally 에서는 사용한 모든 스트림을 반드시 닫는다.!!
			// Stream 닫는 순서는 일반적으로 사용한 순서의 반대.나중것을 먼저닫고,...
		} finally {
			// finally 에서도 파일을 닫기에서도 try catch 해줘야함
			try {
				reader.close();
				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main
} // class
