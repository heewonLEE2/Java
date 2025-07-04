package pub2504.exio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExByteStream {

	public static void main(String[] args) {

		OutputStream os = null;
		InputStream is = null;

		try {
			File file = new File("C:\\pub2504\\files\\byte.dat");
			os = new FileOutputStream(file);
			is = new FileInputStream(file);

			os.write(65);
			System.out.println(is.read());

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				os.close();
				is.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main
} // class




