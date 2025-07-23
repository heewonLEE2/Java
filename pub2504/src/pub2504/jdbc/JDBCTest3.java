package pub2504.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pub2504.util.ConnectionUtil;

// PreparedStatment 활용한 CRUD 
// PreparedStatment는 데이터베이스 연결시에 쿼리문을 미리 보내서 쿼리를 데이터베이스에서 컴파일을 해둠
// ?(위치지정자)에 필요한 값들만 보내서 쿼리를 실행시킴
// 쿼리를 모두 보내지 않으므로 보안성이 우수함, 필요한 값들만 보내므로 성능(수행 속도)이 우수함 

public class JDBCTest3 {

	public static void main(String[] args) {

		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {

			// INSERT
			// ? : placeholder(위치 지정자) - 컴파일된 SQL 구문에 인자값을 세팅하기 위한 지정자
			String insertSQL = " INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL, ?, ?) ";

			// 쿼리 컴파일
			pstmt = conn.prepareStatement(insertSQL);

			// 쿼리의 위치지정자에 필요한 값들을 설정 ? 위치에 맞춰서
			pstmt.setString(1, "강감찬");
			pstmt.setInt(2, 50);

			// 쿼리 실행 후 insert 된 행의 수를 리턴
			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("입력 성공!");
			} else {
				System.out.println("입력 실패!");
			}

			// SELECT ALL
			String selectAllSQL = " SELECT PID, PNAME, PAGE FROM PERSON ORDER BY PID DESC ";

			pstmt = conn.prepareStatement(selectAllSQL);

			rs = pstmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getInt("PID") + " " + rs.getString("PNAME") + " " + rs.getInt("PAGE"));
				}
			}

			// SELECT ONE
			String selectOneSQL = " SELECT PID, PNAME, PAGE FROM PERSON" + " WHERE PID=? ORDER BY PID DESC ";

			pstmt = conn.prepareStatement(selectOneSQL);
			pstmt.setInt(1, 2); // 1번 째 ? 에 원하는번 값을 입력하겠다.

			rs = pstmt.executeQuery();

			if (rs != null && rs.next()) { // 행이 1개여서 while 이 아닌 if 문만 실행 해도됨
				System.out.println(rs.getInt("PID") + " " + rs.getString("PNAME") + " " + rs.getInt("PAGE"));
			}

			// UPDATE
			String updateSQL = " UPDATE PERSON SET PNAME=? WHERE PID=? ";

			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, "이희원");
			pstmt.setInt(2, 2);

			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}

			// DELETE
			String deleteSQL = " DELETE PERSON WHERE PID=? ";

			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, 5);

			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("삭제 성공!");
			} else {
				System.out.println("삭제 실패!");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		ConnectionUtil.closeConnection(conn, pstmt, rs);
	} // main
} // class
