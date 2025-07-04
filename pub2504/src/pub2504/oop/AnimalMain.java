package pub2504.oop;

public class AnimalMain {

	public static void main(String[] args) {

		// 강아지를 한마리 만들어서 소리를 내봅니다.
		Animal dog1 = new Dog();
		dog1.sound();
		
		// 고양이 한마리 만들어서 소리를 내봅니다.
		Animal cat1 = new Cat();
		cat1.sound();
		
		// 파리를 한마리 만들어서 소리를 내봅니다.
		// 단, 파리는 혐오동물이므로 한마리만 만들겁니다. 
		
		// Animal 은 추상클래스이므로 객체 생성이 불가능 함
		// Animal 을 상속받고 sound 를 오버라이딩한 익명 이너 클래스의 객체를 생성
		Animal fly = new Animal() {
			@Override
			public void sound() {
				System.out.println("파리는 윙윙 소리를 냅니다.");
			}
		};
		fly.sound();
		
		// 상어를 한마리 만들어서 소리를 내봅니다.
		Animal shark = new Animal() {
			@Override
			public void sound() {
				System.out.println("크앙");
			}
		};
		shark.sound();
		
	} // main
} // class