package pub2504.otherpackage;

import pub2504.basic.Variable3;

public class Variable3Main {

	public static void main(String[] args) {

		// Variable3Main과 Variable3은 동일패키지에 있으므로
		// Variable3에서 public으로 접근제한 한 변수에 접근 가능
		Variable3 variable3 = new Variable3();
		System.out.println(variable3.pubi);
		// System.out.println(variable3.proi);
		// System.out.println(variable3.di);

	}

}
