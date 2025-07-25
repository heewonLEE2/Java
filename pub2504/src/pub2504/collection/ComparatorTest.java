package pub2504.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {

		// 오름 차순 정렬하는 Comparator
		Comparator<Integer> intComp = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		};

		List<Integer> intList = new ArrayList<Integer>();
		Collections.addAll(intList, 3, 10, 2, 9, 5, 7, 15, 6, 4);

		// 리스트를 intComp 사용해서 정렬
		Collections.sort(intList, intComp);
		System.out.println(intList);

		// 리스트를 뒤집어서 내림차순 정렬
		Collections.reverse(intList);
		System.out.println(intList);

		// 문자열 길이에 따라 오름차순 정렬하는 Comparator
		Comparator<String> strComp = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
			}
		};

		List<String> strList = new ArrayList<String>();
		Collections.addAll(strList, "hi", "hell", "java", "programming", "a");

		Collections.sort(strList, strComp);
		System.out.println(strList);

		// 객체 정렬
		class Person {
			String name;
			int age;

			Person(String name, int age) {
				this.name = name;
				this.age = age;
			}

			@Override
			public String toString() {
				return name + ":" + age;
			}
		} // Person

		List<Person> personList = new ArrayList<Person>();
		Collections.addAll(personList, new Person("홍길동", 90), new Person("강감찬", 10), new Person("이순신", 30),
				new Person("최영", 100), new Person("권율", 40));

		// 각 사람의 나이에 대해서 오름차순 정렬하는 Comparator
		Comparator<Person> ascCom = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
		};

		Collections.sort(personList, ascCom);
		System.out.println(personList);

		// 1) 아래 리스트를 나이순으로 내림차순 정렬하세요
		List<String> ssnList = new ArrayList<String>();
		ssnList.add("980000-1234567");
		ssnList.add("000000-1234567");
		ssnList.add("050000-1234567");
		ssnList.add("880000-1234567");
		ssnList.add("990000-1234567");

//		Comparator<String> ssnComp = new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//					
//				return null;
//			}
//		};

//		Collections.sort(ssnList, ssnComp);
//		System.out.println(ssnList);

		// 실습2) 아래 리스트를 각 학생의 성적 총합 순으로 내림차순 정렬하세요.
		class Score {
			int kor;
			int eng;

			Score(int kor, int eng) {
				this.kor = kor;
				this.eng = eng;
			}
		}

		class Student {
			String name;
			Score score;
			int sum;

			Student(String name, Score score) {
				this.name = name;
				this.score = score;
				this.sum = this.score.kor + this.score.eng;
			}

			@Override
			public String toString() {
				return name + ":" + sum;
			}
		}

		List<Student> stdList = new ArrayList<Student>();
		stdList.add(new Student("홍길동", new Score(70, 50)));
		stdList.add(new Student("강감찬", new Score(100, 100)));
		stdList.add(new Student("이순신", new Score(90, 70)));
		stdList.add(new Student("장보고", new Score(40, 90)));
		stdList.add(new Student("최영", new Score(80, 60)));

		Comparator<Student> sumComp = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.sum - o2.sum;
			}
		};

		Collections.sort(stdList, sumComp);
		System.out.println(stdList);

		// 3) 아래 리스트를 이름순으로 1차 오름차순 정렬하고 가격순으로 2차 내림정렬
		/*
		 * 결과 마우스 200 마우스 100 모니터 200 모니터 100 ...
		 */
		class Product {
			String name;
			int price;

			Product(String name, int price) {
				this.name = name;
				this.price = price;
			}

			@Override
			public String toString() {
				return name + ":" + price;
			}
		}
		List<Product> prodList = new ArrayList<Product>();
		prodList.add(new Product("피씨", 100));
		prodList.add(new Product("모니터", 100));
		prodList.add(new Product("마우스", 100));
		prodList.add(new Product("키보드", 100));
		prodList.add(new Product("스피커", 100));
		prodList.add(new Product("피씨", 200));
		prodList.add(new Product("모니터", 200));
		prodList.add(new Product("마우스", 200));
		prodList.add(new Product("키보드", 200));
		prodList.add(new Product("스피커", 200));

		Collections.sort(prodList, new Comparator<Product>() {
			public int compare(Product prod1, Product prod2) {
				return prod1.name.compareTo(prod2.name);
			};

		});
		System.out.println(prodList);
		
		Collections.sort(prodList, new Comparator<Product>() {
			public int compare(Product prod1, Product prod2) {
				if(prod1.name.equals(prod2.name)) {
					return prod2.price - prod1.price;
				} else {
					return 0;
				}
			};
		});
		System.out.println(prodList);
		
	} // main
} // class


















