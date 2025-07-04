package pub2504.gui;

import java.io.Serializable;

// Object 이외의 상속을 받지 않은 초기의 객체
// POJO (Plain Old Java Object) : EJB가 사용한 상속의 무거운 단점을 탈피한 Object 만 상속받은 순수 자바 객체
// = Data Object, Value Object, JavaBean

public class Todo implements Serializable{ // 데이터를 정의한 클래스

	private static final long serialVersionUID = 321544842L;
	
	private long userId;
	private long id;
	private String title;
	private boolean completed;
	
	public Todo() {
	}
	public Todo(long userId, long id, String title, boolean completed) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.completed = completed;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "Todo [userId=" + userId + ", id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}
} // class



















