package pub2504.gson;

import java.util.List;

public class Data {
	
	private String status;
	private int totalResults;
	private List<Article> articles;
	
	public Data() {
	}
	public Data(String status, int totalResults, List<Article> articles) {
		this.status = status;
		this.totalResults = totalResults;
		this.articles = articles;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@Override
	public String toString() {
		return "Data [status=" + status + ", totalResults=" + totalResults + ", articles=" + articles + "]";
	}
}
