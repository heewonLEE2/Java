package pub2504.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) {

		File dir = new File("C:\\pub2504\\files\\dir");

		// 디렉토리 생성
		dir.mkdir();

		// 디렉토리인지 확인
		System.out.println(dir.isDirectory()); // true

		// 파일인지 확인
		System.out.println(dir.isFile()); // false

		// 디렉토리내에 파일 객체 생성
		File file = new File(dir, "newFile.txt");

		// 파일 생성
		try {
			file.createNewFile();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// 실습 : 파일에 ABC 쓰기
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write("ABC");
			fw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// 파일의 문자 수
		System.out.println(file.length());

		try {
			System.out.println(file.canExecute()); // 실행가능 여부
			System.out.println(file.canRead()); // 읽기가능 여부
			System.out.println(file.canWrite()); // 쓰기가능 여부

			// 파일의 절대 경로를 반환(.까지)
			// . : 현재디렉토리, .. : 이전 디렉토리, ../.. : 이전의 이전 디렉토리, / : 루트 디렉토리
			System.out.println(new File(".").getAbsolutePath());

			// 파일의 절대 경로를 반환(.빼고)
			System.out.println(new File(".").getCanonicalPath());

			File abFile = file.getAbsoluteFile();
			System.out.println(abFile.getClass().getName()); // 절대경로 File 반환
			System.out.println(file.getAbsolutePath()); // 절대경로 문자열 반환
			System.out.println(file.getName()); // newFile.txt
			System.out.println(file.getParent()); // 상위 파일명(디렉토리) 문자열
			File parentFile = file.getParentFile(); // 상위 파일(디렉토리) File 반환
			System.out.println(parentFile.getClass().getName()); // java.io.File

			System.out.println(file.getPath()); // 파일의 전체 경로
			System.out.println(file.isHidden()); // 숨긴파일 여부
			System.out.println(file.lastModified()); // 최종수정일에 대한 epoch time 값
			System.out.println(new Date(file.lastModified())); // Wed Jun 25 11:26:08 KST 2025
			file.setExecutable(true); // 실행가능 여부 setting
			file.setLastModified(System.currentTimeMillis()); // 최종수정일시 설정
			file.setReadable(true); // 읽기가능 여부 setting
			file.setReadOnly(); // 읽기전용 setting
			file.setWritable(true); // 쓰기가능 여부 setting

			file.renameTo(new File("C:\\pub2504\\files\\dir\\newnewfile.txt"));

			// 파일 존재하면 삭제
			// (D:\\에 있는 파일 지우기, C드라이브의 파일은 권한문제로 삭제불가)
			File deleteFile = new File("D:\\a.txt");
			if (deleteFile.exists()) {
				deleteFile.delete();
			}

			File dir2 = new File("C:\\");
			File[] fileArr = dir2.listFiles(); // 디렉토리내의 파일, 디렉토리 배열
			for (File f : fileArr) {
				if (f.isDirectory()) {
					System.out.println("[D]" + f.getName() + "(" + f.length() + ")");
				} else {
					System.out.println(f.getName() + "(" + f.length() + ")");
				}
			}

			File[] rootArr = File.listRoots(); // 루트디렉토리 배열
			for (File f : rootArr) {
				System.out.println(f.getPath());
			}

			System.out.println();
			System.out.println();
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main
} // class
