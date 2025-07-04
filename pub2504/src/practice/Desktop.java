package practice;

public class Desktop {

	public static void main(String[] args) {
		
		
		System.out.println(calcMethod("3,5,+"));
		
		
	} //main
	
	private static String calcMethod(String str) {
		String[] strArr = str.split(","); 
		
		switch (strArr[2]) {
			case "+" :
				return strArr[0] + "+" + strArr[1] +" 의 연산 결과는 : "  +
					(Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1])) + "입니다.";
			case "-" :
				return strArr[0] + "-" + strArr[1] +" 의 연산 결과는 : "  +
						(Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[1])) + "입니다.";
			case "*" :
				return strArr[0] + "*" + strArr[1] +" 의 연산 결과는 : "  +
						(Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[1])) + "입니다.";
			case "/" :
				return strArr[0] + "/" + strArr[1] + " 의 연산 결과는 : "  +
				(Integer.parseInt(strArr[0]) / Integer.parseInt(strArr[1])) + "입니다.";
		}
		return null;
	} // calcMethod()
	
} // class
