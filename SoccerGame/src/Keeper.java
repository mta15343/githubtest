import java.util.Random;

public class Keeper extends Player {
	private int reaction; // from 1 to 10
	
	
	public Keeper(String n, int a, int s, int sh, int m, int r) {
		super(n, a, s, sh, m);
		this.reaction = r;
	}
	
	public int getReaction(){
		return reaction;
	}
	
	public void setReaction(int r){
		reaction = r;
	}
	
	// Keeper functions:
	// the strength of the shot is passed as parameter
	// it has to be decided if the Keeper get it or not 
	public boolean saveShot(int shot){
		Random r = new Random();
		// +-1 as little randomness
		int ret = Math.max(1, Math.min(10, reaction + r.nextInt(3)-1));
		if (ret>=shot)
			return true; // saved
		else
			return false; // GOOOOOOAL!!!
	}
}
