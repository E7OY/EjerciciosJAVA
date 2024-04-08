package drivingFrenzy.race;


/**
 * @author ismael
 * This type of section is not affected by climate or any effects. 
 */
public class StandardIndoorSection implements Section{

	private int length;
	private String description;
	private int theoreticalMaxSpeed;
	
	
	
	public StandardIndoorSection(int length, String description, int theoreticalMaxSpeed) {
		super();
		this.length = length;
		this.description = description;
		this.theoreticalMaxSpeed = theoreticalMaxSpeed;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getTheoreticalMaxSpeed() {
		return theoreticalMaxSpeed;
	}

	@Override
	public int getCurrentMaxSpeed() {
		return theoreticalMaxSpeed;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
