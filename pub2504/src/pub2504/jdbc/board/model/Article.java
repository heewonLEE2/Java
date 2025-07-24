package pub2504.jdbc.board.model;

import java.io.Serializable;

import oracle.sql.TIMESTAMP;

public class Article implements Serializable{

	private static final long serialVersionUID = 1487123523928L;

	private int aid;
	private String atitle;
	private String acontent;
	private TIMESTAMP aregdate;
	private int acount;
	private int afcount;
	private String bdelyn;
	private int bid;
	private String mid;
	
	public Article() {
	}

	public Article(int aid, String atitle, String acontent, TIMESTAMP aregdate, int acount, int afcount, String bdelyn,
			int bid, String mid) {
		this.aid = aid;
		this.atitle = atitle;
		this.acontent = acontent;
		this.aregdate = aregdate;
		this.acount = acount;
		this.afcount = afcount;
		this.bdelyn = bdelyn;
		this.bid = bid;
		this.mid = mid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public TIMESTAMP getAregdate() {
		return aregdate;
	}

	public void setAregdate(TIMESTAMP aregdate) {
		this.aregdate = aregdate;
	}

	public int getAcount() {
		return acount;
	}

	public void setAcount(int acount) {
		this.acount = acount;
	}

	public int getAfcount() {
		return afcount;
	}

	public void setAfcount(int afcount) {
		this.afcount = afcount;
	}

	public String getBdelyn() {
		return bdelyn;
	}

	public void setBdelyn(String bdelyn) {
		this.bdelyn = bdelyn;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Article [aid=" + aid + ", atitle=" + atitle + ", acontent=" + acontent + ", aregdate=" + aregdate
				+ ", acount=" + acount + ", afcount=" + afcount + ", bdelyn=" + bdelyn + ", bid=" + bid + ", mid=" + mid
				+ "]";
	}
	
}





















