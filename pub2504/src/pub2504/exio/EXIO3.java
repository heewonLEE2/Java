package pub2504.exio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EXIO3 {

	static List<Student> studentList = new ArrayList<Student>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// 학생 3명 정보 입력 후 학생 배열에 담기
		for (int i = 0; i < 3; i++) {
			System.out.println("이름을 입력하세요");
			String studentName = scanner.next();
			System.out.println("국어 점수를 입력하세요");
			int korScore = scanner.nextInt();
			System.out.println("영어 점수를 입력하세요");
			int engScore = scanner.nextInt();
			System.out.println("수학 점수를 입력하세요");
			int mathScore = scanner.nextInt();
			studentList.add(new Student(studentName, new Score(korScore, engScore, mathScore)));
		}
		scanner.close();

		// 문자열로 바꿔 출력할 하기위해 String List 만들고 forEach 사용해서
		// 각 student 객체의 오버라이딩 된 toString을 불러서 학생정보 string 배열에 저장
		List<String> strList = new ArrayList<String>();

		studentList.stream().forEach(e -> strList.add(e.toString()));

		Writer write = null;
		File file = new File("C:\\pub2504\\files\\student.txt");

		// 파일에 적기
		try {
			write = new FileWriter(file);
			BufferedWriter bfWirter = new BufferedWriter(write);

			// strList 배열에서 String 을 뽑아서 파일에 적고 줄 바꾸기
			for (String str : strList) {
				bfWirter.write(str);
				bfWirter.newLine();
			}

			bfWirter.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				write.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main
} // class
