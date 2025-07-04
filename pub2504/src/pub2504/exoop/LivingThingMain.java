package pub2504.exoop;

public class LivingThingMain {

	public static void main(String[] args) {
		
		AbstractLivingThing tiger = new Tiger("호돌이", 20);
		AbstractLivingThing lion = new Lion("사돌이", 30);
		AbstractLivingThing cow = new Cow("소돌이", 15);
		AbstractLivingThing deer = new Dear("사슴돌이", 25);
		
		AbstractLivingThing human = new Human("홍길동" , 30);
		
		printInfo(tiger);
		printInfo(lion);
		printInfo(cow);
		printInfo(deer);
		printInfo(human);
	} // main
	
	private static void printInfo(AbstractLivingThing lt) {
		// 식물 동물 둘 다 숨을 쉬기 때문에  AbstractLivingThing 타입 모두 breathe() 메소드는 호출
		lt.breathe();
		// AbstractAnimal 타입만 sleep, eat 메소드를 갖기 때문에 instanceof 를 이용해 true인 타입들은 sleep, eat 메소드 호출
		if(lt instanceof AbstractAnimal) {
			((AbstractAnimal)lt).sleep();
			((AbstractAnimal)lt).eat();
		}
	}
	
} // class
