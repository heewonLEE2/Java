package pub2504.jdbc.board.main;

import java.sql.SQLException;

import pub2504.jdbc.board.model.Afile;
import pub2504.jdbc.board.service.AfileService;
import pub2504.jdbc.board.service.impl.AfileServiceImpl;

public class AfileServiceTest {

	public static void main(String[] args) {

		AfileService afileService = new AfileServiceImpl();

		try {

			//afileService.registAfile(new Afile(0, "두번째 서버 이름입니다.", "두번째 클라이언트 이름입니다.", null, "N", 21));
			
			//afileService.listAfile().stream().forEach(System.out::println);
			
			//System.out.println(afileService.getAfile(21));
			
			//afileService.modifyAfile(new Afile(21, "수정된 두번째 서버 이름입니다.", "수정된 두번째 클라이언트 이름입니다.", null, "N", 0));
			afileService.removeAfile(22);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	} // main
} // class













