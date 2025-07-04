package pub2504.exio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

public class ExCharStream {

	public static void main(String[] args) {

		Reader read = null;
		Writer write = null;

		File file = new File("C:\\pub2504\\files\\name.txt");

		try {
			write = new FileWriter(file);

			write.write("heewonLEE2");
			write.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				write.close();

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		try {
			read = new FileReader(file);
			
			BufferedReader reader = new BufferedReader(read);
			
			System.out.println(reader.readLine());

			reader.close();
		} catch (IOException  ioe) {
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



