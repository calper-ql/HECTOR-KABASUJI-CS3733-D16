package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.io.Serializable;
/**
 * Class to Store the Sets of Release Numbers and their states.
 * @author Can Alper - calper@wpi.edu
 * @author Zach Armsby - zrarmsby@wpi.edu
 * @author Mike Harney - mdharney@wpi.edu
 * @author Ryan Wiesenberg - rmwiesenberg@wpi.edu
 *
 */
public class ReleaseNumberSet implements Serializable{
	int color;
	LinkedList<ReleaseNumber> numbers = new LinkedList<ReleaseNumber>();
	/**
	 * 
	 * @param color
	 * @param numbers
	 */
	public ReleaseNumberSet(int color, LinkedList<ReleaseNumber> numbers){
		this.color = color;
		this.numbers = numbers;
	}
	/**
	 * Gets the color associated with a Release Number Set.
	 * @return The color of the Release Number Set.
	 */
	public int getColor(){
		return color;
	}
	/**
	 * Determines if a Release Number set is a complete set. A complete set consists of 1 through 6 of the same color released from the Release Level board.
	 * @return True if the set is complete. False if it is incomplete.
	 */
	public boolean isComplete(){
		boolean con1 = false;
		boolean con2 = false;
		boolean con3 = false;
		boolean con4 = false;
		boolean con5 = false;
		boolean con6 = false;
		
		for(int i = 0; i < numbers.size(); i++){
			con1 |= (numbers.get(i).getNum() == 1);
			con2 |= (numbers.get(i).getNum() == 2);
			con3 |= (numbers.get(i).getNum() == 3);
			con4 |= (numbers.get(i).getNum() == 4);
			con5 |= (numbers.get(i).getNum() == 5);
			con6 |= (numbers.get(i).getNum() == 6);
			
		}
		
		return con1 & con2 & con3 & con4 & con5 & con6;
	}
	/**
	 * Adds a Release Number to a Release Number set.
	 * @param number The Release Number to add to the Release Number set.
	 * @return True if the number was successfully added. False if it was not added successfully.
	 */
	public boolean addNumber(ReleaseNumber number){
		if (number.getColor() == color){
			numbers.add(number);
			return true;
		} else return false;
	}
	/**
	 * Removes a specified Release Number from the Release Number Set.
	 * @param number The number to remove from the Release Number Set.
	 * @return True if the number was successfully removed. False if it was not removed successfully.
	 */
	public boolean removeNumber(ReleaseNumber number){
		return numbers.remove(number);
	}
	/**
	 * Reset the Release Number Set to have no Release Numbers.
	 */
	public void resetSet(){
		numbers.clear();
	}
}
