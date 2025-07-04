package pub2504.exgui;

public class Memo {

	private String title;
	private String text;
	
	public Memo() {
	}
	public Memo(String title, String text) {
		this.title = title;
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Memo [title=" + title + ", text=" + text + "]";
	}
	
}
