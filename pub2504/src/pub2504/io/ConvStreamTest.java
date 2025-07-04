package pub2504.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ConvStreamTest {

	public static void main(String[] args) {

		OutputStream os = null;
		Writer writer = null;
		InputStream is = null;
		Reader reader = null;

		try {
			File file = new File("C:\\pub2504\\files\\file3.txt");

			os = new FileOutputStream(file);

			// OutputStream 을 Writer 로 변환하는 변환스트림
			// 바이트단위 출력스트림을 문자단위 출력스트림으로 변환
			writer = new OutputStreamWriter(os);

			writer.write(65); // A
			writer.flush();

			is = new FileInputStream(file);

			// InputStream 을 Reader 로 변환하는 변환스트림
			// 바이트단위 입력스트림을 문자단위 입력스트림으로 변환
			reader = new InputStreamReader(is);
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
