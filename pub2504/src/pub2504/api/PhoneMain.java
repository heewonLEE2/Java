package pub2504.api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// person 정보 2차원 배열로 저장
		String[][] personInfo = new String[5][4];
		int personArrLeng = personInfo.length;
		int personPhoneArrLeng = personInfo[0].length;

		// 정보 입력
		for (int i = 0; i < personArrLeng; i++) {
			String line = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(line, " -");
			int j =0;
			while(st.hasMoreTokens()) {
				personInfo[i][j++]=st.nextToken();
			}
			
		}
		
		// 이름 출력
		for (int i = 0; i < personArrLeng-1; i++) {
			for (int j = 0; j < personPhoneArrLeng; j++) {
					System.out.print(personInfo[i][j]+" ");
			}
			System.out.println();
		}
		
		scanner.close();
	} // main
} // class
