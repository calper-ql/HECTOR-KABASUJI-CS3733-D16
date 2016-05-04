/**IController
 * Requires that all classes with the IController interface, have the getRenderedView()
 * 
 * @author Can Alper - calper@wpi.edu 
 */
package controllers;

import javax.swing.JPanel;

public interface IController {
	JPanel getRenderedView();
}
