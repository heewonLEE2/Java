package pub2504.jdbc.board.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pub2504.jdbc.board.model.Board;
import pub2504.jdbc.board.service.BoardService;
import pub2504.jdbc.board.service.impl.BoardServiceImpl;
import pub2504.jdbc.board.util.ConnectionUtil;

public class BoardServiceTest {

	public static void main(String[] args) {
		
		try {
			
			BoardService boardService = new BoardServiceImpl();
			
			
			// board 등록
			int result = boardService.registBoard(new Board(0, "게시판3", null, null));
			if(result > 0) System.out.println("입력성공");
			
			// board allList
			boardService.listBoard().stream().forEach(System.out::println);
			
			// board modify
			boardService.modifyBoard(new Board(21, "수정 게시판3", null, null));
			
			// board delete
			boardService.removeBoard(22);
			
			// board get
			System.out.println(boardService.getBoard(21));
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
	} // main
} // class






