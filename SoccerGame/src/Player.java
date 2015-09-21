import java.util.Random;
public class Player extends Person {
	private int strength; // from 1 to 10
	private int shots; // from 1 to 10
	private int motivation; // from 1 to 10
	private int goals; // number goals scored by this player
	
	public Player(String n, int a, int s, int sh, int m) {
		super(n, a);
		strength = s;
		shots = sh;
		motivation = m;
		goals = 0;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public void setStrength(int s){
		strength = s;
	}
	
	public int getShots(){
		return shots;
	}
	
	public void setShots(int s){
		shots = s;
	}
	
	public int getMotivation(){
		return motivation;
	}
	
	public void setMotivation(int m){
		motivation = m;
	}
	
	public int getGoals(){
		return goals;
	}
	
	public void setGoals(int g){
		goals = g;
	}	
	
	// Player functions:
	// Player scored a goal
	public void addGoal(){
		goals++;
	}

	// a number from 1-10 defines the quality of the shot varied by a little
	// randomness (+1 or -1)
	public int shootsOnGoal(){
		Random r = new Random();
		shots = Math.max(1, Math.min(10, shots - r.nextInt(3)));
		int ret = Math.max(1, Math.min(10, shots + r.nextInt(3)-1));
		return ret;
	}
}
