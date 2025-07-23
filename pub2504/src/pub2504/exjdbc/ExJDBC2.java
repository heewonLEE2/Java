package pub2504.exjdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import pub2504.util.ConnectionUtil;

public class ExJDBC2 {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		CallableStatement cstmt = null;
		
		try {
			
			// 프로시져 생성 및 실행
			cstmt = conn.prepareCall(" {call PROC_INSERT_STUDENT(?, ?, ?)} ");
			
			cstmt.setString(1, "홍길동");
			cstmt.setString(2, "hong@naver.com");
			cstmt.setString(3, "010-1111-1112");

			cstmt.execute();
			
			// 함수 생성 및 실행
			cstmt = conn.prepareCall(" {? = call FUNC_GET_STNAME(?)} ");
			
			cstmt.setInt(2, 9);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			
			cstmt.execute();
			System.out.println("함수를 실행한 반환 값은 : " + cstmt.getString(1));
			
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		ConnectionUtil.closeConnection(conn, cstmt, null);
	} // main
} // class





























