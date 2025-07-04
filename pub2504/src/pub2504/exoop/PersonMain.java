package pub2504.exoop;

public class PersonMain {
   
   private static Person[] persons = new Person[10];   
   
   public static void main(String[] args) {
      
      String[][] dataArr = {
            {"홍길동", "이순신", "강감찬"},
            {"20", "30", "40"},
            {"000000-0000000", "111111-1111111", "222222-2222222"}
      };
      
      try {
         
         for (int i=0; i<persons.length; i++) {
            persons[i] = new Person(
               dataArr[0][(int)(Math.random()*3)],
               dataArr[1][(int)(Math.random()*3)],
               dataArr[2][(int)(Math.random()*3)]
            );
            if (i!=0 && isDup(persons[i])) {
            	System.out.println("중복되어서 한번더 시도 합니다.");
               i--;
               continue;
            }
            Thread.sleep(1000);
         }
         
         printPersons();
         
      } catch (InterruptedException ie) {
         ie.printStackTrace();
      }
      
   } // main
   
   private static boolean isDup(Person person) {
      for (int i=0; i<persons.length; i++) {
         if (persons[i].equals(person)) {
            System.out.println("이미 생성된 Person 입니다");
            return true;
         } else {
            return false;
         }
      }
      return false;
   }
   
   private static void printPersons() {
      for (Person person : persons) {
         System.out.println(person);
         System.out.println();
      }
   }

}
