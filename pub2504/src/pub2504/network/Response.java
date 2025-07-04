package pub2504.network;

public class Response {
	private Header header;
	private Body body;
	private int pageNo;
	private int numOfRows;
	private int totalCount;
	
	public Response() {
	}
	public Response(Header header, Body body, int pageNo, int numOfRows, int totalCount) {
		this.header = header;
		this.body = body;
		this.pageNo = pageNo;
		this.numOfRows = numOfRows;
		this.totalCount = totalCount;
	}
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "Response [header=" + header + ", body=" + body + ", pageNo=" + pageNo + ", numOfRows=" + numOfRows
				+ ", totalCount=" + totalCount + "]";
	}
	
	
}
