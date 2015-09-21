import java.util.Random;

public class FriendlySoccerMatch implements FriendlyMatch {

	private String nameHomeTeam;
	private String nameGuestTeam;
	private int pointsHome;
	private int pointsGuest;

	// Constructor
	public FriendlySoccerMatch(){
		pointsHome = 0;
		pointsGuest = 0;
	}
	
	@Override
	public String getHomeTeam() {
		return nameHomeTeam;
	}

	@Override
	public String getGuestTeam() {
		return nameGuestTeam;
	}

	@Override
	public int getHomePoints() {
		return pointsHome;
	}

	@Override
	public int getGuestPoints() {
		return pointsGuest;
	}

	@Override
	public String getResultText() {
		return "The friendly game ends with		\n\n"+nameHomeTeam+" - "+nameGuestTeam +" "+pointsHome+":"+pointsGuest+".";
	}

	public void startGame(Team t1, Team t2){
		nameHomeTeam = t1.getName();
		nameGuestTeam = t2.getName();
		pointsHome = 0;
		pointsGuest = 0;

		// now the game can begin; we have to create for the 
		// 90 minutes + extra time the different actions 
		Random r = new Random();
		boolean gameruns = true;
		int gameduration = 90 + r.nextInt(5);
		int time = 1;
		int nextAction = 0;
		
		// while the game runs, goals can be scored
		while (gameruns){
			nextAction = r.nextInt(15)+1;
			// Is the game over?
			if ((time + nextAction > gameduration) || (time > gameduration)){
				gameruns = false;
				break;
			}
			//*******************************************
			// A new action can take place ...
			time = time + nextAction;
		
			// influence of motivation on strength:
			float strength_1 = (t1.getStrength()/2.0f) + ((t1.getStrength()/2.0f)*(t1.getMotivation()/10.0f));
			float strength_2 = (t2.getStrength()/2.0f) + ((t2.getStrength()/2.0f) * (t2.getMotivation()/10.0f));
		
			// influence of trainer on strength:
			int deviation = r.nextInt(2);
			if (strength_1 > t1.getTrainer().getExperience())
				deviation = -deviation;
			strength_1 = Math.max(1, Math.min(10, strength_1 + deviation));
			deviation = r.nextInt(2);
			if (strength_2 > t2.getTrainer().getExperience())
				deviation = -deviation;
			strength_2 = Math.max(1, Math.min(10, strength_2 + deviation));
		
			// randomly choose a player for next shot
			int shooter = r.nextInt(10);
			if ((r.nextInt(Math.round(strength_1+strength_2))-strength_1)<=0){
				Player p = t1.getPlayers()[shooter];
				Keeper k = t2.getKeeper();
				int shot = p.shootsOnGoal();
				// check if shot is saved
				boolean goal = !k.saveShot(shot);
				System.out.println();
				System.out.println(time+".Minute: ");
				System.out.println(" Chance for "+t1.getName()+" ...");
				System.out.println(" "+p.getName()+" shoots");
				if (goal) {
					pointsHome++;
					p.addGoal();
					System.out.println(" Goal!!! "+pointsHome+":"+
					pointsGuest+" "+p.getName()+"("+p.getGoals()+")");
					} 
				else {
					System.out.println(" "+t2.getKeeper().getName()
					+" saves briliantly.");
				}
			} // IF 
			else{
				Player p = t2.getPlayers()[shooter];
				Keeper k = t1.getKeeper();
				int shot = p.shootsOnGoal();
				boolean goal = !k.saveShot(shot);
				System.out.println();
				System.out.println(time+".Minute: ");
				System.out.println(" Chance for "+t2.getName()+" ...");
				System.out.println(" "+p.getName()+" shoots");
				
				if (goal) {
					pointsGuest++;
					p.addGoal();
					System.out.println(" GOAL!!! "+pointsHome+":"+ pointsGuest+" "+p.getName()+"("+p.getGoals()+")");
				} 
				else {
					System.out.println(" "+t1.getKeeper().getName()
					+" saves brilliantly.");
				}
			} // else 
		} //WHILE
	}

}
