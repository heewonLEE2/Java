package pub2504.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageCopier {

	public static void main(String[] args) {

		InputStream is = null;
		OutputStream os = null;
		File orgFile = null;
		File copyFile = null;

		try {

			// 원본파일
			orgFile = new File("C:\\pub2504\\files\\img.webp");
			// 복사 파일
			copyFile = new File("C:\\pub2504\\files\\img_copy.webp");

			// 원본파일에서 바이트를 입력할 스트림
			is = new FileInputStream(orgFile);
			// 복사파일에 바이트를 출력할 스트림
			os = new FileOutputStream(copyFile);

			
			/*// 한 바이트 입력 한 바이트 출력(느림) 한 바이트씩 처리시 소요시간 : 238ms
			int readByte = 0; // 읽어들인 byte 저장 변수
			while ((readByte = is.read()) > -1) { // 읽어들인 byte 가 있다면
				os.write(readByte); // 출력스트림에 쓴다.
			}
			os.flush();
			 */
			
			/*// 1024 바이트 입력 1024 바이트 출력 (빠름) 한 바이트씩 처리시 소요시간 : 0ms

			*/
			long stratTime = System.currentTimeMillis();
			byte[] byteArr = new byte[1024];
			int readByte = 0; // 읽어들인 byte 인 수 저장 변수
			while ((readByte = is.read(byteArr)) > -1) {
				os.write(byteArr, 0, readByte);
			}
			
			os.flush();
			long endTime = System.currentTimeMillis();
			System.out.println("한 바이트씩 처리시 소요시간 : " + (endTime - stratTime) + "ms");
			
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












