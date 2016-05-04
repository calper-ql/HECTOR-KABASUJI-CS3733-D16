package boundary.release;

import javax.swing.JPanel;

import boundary.BuilderBaseLevelView;
import boundary.puzzle.BuilderPuzzleLevelView;
import controllers.release.BuilderReleaseLevelController;

public class BuilderReleaseLevelView extends BuilderBaseLevelView {

	public BuilderReleaseLevelView(BuilderReleaseLevelController builderReleaseLevelController) {
		super();
	}
	
	public JPanel render(){
		JPanel renderPanel = super.render();
		
		return renderPanel;
	}

}
