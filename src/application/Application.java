package application;

import javax.swing.JLabel;
import javax.swing.JPanel;

import boundry.MainBoundry;
import boundry.MainMenuView;
import boundry.SplashScreenView;
import controllers.SplashScreenController;
import entities.MainMenu;
import entities.SplashScreen;

public class Application {
	static MainBoundry bnd;
	static SplashScreen sp;
	static SplashScreenView spw;
	static SplashScreenController spc;
	
	public static void initializeEntity(){
		sp = new SplashScreen(false);
	}
	
	public static void initializeBoundry(){
		bnd = new MainBoundry(100, 100, 640, 535);
		spw = new SplashScreenView(sp);
	}

	public static void initializeController(){
		spc = new SplashScreenController(sp, spw);
	}
	
	public static void main(String[] args) {
		initializeEntity();
		initializeBoundry();
		initializeController();
		bnd.swap(spc.getRenderedView());
		System.out.println("Yolo");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bnd.swap(new MainMenuView(new MainMenu()).render());
		
	}

}
