
public class Team {
	// Features of a Team:
		private String name;
		private Trainer trainer;
		private Keeper keeper;
		private Player[] players;

		// Constructor
		public Team(String n, Trainer t, Keeper k, Player[] p){
		  name = n;
		  trainer = t;
		  keeper = k;
		  players = p;
		}

		public String getName(){
			return this.name;
		}
		
		public void setName(String n){
			name = n;
		}
		
		public Trainer getTrainer(){
			return trainer;
		}
		
		public void setTrainer(Trainer t){
			trainer = t;
		}
		
		public Keeper getKeeper(){
			return keeper;
		}
		
		public void setKeeper(Keeper k){
			keeper = k;
		}
		
		public Player[] getPlayers(){
			return players;
		}
		
		public void setPlayers (Player[] p){
			players = p;
		}
		
		// Team functions:
		// returns the average team strength
		public int getStrength(){
		  int summ = 0;
		  for (int i=0; i<10; i++)
			summ += players[i].getStrength();
		  return summ/10;
		}

		// returns the average team motivation
		public int getMotivation(){
		  int summ = 0;
		  for (int i=0; i<10; i++)
			summ += players[i].getMotivation();
		  return summ/10;
		}
}
