/**Builder Release Level View
 * This Boundary class handles the views of all compoents specific to the release level in the Level Builder application
 * @author
 */
package boundary.release;

import javax.swing.JPanel;

import boundary.BuilderBaseLevelView;
import boundary.puzzle.BuilderPuzzleLevelView;
import controllers.release.BuilderReleaseLevelController;

public class BuilderReleaseLevelView extends BuilderBaseLevelView {

	/**
	 * Class constructor
	 * @param builderReleaseLevelController
	 */
	public BuilderReleaseLevelView(BuilderReleaseLevelController builderReleaseLevelController) {
		super();
	}
	
	/**
	 * Renders the panel necessary to display a view for the release display
	 * @return renderPane1
	 */
	public JPanel render(){
		JPanel renderPanel = super.render();
		
		return renderPanel;
	}

}
