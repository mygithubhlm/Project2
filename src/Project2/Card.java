package Project2;

public class Card {
	//cardµÄÊôĞÔ
	private String name;
	private int num;

	public Card() {
	}

	public Card(String cardName) {
		this.name = cardName;
	}

	public void setNum() {
		num++;
	}

	public void reduceNum() {
		num--;
	}

	public int getNum() {
		return num;
	}

	public void SetName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// File read
	public void readName(String name) {
		this.name = name;
	}

	public void readNum(int num) {
		this.num = num;
	}

}
