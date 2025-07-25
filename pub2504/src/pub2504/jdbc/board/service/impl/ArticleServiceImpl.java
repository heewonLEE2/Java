package pub2504.jdbc.board.service.impl;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.dao.ArticleDao;
import pub2504.jdbc.board.dao.impl.ArticleDaoImpl;
import pub2504.jdbc.board.model.Article;
import pub2504.jdbc.board.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{

	private ArticleDao articleDao;
	
	public ArticleServiceImpl() {
		articleDao = new ArticleDaoImpl();
	}
	
	@Override
	public List<Article> listArticle() throws SQLException{
		return articleDao.listArticle();
	}
	
	@Override
	public Article getArticle(int aid) throws SQLException{
		return articleDao.getArticle(aid);
	}
	
	@Override
	public int registArticle(Article article) throws SQLException{
		return articleDao.registArticle(article);
	}
	
	@Override
	public int modifyArticle(Article article) throws SQLException{
		return articleDao.modifyArticle(article);
	}
	
	@Override
	public int removeArticle(int aid) throws SQLException{
		return articleDao.removeArticle(aid);
	}
}















