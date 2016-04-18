package application;

import boundary.WindowManager;
import controllers.GameMainController;

public class Application {

	public static void main(String[] args) {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(new GameMainController());
	}

}
