package pub2504.jdbc.board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pub2504.jdbc.board.dao.ArticleDao;
import pub2504.jdbc.board.model.Article;
import pub2504.jdbc.board.model.Board;
import pub2504.jdbc.board.util.ConnectionUtil;

public class ArticleDaoImpl implements ArticleDao{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArticleDaoImpl() {
		conn = ConnectionUtil.getConnectionUtil().getConnection();
	}

	@Override
	public List<Article> listArticle() throws SQLException {
		String sql = " select aid, atitle, acontent, aregdate, acount, afcount, adelyn, mid, bid "
				+ " from article order by aid desc ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Article> articleList = new ArrayList<Article>();
		if(rs!=null) {
			while(rs.next()) {
				Article article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAtitle(rs.getString("atitle"));
				article.setAcontent(rs.getString("acontent"));
				article.setAregdate(rs.getTimestamp("aregdate"));
				article.setAcount(rs.getInt("acount"));
				article.setAfcount(rs.getInt("afcount"));
				article.setAdelyn(rs.getString("adelyn"));
				article.setMid(rs.getString("mid"));
				article.setBid(rs.getInt("bid"));
				articleList.add(article);
			}
		}
		return articleList;
	}
	
	@Override
	public Article getArticle(int aid) throws SQLException {
		String sql = " select aid, atitle, acontent, aregdate, acount, afcount, adelyn, mid, bid "
				+ " from article where aid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		rs = pstmt.executeQuery();
		Article article = new Article();
		if(rs!=null) {
			if(rs.next()) {
				article.setAid(rs.getInt("aid"));
				article.setAtitle(rs.getString("atitle"));
				article.setAcontent(rs.getString("acontent"));
				article.setAregdate(rs.getTimestamp("aregdate"));
				article.setAcount(rs.getInt("acount"));
				article.setAfcount(rs.getInt("afcount"));
				article.setAdelyn(rs.getString("adelyn"));
				article.setMid(rs.getString("mid"));
				article.setBid(rs.getInt("bid"));
			}
		}
		return article;
	}
	
	@Override
	public int registArticle(Article article) throws SQLException {
		String sql = " insert into Article values(seq_article.nextval, ?, ?, systimestamp, 0, 0, 'N', ?, ?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, article.getAtitle());
		pstmt.setString(2, article.getAcontent());
		pstmt.setString(3, article.getMid());
		pstmt.setInt(4, article.getBid());
		return pstmt.executeUpdate();
	}
	
	@Override
	public int modifyArticle(Article article) throws SQLException {
		String sql = " update Article set atitle=?, acontent=? where aid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, article.getAtitle());
		pstmt.setString(2, article.getAcontent());
		pstmt.setInt(3, article.getAid());
		return pstmt.executeUpdate();
	}
	
	@Override
	public int removeArticle(int aid) throws SQLException {
		String sql = " delete Article where aid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		return pstmt.executeUpdate();
	}
}

















