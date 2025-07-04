package pub2504.exoop;

public abstract class User {

	private String id;
	private String name;
	
	public User() {
	}
	// 생성자
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public void printInfo() {
		System.out.println( id + "님의 정보입니다.");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
} // class
