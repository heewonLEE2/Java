package pub2504.exjdbc;

import java.util.Scanner;

public class ExTodo {

	public static void main(String[] args) {

		// 생성자 생성해서 메소드 호출
		TODOList todoList = new TODOList();
		// 시스템을 계속 돌리기 위한 값
		boolean whileBool = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("메뉴번호(1.목록, 2.등록, 3.삭제. 4.완료처리. 5.종료)");
		// 시스템 시작
		while (whileBool) {

			switch (scanner.nextInt()) {
			case 1:
				todoList.getAllist();
				break;
			case 2:
				todoList.insertList(scanner);
				todoList.getAllist();
				break;
			case 3:
				todoList.deleteList(scanner);
				break;
			case 4:
				todoList.updateList(scanner);
				break;
			case 5:
				whileBool = false;
				System.out.println("시스템이 종료 되었습니다.");
				System.exit(0);
				break;
			default: {
				System.out.println("메뉴번호를 다시 입력해 주세요!");
				break;
			}
			}

		} // while
		scanner.close();
	} // main
} // class
