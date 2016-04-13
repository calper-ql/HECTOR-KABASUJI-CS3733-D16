package builder;

import boundry.WindowManager;
import controllers.MainController;

public class Builder {

	public static void main(String[] args) {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(new MainController());

	}

}