
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
	
	//adds picked number to list of player picks on their betcard
	public void addPick(int i) {
		bc.getNumsPicked().add(i);
	}

	public void setTotalWinnings(int newTotal) {
		totalWinnings = newTotal;
	}
	
	public void incWinnings(int inc) {
		totalWinnings += totalWinnings + inc;
	}
}
