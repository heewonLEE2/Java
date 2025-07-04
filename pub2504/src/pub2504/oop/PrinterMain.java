package pub2504.oop;

public class PrinterMain {

	public static void main(String[] args) {

		// 실습
		// 분류 : 잉크젯, 회사명:삼송, 이름:잉크안먹혀1, 가격:1000 잉크젯 프린터 생성
		// 분류 : 레이져, 회사명:앱송, 이름:종이다잘려1, 가격:2000 레이져 프린터 생성
		// 두 프린터를 켜고 > 출력하고 > 끄고

		IPrinter inkjetPrinter1 = new InkjetPrinter("잉크젯프린터", "삼송", "잉크안먹혀1", 1000);
		IPrinter razorPrinter = new RazorPrinter("레이져프린터", "앱송", "종이다잘려1", 2000);

		inkjetPrinter1.turnOn();
		razorPrinter.turnOn();

		inkjetPrinter1.turnOff();
		razorPrinter.turnOff();

		inkjetPrinter1.print();
		razorPrinter.print();

		// 실습 : DotPrinter
		// 분류 : 도트, 회사명: HP, 이름:나오다말다, 가격:500 도트 프린터생성
		// 프린터를 켜고 > 출력하고 > 끄고

		IPrinter dotPrinter1 = new DotPrinter("도트프린터", "HP", "나오다말다", 500);

		dotPrinter1.turnOn();
		dotPrinter1.print();
		dotPrinter1.turnOff();

		// 실습 : 프린터 500개를 생성
		// 잉크젯, 레이져, 도트의 비율을 4:4:2로 생성
		// 만들어진 모든 프린터를 켜고, 출력하고 끄기

//		int printerNum = 500;
//		IPrinter[] printerArr = new IPrinter[printerNum]; 
//		
//		
//		for(int i =0; i < printerNum; i++) {
//			if(i < 200) {
//				printerArr[i] = new InkjetPrinter("잉크젯프린터", "삼송", "잉크안먹혀"+ i, 1000);
//			} else if (200 < i && i < 400 ) {
//				printerArr[i] = new RazorPrinter("레이져프린터", "앱송", "종이다잘려" + i, 2000);
//			}else {
//				printerArr[i] = new DotPrinter("도트프린터", "HP", "나오다말다" + i, 500);
//			}
//			printerArr[i].turnOn();
//			printerArr[i].print();
//			printerArr[i].turnOff();
//		}
		
		IPrinter printer = new InkjetPrinter("잉크젯프린터", "삼송", "잉크안먹혀", 1000);
		System.out.println(printer instanceof IPrinter); // true
		System.out.println(printer instanceof AbstractPrinter); // true
		System.out.println(printer instanceof InkjetPrinter); // true
		System.out.println(printer instanceof RazorPrinter); // false
		System.out.println(printer instanceof DotPrinter); // false
		
		// 실습 : 프린터 500000개를 생성
		// 잉크젯, 레이져, 도트의 비율을 4:4:2로 생성
		// 만들어진 모든 프린터를 켜고, 출력하고 끄기
		// 생성한 잉크젯, 레이져, 도트 프린터 각각의 개수를 출력

		int printerNum = 500000;
		IPrinter[] printerArr = new IPrinter[printerNum];
		
		
		// 잉크젯 40% 생성, 레이져 40% 생성, 도트 20%생성
		for (int i = 0; i < printerNum; i++) {
			if (i < printerNum * 0.4) {
				printerArr[i] = new InkjetPrinter("잉크젯프린터", "삼송", "잉크안먹혀" + i, 1000);
			} else if (printerNum * 0.4 < i && i <= printerNum - printerNum * 0.2) {
				printerArr[i] = new RazorPrinter("레이져프린터", "앱송", "종이다잘려" + i, 2000);
			} else {
				printerArr[i] = new DotPrinter("도트프린터", "HP", "나오다말다" + i, 500);
			}
		}
		
		AbstractPrinter printerClone = new InkjetPrinter("잉크젯프린터", "삼송", "잉크안먹혀", 1000);
		
		
		// 프린터 갯수 확인 0번 = InkjetPrinter, 1번 = RazorPrinter, 2번 = DotPrinter
		int[] printerNumArr = { 0, 0, 0 };			
		for(int i = 0; i <printerNum; i++) {
			if(printerArr[i] instanceof InkjetPrinter) printerNumArr[0]++;
			else if (printerArr[i] instanceof RazorPrinter) printerNumArr[1]++;
			else if (printerArr[i] instanceof DotPrinter) printerNumArr[2]++;
		}
		
		System.out.printf("잉크젯 프린터는 : %d개, 레이져프린터는 : %d개, 도트프린터: %d개", 
				printerNumArr[0], printerNumArr[1], printerNumArr[2]);
	} // main
} // class
