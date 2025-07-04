package pub2504.excollection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

	private String name;
	private List<Card> cardList;
	private Map<Integer, Integer> numCountMap; // 숫자카운트맵
	private Map<String, Integer> shapeCountMap; // 무늬카운트맵

	public Player() {
	}

	public Player(String name, List<Card> cardList) {
		this.name = name;
		this.cardList = cardList;
		this.numCountMap = new HashMap<Integer, Integer>();
		this.shapeCountMap = new HashMap<String, Integer>();
		
		for (int i = 2; i < 15; i++) {
			numCountMap.put(i, 0);
		}
		shapeCountMap.put("♠️", 0);
		shapeCountMap.put("♦️", 0);
		shapeCountMap.put("♥️", 0);
		shapeCountMap.put("♣️", 0);
	}

	public Map<Integer, Integer> getNumCountMap() {
		return numCountMap;
	}

	public void setNumCountMap(Map<Integer, Integer> numCountMap) {
		this.numCountMap = numCountMap;
	}

	public Map<String, Integer> getShapeCountMap() {
		return shapeCountMap;
	}

	public void setShapeCountMap(Map<String, Integer> shapeCountMap) {
		this.shapeCountMap = shapeCountMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	@Override
	public String toString() {
		return name + " " + cardList + "\n" + numCountMap + "\n" + shapeCountMap;
	}
}
