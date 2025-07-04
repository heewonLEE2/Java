package pub2504.excollection;

public class Card {

	private String shape;
	private Integer num;
	
	public Card() {
	}
	public Card(String shape, Integer num) {
		this.shape = shape;
		this.num = num;
	}
	
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return shape + num;
	}
	
} // class
















