package pub2504.exjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pub2504.util.ConnectionUtil;

public class ExJDBC1 {

	public static void main(String[] args) {

		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {

//			// 시퀀스 생성
//			String createSeqSQL = " CREATE SEQUENCE SEQ_STUDENT ";
//
//			pstmt = conn.prepareStatement(createSeqSQL);
//			pstmt.executeUpdate();
//
//			// 테이블 생성
//			String createTableSQL = " CREATE TABLE STUDENT( " + "STNO NUMBER PRIMARY KEY,"
//					+ "STNAME VARCHAR2(20) NOT NULL," + "STEMAIL VARCHAR2(200)," + "STPHONE VARCHAR2(20) )";
//
//			pstmt = conn.prepareStatement(createTableSQL);
//			pstmt.executeUpdate();

			// insert
			String insertSQL = " insert into student values(seq_student.nextval, ?, ?, ?) ";
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, "유관순");
			pstmt.setString(2, "YOU@YOU.COM");
			pstmt.setString(3, "010-3333-3333");
			result = pstmt.executeUpdate();
			if (result > 0)
				System.out.println("입력 완료!");

			// select
			String selectSQL = " select stno, stname, stemail, stphone from student ";
			pstmt = conn.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getInt("stno") + " " + rs.getString("stname") + " " + rs.getString("stemail")
							+ " " + rs.getString("stphone"));
				}
			}

			// update
			String updateSQL = " update student set stname=?, stemail=?, stphone=? " + " where stno=? ";
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, "UP_유관순");
			pstmt.setString(2, "UP_YOU@YOU.COM");
			pstmt.setString(3, "UP_010-3333-3333");
			pstmt.setInt(4, 9);
			result = pstmt.executeUpdate();
			if (result > 0)
				System.out.println("수정 완료!");

			// delete
			String deleteSQL = " delete student where stno=? ";
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, 10);
			result = pstmt.executeUpdate();
			if (result > 0)
				System.out.println("삭제 완료!");

			ConnectionUtil.closeConnection(conn, pstmt, null);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		ConnectionUtil.closeConnection(conn, pstmt, rs);

	} // main
} // class