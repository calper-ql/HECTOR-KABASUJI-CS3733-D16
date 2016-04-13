package application;

import javax.swing.JLabel;
import javax.swing.JPanel;


import boundry.MainMenuView;
import boundry.SplashScreenView;
import boundry.WindowManager;
import controllers.SplashScreenController;
import entities.SplashScreen;

public class Application {

	public static void main(String[] args) {
		WindowManager wmg = new WindowManager(0, 0, 640, 535);
		wmg.link(new MainController());
	}

}
