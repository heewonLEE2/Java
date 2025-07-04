package pub2504.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest2 {

	public static void main(String[] args) {

		File file = new File("C:\\pub2504\\files\\buffered.txt");

		BufferedWriter bw = null;
		BufferedReader br = null;

		try {

			long startTime = System.currentTimeMillis();

			bw = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < 10000000; i++) {
				bw.write("Hello Java!");
				bw.newLine(); // 줄바꿈 문자 : 윈도우 \r, \n || 리눅스,유닉스 \n
			}

			long endTime = System.currentTimeMillis();
			System.out.println("소요시간 : " + (endTime - startTime) + "ms");

			// 많이 쓰는 형식
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main
} // class
