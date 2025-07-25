package pub2504.jdbc.board.main;

import java.sql.SQLException;

import pub2504.jdbc.board.model.Article;
import pub2504.jdbc.board.service.ArticleService;
import pub2504.jdbc.board.service.impl.ArticleServiceImpl;

public class ArticleServiceTest {

	
	public static void main(String[] args) {
		
		ArticleService articleService = new ArticleServiceImpl();
		
		try {
			
			//articleService.registArticle(new Article(0, "제목1", "내용1", null, 0, 0, "N",  21, "HONG"));
			
			//articleService.listArticle().stream().forEach(System.out::println);
			
			//System.out.println(articleService.getArticle(22));
			
			//articleService.modifyArticle(new Article(22,"수정된 제목","수정된 내용", null, 0, 0, "N", 21, "HONG"));
			
			articleService.removeArticle(22);
			
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
	} // main
} // class

















