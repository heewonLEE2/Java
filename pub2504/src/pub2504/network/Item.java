package pub2504.network;

public class Item {

	private String tm;
	private String stnNm;
	private String ta;

	
	public Item() {
	}


	public Item(String tm, String stnNm, String ta) {
		this.tm = tm;
		this.stnNm = stnNm;
		this.ta = ta;
	}


	public String getTm() {
		return tm;
	}


	public void setTm(String tm) {
		this.tm = tm;
	}


	public String getStnNm() {
		return stnNm;
	}


	public void setStnNm(String stnNm) {
		this.stnNm = stnNm;
	}


	public String getTa() {
		return ta;
	}


	public void setTa(String ta) {
		this.ta = ta;
	}


	@Override
	public String toString() {
		return "Item [tm=" + tm + ", stnNm=" + stnNm + ", ta=" + ta + "]";
	}
	
}




















