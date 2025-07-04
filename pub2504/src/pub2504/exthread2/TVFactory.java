package pub2504.exthread2;

public class TVFactory {

	private String name;
	private int num;

	public TVFactory() {
	}
	public TVFactory(String name, int num) {
		this.name = name;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
