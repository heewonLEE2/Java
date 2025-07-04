package pub2504.gui;

/* [JSON Server 연동 REST 통신 - JTable]

    - 클래스 구성
      Student.java : 학생 정보 클래스
      Score.java : 성적 정보 클래스
      StudentUI.java : 학생 성적 UI 클래스
      StudentRest.java : 서버 통신 클래스
      StudentEvent.java : 이벤트 처리 클래스
      StudentMain.java : 메인 실행 클래스
      
 - JSON Server에서 studentscore.json 서비스
      [http://localhost:7777/studentscore]
      [studentscore.json]
      { 
         "studentscore" : 
         [{"id": "1", "name": "홍길동", "kor": 100, "math": 90, "eng": 80},
          {"id": "2", "name": "강감찬", "kor": 90, "math": 80, "eng": 70},
          {"id": "3", "name": "이순신", "kor": 80, "math": 70, "eng": 60}]
      }
       
    - JTable 컬럼 구성 : 학번, 학생명, 국어, 영어, 수학, 총점, 평균
     
    - 구현 기능
      1) 목록
      2) 등록
      3) 수정
      4) 삭제
      5) 총점/평균 연산 (자동 연산)
           
*/

public class StudentMain {

	public static String API_URL = "http://localhost:5000/studentscore";
	
   public static void main(String[] args) {
      
	   new StudentUI().init();
	   
	   
   } // main
   
} // class











