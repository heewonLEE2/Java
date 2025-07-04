package pub2504.exoop;

public class Person {

	public String name;
	public String age;
	public String ssn;

	Person() {
	}

	Person(String name, String age, String ssn) {
		this.name = name;
		this.age = age;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@Override
	public String toString() {
		return name + "정보 입니다. \n" + "나이 : " + age + "\n" + "주민번호 : " + ssn;
	}

} // class