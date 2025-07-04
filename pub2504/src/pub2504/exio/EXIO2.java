package pub2504.exio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class EXIO2 {

	public static void main(String[] args) {

		Writer write = null;
		File file = new File("C:\\pub2504\\files\\noname.txt");
		
		// 문자열 및 파일명 입력 받기
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("파일명과 문자열을 입력하세요.  형식 예) 파일명,문자열~~");
		String text = scanner.nextLine();
		int fileNameIndext = text.lastIndexOf(",");
		String fileName = text.substring(0, fileNameIndext);

		scanner.close();
		
		// 파일 내용 저장
		try {
			write = new FileWriter(file);
			write.write(text.substring(fileNameIndext + 1));
			write.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				write.close();
				System.out.println("정상적으로 문자열이 저장되고 파일명도 바꼈습니다.");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		file.renameTo(new File("C:\\pub2504\\files\\" + fileName + ".txt"));
		
	} // main
} // class






