package pub2504.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Gimi {

	public static void main(String[] args) {

		String filePath = "C:\\pub2504\\eclipse_workspace\\pub2504\\src\\pub2504\\api\\gimi.txt";

		try {

			BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
 
			String gimiTxt = "";
			String readLine = "";
			while ((readLine = br.readLine()) != null) {
				gimiTxt += readLine;
			}

			int index = -1;
			int result = 0;

//			 System.out.println(gimiTxt.replaceAll("\\.","\\.\n"));
			System.out.println(gimiTxt.indexOf("독립",1990 ));

//         // text 를 st 변수에 특수기호를 제외하고 토크나이징
//         StringTokenizer st = new StringTokenizer(gimiTxt, ", . ? ! []");
//         
//         // 독립 수 카운트
//         int result = 0;
//         
//         // 토크나이징 한것을 넣을 배열 하나 만들고
//         int index = 0;
//         int stLeng = st.countTokens();
//         String[] stArr = new String[stLeng];
//         
//         // 배열 인덱스에 하나씩 추가
//         while(st.hasMoreTokens()) {
//        	 stArr[index++] =st.nextToken();
//         }
//         // 배열을 돌면서 "독립" 단어 찾아서 카운트 올리기
//         for(String str : stArr) {
//        	 System.out.println(str);
//        	 if(str.contains("독립")) {
//        		 result++;
//        	 }
//         }               

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	} // main

} // class
