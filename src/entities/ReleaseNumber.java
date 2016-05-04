package entities;

import java.io.Serializable;
/**
 * The Class to keep track of the Release Number state. 
 * @author
 *
 */
public class ReleaseNumber implements Serializable {
	int color; // 0 to 2
	int num;
	/**
	 * Release Number has a color(0, 1, 2) and number (1,2,3,4,5,6) and appears on Tiles in Release Levels.
	 * @param color The color of the Release Number.
	 * @param num The number of the Release Number.
	 */
	public ReleaseNumber(int color, int num){
		this.color = color;
		this.num = num;
	}
	/**
	 * Gets the color of the Release Number.
	 * @return The Release Number Color.
	 */
	public int getColor(){
		return color;
	}
	/**
	 * Sets the color of the Release Number.
	 * @param color The color to set the Release Number.
	 */
	public void setColor(int color){
		this.color = color;
	}
	/**
	 * Gets the number of the Release Number.
	 * @return The Number of the Release Number.
	 */
	public int getNum(){
		return num;
	}
	/**
	 * Sets the number of the Release Number.
	 * @param num The Number to set for the Release Number.
	 */
	public void setNum(int num){
		this.num = num;
	}
}