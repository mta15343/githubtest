
public class Trainer extends Person {
	private int experience; // from 1 to 10
	
	// Constructor
	public Trainer(String n, int a, int e){
		super(n, a); // calls constructor of class from which name and age are inherited
		experience = e;
	}
	
	public int getExperience(){
		return experience;
	}
	
	public void setExperience(int e){
		experience = e;
	}	
}
