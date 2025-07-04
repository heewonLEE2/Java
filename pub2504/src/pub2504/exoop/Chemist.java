package pub2504.exoop;

// 약사
public class Chemist {

	private String name;
	private int age;
	// 자격증 여부
	private Boolean license;
	// 만드는 약 종류
	private String makeKindOfDrug;
	
	public Chemist() {
	}
	
	public Chemist(String name, int age, Boolean license, String makeKindOfDrug) {
		this.name = name;
		this.age = age;
		this.license = license;
		this.makeKindOfDrug = makeKindOfDrug;
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

	public Boolean getLicense() {
		return license;
	}

	public void setLicense(Boolean license) {
		this.license = license;
	}

	public String getMakeDrug() {
		return makeKindOfDrug;
	}

	public void setMakeDrug(String makeKindOfDrug) {
		this.makeKindOfDrug = makeKindOfDrug;
	}
	
	@Override
	public String toString() {
		return   "---간호사 정보--- \n" + "이름 : " + this.name +"\n"	+
					"나이 : " + this.age  +"\n"	+
					"자격증 여부 : " + (this.license ? "자격증 보유" : "자격증 미보유") + "\n" +
					"만드는 약 : " + this.makeKindOfDrug + "\n"
			;
	}
} // class
