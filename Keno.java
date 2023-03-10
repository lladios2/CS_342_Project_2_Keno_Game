
public class Keno {

	private boolean inPlay;
	private Player p;
	
	public Keno() {
		inPlay = true;
		p = new Player();
	}
	
	public int calcWinnings() {
		int roundWinnings= 0;
		
		p.incWinnings(roundWinnings);
		
		return roundWinnings;
	}
	
	private void countMatches() {
		
	}
	
	private void randDraw() {
		
	}
}
