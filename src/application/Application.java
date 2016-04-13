package application;

import javax.swing.JLabel;
import javax.swing.JPanel;

import boundary.MainMenuView;
import boundary.SplashScreenView;
import boundary.WindowManager;
import controllers.GameMainController;
import controllers.MainController;
import controllers.SplashScreenController;
import entities.SplashScreen;

public class Application {

	public static void main(String[] args) {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(new GameMainController());
	}

}
