package pub2504.jdbc.board.dao;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.model.Article;

public interface ArticleDao {


	public abstract List<Article> listArticle() throws SQLException;
	
	public abstract Article getArticle(int aid) throws SQLException;
	
	public abstract int registArticle(Article article) throws SQLException;
	
	public abstract int modifyArticle(Article article) throws SQLException;
	
	public abstract int removeArticle(int aid) throws SQLException;
}
