package pub2504.basic;

import java.util.Scanner;

public class ExArray2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[][] studentArr = new String[3][2];
		
		int studentArrLeng = studentArr.length;
		int studentScoreArrLeng = studentArr[0].length;
		
		for(int i=0; i<studentArrLeng; i++) {
			for(int j=0; j<studentScoreArrLeng; j++) {
				if(j==0) {
					System.out.println("이름을 입력해주세요");
					studentArr[i][j] = scanner.next();
				}else {
					System.out.println("학점을 입력해주세요");
					studentArr[i][j] = scanner.next();
				}
			}
		}
//		studentArr[0][0] = scanner.next();
//		studentArr[0][1] = scanner.next();
//		studentArr[1][0] = scanner.next();
//		studentArr[1][1] = scanner.next();
//		studentArr[2][0] = scanner.next();
//		studentArr[2][1] = scanner.next();
//		
		for(int i=0; i < studentArrLeng; i ++) {
			for(int j=0; j <studentScoreArrLeng; j++) {
				System.out.print(studentArr[i][j]+",");
			}
			System.out.println();
		}
		
		scanner.close();
	} // main
} // class
