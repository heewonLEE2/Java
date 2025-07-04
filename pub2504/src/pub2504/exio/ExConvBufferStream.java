package pub2504.exio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ExConvBufferStream {

	public static void main(String[] args) {

		Reader read = null;
		Writer write = null;
		Scanner scanner = new Scanner(System.in);
		File file = new File("C:\\pub2504\\files\\scanner1.txt");

		// 파일에 문자열 입력
		try {

			write = new FileWriter(file);
			System.out.println("문자열을 입력하세요");
			write.write(scanner.nextLine());
			write.flush();
			
			scanner.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				write.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}

		// 파일 문자열 읽기
		try {
			read = new FileReader(file);
			BufferedReader reader = new BufferedReader(read);
			
			System.out.println(reader.readLine());
			
			reader.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				read.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
		
		
	} // main
} // class










