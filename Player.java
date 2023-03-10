
public class Player {

	private int totalWinnings;
	private BetCard bc;
	
	public Player() {
		totalWinnings = 0;
		bc = new BetCard();
	}
	
	public int getWinnings() {
		return totalWinnings;
	}

	public void setTotalWinnings(int newTotal) {
		totalWinnings = newTotal;
	}
	
	public void incWinnings(int inc) {
		totalWinnings += totalWinnings + inc;
	}
}
