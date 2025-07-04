package pub2504.basic;

import java.util.Scanner;

public class ExArray4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 학생 정보 2차원 배열로 받기
		String[][] student = new String[3][4];
		
		// 학생 수 , 과목 수 변수에 할당 
		int studentArr_1Leng = student.length;
		int studentArr_2Leng = student[0].length;
		// 학생 점수 총점 저장할 배열
		int[] studentSumScoreArr = new int[studentArr_1Leng];
		// 학생 점수 평균 저장할 배열
		int[] studentAvgScoreArr = new int[studentArr_1Leng];
		
		// 학생 정보 입력 받기 // 각 j의 인덱스 0: 이름, 1: 국어, 2: 영어, 3: 수학을 저장 하겠금
		for(int i =0; i < studentArr_1Leng; i++) {
			for(int j = 0; j < studentArr_2Leng; j++) {
				switch (j) {
				case 0:
					System.out.printf("%d번째 학생 이름을 입력하세요",i+1);
					student[i][j] = scanner.next();
					break;
				case 1:
					System.out.println("국어 점수를 입력하세요");
					student[i][j] = scanner.next();
					break;
				case 2:
					System.out.println("영어 점수를 입력하세요");
					student[i][j] = scanner.next();
					break;
				case 3:
					System.out.println("수학 점수를 입력하세요");
					student[i][j] = scanner.next();
					break;
				} // switch 문
			} // j for문
		} // i for문
		
		// 한명,한명 총점 더하기
		for(int i = 0; i < studentArr_1Leng; i++) {
			// 0번 인덱스는 이름이기 때문에 1번 인덱스부터 시작하게 j 를 1로 설정
			for(int j = 1; j < studentArr_2Leng; j++) {
				studentSumScoreArr[i] += Integer.parseInt(student[i][j]);
			}
		}
		
		// 한명,한명 평균 기록 합계 인덱스에서 학생의 수 만큼 나눠서 평균 배열에 저장
		for(int i = 0; i < studentArr_1Leng; i++) {
			studentAvgScoreArr[i] = studentSumScoreArr[i] / studentArr_1Leng  ;
		}
		
		// 학생 정보 출력
		for(int i = 0; i < studentArr_1Leng; i++) {
			System.out.print("학생의 성적 : ");
			for(int j = 0; j < studentArr_2Leng; j++) {
				System.out.print(student[i][j]+ " ");
			}
			System.out.println();
		}
		
		// 학생 총점, 평균 출력
		for(int i =0; i < studentArr_1Leng; i++) {
			System.out.println(student[i][0]+"학생 총점 : " + studentSumScoreArr[i]);
			System.out.println(student[i][0]+"학생 평균 : " + studentAvgScoreArr[i]);
			System.out.println();
		}
		
		
		scanner.close();
	} // main
} // class