package pub2504.exception;

import java.util.Scanner;

public class ExceptionTest3 {

	public static void main(String[] args) {

		int arrLength = 0;
		Person[] personArr = new Person[5];

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < personArr.length; i++) {
			System.out.println(5 - arrLength +"번 입력하세요");
			System.out.println("이름을 작성하세요");
			String uName = scanner.next();

			System.out.println("직업을 작성하세요");
			String uJob = scanner.next();
			arrLength++;
			new Person(uName, uJob);
		}
		scanner.close();
		
		checkJob(personArr);
	} // main

	private static void checkJob(Person[] personArr) {
		for (Person person : personArr) {
			if (person.job.equals("산적")) {
				try {
					throw new JobException();
				} catch (JobException je) {
					System.out.println(je);
				}
			}
		}
	} // checkJob

} // class
