package pub2504.exoop;

public class Nutritionist {

	private String name;
	private int age;
	// 자격증 여부
	private Boolean license;
	// 만드는 음식 종류
	private String makeKindOfFood;
	
	public Nutritionist() {
	}

	public Nutritionist(String name, int age, Boolean license, String makeKindOfFood) {
		this.name = name;
		this.age = age;
		this.license = license;
		this.makeKindOfFood = makeKindOfFood;
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

	public String getMakeKindOfFood() {
		return makeKindOfFood;
	}

	public void setMakeKindOfFood(String makeKindOfFood) {
		this.makeKindOfFood = makeKindOfFood;
	}
	
	@Override
	public String toString() {
		return   "---영양사 정보--- \n" + "이름 : " + this.name +"\n"	+
					"나이 : " + this.age  +"\n"	+
					"자격증 여부 : " + (this.license ? "자격증 보유" : "자격증 미보유") + "\n" +
					"자신 있는 음식 : " + this.makeKindOfFood + "\n"
			;
	}
} // class
