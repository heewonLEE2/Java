package pub2504.exmethod;

import java.util.Scanner;

public class ExMethod5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int studentNum = 1;
		String[][] studentArr = new String[3][4];
		// {"홍길동" , "100", "100", "100"},
		// {"이순신" , "90", "90", "90"},
		// {"강감찬" , "80", "80", "80"},

		int studentArrLeng = studentArr.length;
		
		for (int i = 0; i < studentArrLeng; i++) {
			System.out.println(studentNum +"번 학생 이름을 입력한뒤 국어, 영어, 수학 점수를 입력하세요");
			for (int j = 0; j < studentArr[0].length; j++) {
				studentArr[i][j] = scanner.next();
			}
			studentNum++;
		}
		scanner.close();
		
		printScore(studentArr);
	} // main

	static void printScore(String[][] studentArr) {
		
		int studentArrLeng = studentArr.length;
		// 아래 3개의 합을 하나의 배열에 넣어도 될 듯
		int koreaSum = 0;
		int englishSum = 0;
		int mathSum = 0;

		for (int i = 0; i < studentArrLeng; i++) {
			koreaSum += Integer.parseInt(studentArr[i][1]);
		}
		for (int i = 0; i < studentArrLeng; i++) {
			englishSum += Integer.parseInt(studentArr[i][2]);
		}
		for (int i = 0; i < studentArrLeng; i++) {
			mathSum += Integer.parseInt(studentArr[i][3]);
		}
		System.out.println("3명의 국어 점수 합계는 " + koreaSum + "국어 평균은 " + (double)koreaSum/studentArrLeng);
		System.out.println("3명의 영어 점수 합계는 " + englishSum + "영어 평균은 " + (double)englishSum/studentArrLeng);
		System.out.println("3명의 수학 점수 합계는 " + mathSum + "수학 평균은 " + (double)mathSum/studentArrLeng);

	} // printScore

} // class





