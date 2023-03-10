import java.util.ArrayList;

public class BetCard {

	private int numSpots;
	private int numDraws;
	private ArrayList<Integer> numsPicked;
	
	public BetCard() {
		numSpots = 0;
		numDraws = 0;
		numsPicked = new ArrayList<Integer>();
	}
	
	public int getNumSpots(){
		return numSpots;
	}
	
	public void setNumSpots(int n) {
		numSpots = n;
	}
	
	public int getNumDraws() {
		return numDraws;
	}
	
	public void setNumDraws(int n) {
		numDraws = n;
	}
	
	public ArrayList<Integer> getNumsPicked(){
		return numsPicked;
	}

	public void addPickedNum(int n) {
		numsPicked.add(n);
	}
	
	
}
