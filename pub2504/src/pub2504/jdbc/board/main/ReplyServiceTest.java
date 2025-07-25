package pub2504.jdbc.board.main;

import java.sql.SQLException;

import pub2504.jdbc.board.model.Reply;
import pub2504.jdbc.board.service.ReplyService;
import pub2504.jdbc.board.service.impl.ReplyServiceImpl;

public class ReplyServiceTest {

	public static void main(String[] args) {
		
		ReplyService replyService = new ReplyServiceImpl();
		
		try {
			
			//replyService.registReply(new Reply(0, "안녕하세요 ㅎㅎ", null, "N", 21, "HONG"));
			
			replyService.listReply().stream().forEach(System.out::println);
			
			//System.out.println(replyService.getReply(21));
			
			//replyService.modifyReply(new Reply(21, "수정된 댓글입니다.", null, "N", 21, "HONG"));
			
			//replyService.removeReply(22);
			
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
		
		
	} // main
} // class















