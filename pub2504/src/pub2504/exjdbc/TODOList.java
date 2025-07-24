package pub2504.exjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pub2504.util.ConnectionUtil;

public class TODOList {

	private static List<TODO> todoList = new ArrayList<TODO>();

	public TODOList() {
	}

	// List 가져오기
	public void getAllist() {

		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String allSelectSQL = " SELECT * FROM TODO ORDER BY TDNO";

			pstmt = conn.prepareStatement(allSelectSQL);
			rs = pstmt.executeQuery();

			if (rs != null) {

				todoList.removeAll(todoList);
				while (rs.next()) {

					todoList.add(new TODO(rs.getInt("TDNO"), rs.getString("TDWRITER"), rs.getString("TDCONTENT"),
							rs.getTimestamp("TDDATE"), rs.getString("TDYN")));
				}
			} else
				System.out.println("Todo 목록이 하나도 없습니다.!");

			todoList.stream().forEach(System.out::println);
			System.out.println("메뉴번호(1.목록, 2.등록, 3.삭제. 4.완료처리. 5.종료)");

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		ConnectionUtil.closeConnection(conn, pstmt, rs);
	}// getTolist

	// 리스트 삭제하기
	public void deleteList(Scanner scanner) {

		todoList.stream().forEach(System.out::println);
		System.out.println("삭제할 TDNO를 입력하세요");

		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			String deleteSQL = " DELETE TODO WHERE TDNO=? ";

			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, scanner.nextInt());

			System.out.println(pstmt.executeUpdate() > 0 ? "삭제 성공!" : "삭제 실패!");
			System.out.println("메뉴번호(1.목록, 2.등록, 3.삭제. 4.완료처리. 5.종료)");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		ConnectionUtil.closeConnection(conn, pstmt, null);
	}// deleteList

	// 리스트 완료 여부 업데이트 하기
	public void updateList(Scanner scanner) {
		System.out.println("완료할 TodoNo을 선택하세요!");

		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			String updateYesSQL = " UPDATE TODO SET TDYN='Y' WHERE TDNO = ? ";

			pstmt = conn.prepareStatement(updateYesSQL);
			pstmt.setInt(1, scanner.nextInt());

			System.out.println(pstmt.executeUpdate() > 0 ? "해당 목록 완료 처리!" : "완료 처리 실패! 한번더 확인하세요");
			System.out.println("메뉴 (1.목록, 2.등록, 3.삭제. 4.완료처리. 5.종료)");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		ConnectionUtil.closeConnection(conn, pstmt, null);
	} // checkList

	// 리스트 목록 넣기
	public void insertList(Scanner scanner) {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt = null;

		System.out.println("작성자와 내용을 입력하세요(형식 :이희원,운동하기)");
		String[] contentArray = scanner.next().split(",");

		try {
			String insertSQL = " INSERT INTO TODO VALUES (SEQ_TODO.NEXTVAL, ?, ?, SYSTIMESTAMP, 'N') ";
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, contentArray[0]);
			pstmt.setString(2, contentArray[1]);

			System.out.println(pstmt.executeUpdate() > 0 ? "TodoList 등록 성공!" : "TodoList 등록 실패 입력값을 확인해 보세요");

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		ConnectionUtil.closeConnection(conn, pstmt, null);
	}

} // class
