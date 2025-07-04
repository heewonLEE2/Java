package pub2504.exio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;

public class EXIO1 {

	public static void main(String[] args) {

		Reader read = null;
		InputStream is = null;
		
		File file = new File("C:\\pub2504\\files\\gimi.txt");

		try {
			read = new FileReader(file);
			is = new FileInputStream(file);
			
			 BufferedReader reader = new BufferedReader(read);
			 // System.out.println(reader.readLine());

			System.out.println(Files.readString(file.toPath()));

			reader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				read.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main
} // class



