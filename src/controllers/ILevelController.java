/**ILevelController
 * Requires that all classes with the ILevelController interface, have the 
 * piecePressed(JBlockPanel jBlockPanel), and pieceReleased(JBlockPanel jBlockPanel) methods
 * 
 * @author
 */
package controllers;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JLayeredPane;

import boundary.JBlockPanel;
import entities.Tile;

public interface ILevelController {
	public void piecePressed(JBlockPanel jBlockPanel);
	public void pieceReleased(JBlockPanel jBlockPanel);
	public void requestReRender();
	public void requestReRenderBack();
	public void stateUpdated();
}
