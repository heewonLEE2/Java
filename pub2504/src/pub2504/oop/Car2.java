package pub2504.oop;

/*
	정보 은닉(Information Hiding) = 캡슐화(Encapsulation)
	- 클래스내의 변수들을 private으로 선언
		=> 클래스 외부에서는 변수에 직접 접근을 못하게 해서 변수의 값을 보호
	- 변수의 값을 외부에 제공하기 위해서 public getter 메소드를 선언
		=> getter 메소드 형식 : get + 변수명을 대문자로 시작  
	- 변수의 값을 외부에서 변경하기 위해서 public setter 메소드를 선언
		=> setter 메소드 형식 : set + 변수명을 대문자로 시작
*/
public class Car2 {

	private String company;
	private String model;
	private String name;
	private int price;
	
	// 객체의 생성 제한을 두기 위해
	private static int count = 0;

	// 기본생성자 (default constructor)
	// 생성자를 private 으로 만들면 클래스 외부에서 객체 생성 불가능
	private Car2() {
	}

	// Car2 객체를 외부에서 생성하게 하려면 static 인 getter 메소드가 필요함
	// private Car2() {} 안에 작성해도 된다.
	public static Car2 getInstance() {
		try {
			if (count >= 3) {
				throw new Exception();
			} else
				count++;
			System.out.println(count);
			return new Car2();
		} catch (Exception e) {
			System.out.println(e + "객체는 3개만 만들 수 있습니다.");
			return null;
		}
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return 5000;
	}

	public void setPrice(int price) {
		this.price = price;
	}

} // class