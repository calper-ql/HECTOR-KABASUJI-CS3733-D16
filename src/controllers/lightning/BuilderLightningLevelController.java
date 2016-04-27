package controllers.lightning;

import javax.swing.JPanel;

import boundary.JBlockPanel;
import controllers.BuilderLevelSelectController;
import controllers.IController;
import controllers.ILevelController;
import controllers.MainController;
import entities.Model;

public class BuilderLightningLevelController implements IController, ILevelController {

	public BuilderLightningLevelController(MainController mc, BuilderLevelSelectController builderLevelSelectController,
			Model model, int i) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public JPanel getRenderedView() {
		// TODO Auto-generated method stub
		return new JPanel();
	}

	@Override
	public void piecePressed(JBlockPanel jBlockPanel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pieceReleased(JBlockPanel jBlockPanel) {
		// TODO Auto-generated method stub
		
	}

}
