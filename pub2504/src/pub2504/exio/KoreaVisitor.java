package pub2504.exio;

public class KoreaVisitor {

	private int visitorNum;
	private double growth;
	private String nation;
	private String date;
	
	public KoreaVisitor() {
	}
	
	public KoreaVisitor(int visitorNum, double growth, String nation, String date) {
		this.visitorNum = visitorNum;
		this.growth = growth;
		this.nation = nation;
		this.date = date;
	}

	public int getVisitorNum() {
		return visitorNum;
	}
	public void setVisitorNum(int visitorNum) {
		this.visitorNum = visitorNum;
	}
	public double getGrowth() {
		return growth;
	}
	public void setGrowth(double growth) {
		this.growth = growth;
	}

	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
