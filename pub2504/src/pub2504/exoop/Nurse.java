package pub2504.exoop;

public class Nurse {

	private String name;
	private int age;
	private int career;
	// 자격증 여부
	private Boolean license;
	// 담당 환자
	private String managePatient;
	
	public Nurse() {
	}

	public Nurse(String name, int age, int career, Boolean license, String managePatient) {
		this.name = name;
		this.age = age;
		this.career = career;
		this.license = license;
		this.managePatient = managePatient;
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

	public Boolean getLicense() {
		return license;
	}

	public void setLicense(Boolean license) {
		this.license = license;
	}

	public String getManagePatient() {
		return managePatient;
	}

	public void setManagePatient(String managePatient) {
		this.managePatient = managePatient;
	}
	
	@Override
	public String toString() {
		return   "---간호사 정보--- \n" + "이름 : " + this.name +"\n"	+
					"나이 : " + this.age  +"\n"	+
					"경력 : " + this.career  +"\n"	+
					"자격증 여부 : " + (this.license ? "자격증 보유" : "자격증 미보유") + "\n" +
					"담당환자 : " + this.managePatient + "\n"
				;
	}
} // class
