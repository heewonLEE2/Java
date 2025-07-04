package pub2504.exoop;

public class Doctor {

	private String name;
	private int age;
	private int career;
	private String major;
	
	public Doctor() {
	}; 
	
	public Doctor(String name, int age, int career, String major) {
		this.name = name;
		this.age = age;
		this.career = career;
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return   "---의사 정보--- \n" + "이름 : " + this.name +"\n"	+
					"나이 : " + this.age  +"\n"	+
					"경력 : " + this.career  +"\n"	+
					"전공 : " + this.major + "\n"
			;
	}
} // class
