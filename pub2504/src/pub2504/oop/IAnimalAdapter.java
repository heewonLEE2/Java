package pub2504.oop;

// 인터페이스를 구현해서 인터페이스의 모든 메소드를 오버라이딩해 기본 구현하는 추상클래스
// => 어뎁터 클래스라 부름

public abstract class IAnimalAdapter implements IAnimal{

	@Override
	public void breath() {};
	
	@Override
	public void sound() {};
	
}