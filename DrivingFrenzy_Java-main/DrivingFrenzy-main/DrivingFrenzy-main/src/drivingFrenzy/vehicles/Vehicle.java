package drivingFrenzy.vehicles;

import drivingFrenzy.race.Section;

/**
 * @author ismael Vehicles can be of various types. All of them share in common
 *         that they can receive what is the next track so the pilot decides
 *         what to do.
 */
public interface Vehicle {

	/**
	 * @return the number of the vehicle in the race
	 */
	public int getNumber();
	
	/**
	 * @return the pilot name
	 */
	public String getDriver();
	
	/**
	 * @return a description of the vehicle
	 */
	public String getDescription();

	
	/**
	 * @return the current speed in km/h
	 */
	public int getCurrentSpeed();
	
	/**
	 * @return the max speed in km/h
	 */
	public int getMaxSpeed();

	/**
	 * It receives what is the next section, so it can adapt the speed. It returns,
	 * as a String, the result of the operation in a commentator-way.
	 * 
	 * @param nextSection
	 * @return 
	 */
	public String adaptSpeed(Section nextSection);

/*void adaptSpeed(double newSpeed);*/

	public int increaseGear();
	public int decreaseGear();
}
