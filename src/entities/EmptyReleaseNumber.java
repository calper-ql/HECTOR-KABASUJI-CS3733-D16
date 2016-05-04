package entities;

import java.io.Serializable;
/**
 * Class to Set up the Empty Release Numbers that will be in all Tiles without Release Numbers.
 * @author Can Alper - calper@wpi.edu
 * @author Ryan Wiesenberg - rmwiesenberg@wpi.edu
 *
 */
public class EmptyReleaseNumber extends ReleaseNumber implements Serializable {
	/**
	 * Empty Release number takes no arguments in its constructor. 
	 */
	public EmptyReleaseNumber(){
		super(0, 0);
		
	}
	
	/**
	 * Returns the Color of the Empty Release Number.
	 * @return The color of the Empty Release Number is always 0.
	 */
	public int getColor(){
		return this.color;
	}
	
	/**
	 * Sets the Color of the Empty Release Number, which is nothing.
	 * @param color The color to set the Empty Release Number as.
	 */
	public void setColor(String color){
	}
	
	/**
	 * Gets the Number in the Empty Release Number. Is always 0.
	 */
	public int getNum(){
		return 0;
	}
	
	/**
	 * Sets the Number of the Empty Release Number. Does not set anything for Release Number. 
	 */
	public void setNum(int num){
	}
}
