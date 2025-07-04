package pub2504.excollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerMain {

	private static List<String> cardShape = Arrays.asList("♠️", "♦️", "♥️", "♣️");
	private static List<Integer> cardNum = Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14);
	private static List<Card> card = new ArrayList<Card>();
	private static List<Player> playerList = new ArrayList<Player>();
	
	public static void main(String[] args) {
		
		// set 으로 중복되지 않는 카드객체들 만들기
		for(int i=0; i<cardShape.size(); i++) {
			for(int j=0; j< cardNum.size(); j++) {
				card.add(new Card(cardShape.get(i),cardNum.get(j)));
			}
		}
		// 게임 새로 시작할 때 카드 섞기
		Collections.shuffle(card);
		
		playerList.add(makePerson("홍길동", 0));
		playerList.add(makePerson("강감찬", 1));
		playerList.add(makePerson("이순신", 2));
		playerList.add(makePerson("권율", 3));
		playerList.add(makePerson("최영", 4));
		
	     // 플레이어가 가진 7장 카드의 숫자, 무늬 카운팅
	      for (int i=0; i<playerList.size(); i++) {
	         Player player = playerList.get(i); 
	         for (Card card : playerList.get(i).getCardList()) {
	            player.getNumCountMap().put(card.getNum(), 
	            player.getNumCountMap().get(card.getNum()) + 1);
	            player.getShapeCountMap().put(card.getShape(), 
	            player.getShapeCountMap().get(card.getShape()) + 1);
	         }
	      }
		
	     playerList.stream().forEach(
	    		 player->{
	    			System.out.println(player); 
	    			printResult(player);
	    		 });
		
	} // main
	
	
	// 카드 만들기
	public static List<Card> makeCard(Integer number) {
		return card.stream()
				.skip((number+1)*7-7)
				.limit(7)
				.toList();
	} // makeCard()
	
	// 유저 만들기
	public static Player makePerson(String name, Integer number) {
		return new Player(name, makeCard(number));
	}; // makePerson()
	
	// 결과 찍기
	private static void printResult(Player player) {
	      String resultStr = "";
	      if (PokerRule.isRoyalStraightFlush(player)) resultStr = "[로열스트레이트플러시]";
	      else if (PokerRule.isStraightFlush(player)) resultStr = "[스트레이트플러시]";
	      else if (PokerRule.isFourCard(player)) resultStr = "[포카드]";
	      else if (PokerRule.isFullHouse(player)) resultStr = "[풀하우스]";
	      else if (PokerRule.isFlush(player)) resultStr = "[플러시]";
	      else if (PokerRule.isStraight(player)) resultStr = "[스트레이트]";
	      else if (PokerRule.isTriple(player)) resultStr = "[트리플]";
	      else if (PokerRule.isTwoPair(player)) resultStr = "[투 페어]";
	      else if (PokerRule.isOnePair(player)) resultStr = "[원 페어]";
	      else resultStr = "[족보 없음]";
	      System.out.println(resultStr+"\n");
	   } // printResult()
	
	
} // class













