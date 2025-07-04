package pub2504.network;

public class Header {

	private String resultCode;
	private String resultMsg;
	
	public Header() {
	}
	public Header(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	@Override
	public String toString() {
		return "Header [resultCode=" + resultCode + ", resultMsg=" + resultMsg + "]";
	}
	
}
