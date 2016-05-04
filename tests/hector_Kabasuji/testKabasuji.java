package hector_Kabasuji;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import javax.imageio.ImageIO;
import generators.*;
import boundary.*;
import controllers.*;
import controllers.puzzle.*;
import controllers.release.*;
import controllers.lightning.*;
import entities.*;
import kabasuji.application.*;
import kabasuji.builder.*;
import move.*;
import junit.framework.TestCase;

public class testKabasuji extends TestCase {
	Application game;
	Builder builder;
	GameMainController mcon;
	BuilderMainController bcon;
	Model model;
	Model bmodel;
	LinkedList<Level> initLevel;
	Robot minime;
	DefinedPieces dp;

	/*
	 * IMPORTANT, When any changes are made in the entities, you need to re
	 * generate them. Do this by running the BaseLevelGenerator.java file,
	 * MANUALLY!
	 * 
	 * 
	 * 
	 */

	protected void setUp() throws Exception {
		game = new Application();
		builder = new Builder();
		mcon = new GameMainController(game);
		bcon = new BuilderMainController(builder); 
		model = game.getModel();
		bmodel = builder.getModel();
		model.reload();
		bmodel.reload();
		minime = new Robot();
		dp = new DefinedPieces();
		saveInitialLevels();
	}

	// Start of Game Tests
	// Start of Entity Controllers
	// Piece Tests

	Piece p0 = new Piece(Color.black, -1);
	Block b0 = new Block(p0);
	Block b1 = new Block(p0);
	Block b2 = new Block(p0);
	Block b3 = new Block(p0);
	Block b4 = new Block(p0);
	Block b5 = new Block(p0);

	public void testPieceCreate() {
		b0.linkEast(b1);
		b1.linkEast(b2);
		b2.linkNorth(b3);
		b3.linkWest(b4);
		b3.linkNorth(b5);
		try {
			assertEquals(p0.getBlock(0).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getEast(), b1);
			assertEquals(p0.getBlock(0).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(1).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getEast(), b2);
			assertEquals(p0.getBlock(1).getWest(), b0);

			assertEquals(p0.getBlock(2).getNorth(), b3);
			assertEquals(p0.getBlock(2).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(2).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(2).getWest(), b1);

			assertEquals(p0.getBlock(3).getNorth(), b5);
			assertEquals(p0.getBlock(3).getSouth(), b2);
			assertEquals(p0.getBlock(3).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(3).getWest(), b4);

			assertEquals(p0.getBlock(4).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getEast(), b3);
			assertEquals(p0.getBlock(4).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(5).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getSouth(), b3);
			assertEquals(p0.getBlock(5).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getWest().isValidBlock(), false);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			p0.getBlock(6).getNorth().isValidBlock();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Not a valid getBlock request");
		}
	}

	public void testPieceFlip() {
		b0.linkEast(b1);
		b1.linkEast(b2);
		b2.linkNorth(b3);
		b3.linkWest(b4);
		b3.linkNorth(b5);
		b4.flip(true);

		try {
			assertEquals(p0.getBlock(0).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getWest(), b1);

			assertEquals(p0.getBlock(1).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getEast(), b0);
			assertEquals(p0.getBlock(1).getWest(), b2);

			assertEquals(p0.getBlock(2).getNorth(), b3);
			assertEquals(p0.getBlock(2).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(2).getEast(), b1);
			assertEquals(p0.getBlock(2).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(3).getNorth(), b5);
			assertEquals(p0.getBlock(3).getSouth(), b2);
			assertEquals(p0.getBlock(3).getEast(), b4);
			assertEquals(p0.getBlock(3).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(4).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getWest(), b3);

			assertEquals(p0.getBlock(5).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getSouth(), b3);
			assertEquals(p0.getBlock(5).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getWest().isValidBlock(), false);
		} catch (Exception e) {

		}
	}

	public void testPieceRotateCounterClockwise() {
		b0.linkEast(b1);
		b1.linkEast(b2);
		b2.linkNorth(b3);
		b3.linkWest(b4);
		b3.linkNorth(b5);
		b0.rotate(true);

		try {
			assertEquals(p0.getBlock(0).getNorth(), b1);
			assertEquals(p0.getBlock(0).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(1).getNorth(), b2);
			assertEquals(p0.getBlock(1).getSouth(), b0);
			assertEquals(p0.getBlock(1).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(2).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(2).getSouth(), b1);
			assertEquals(p0.getBlock(2).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(2).getWest(), b3);

			assertEquals(p0.getBlock(3).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(3).getSouth(), b4);
			assertEquals(p0.getBlock(3).getEast(), b2);
			assertEquals(p0.getBlock(3).getWest(), b5);

			assertEquals(p0.getBlock(4).getNorth(), b3);
			assertEquals(p0.getBlock(4).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(5).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getEast(), b3);
			assertEquals(p0.getBlock(5).getWest().isValidBlock(), false);
		} catch (Exception e) {

		}
	}

	public void testPieceRotateClockwise() {
		b0.linkEast(b1);
		b1.linkEast(b2);
		b2.linkNorth(b3);
		b3.linkWest(b4);
		b3.linkNorth(b5);
		b0.rotate(false);

		try {
			assertEquals(p0.getBlock(0).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getSouth(), b1);
			assertEquals(p0.getBlock(0).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(1).getNorth(), b0);
			assertEquals(p0.getBlock(1).getSouth(), b2);
			assertEquals(p0.getBlock(1).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(2).getNorth(), b1);
			assertEquals(p0.getBlock(2).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(2).getEast(), b3);
			assertEquals(p0.getBlock(2).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(3).getNorth(), b4);
			assertEquals(p0.getBlock(3).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(3).getEast(), b5);
			assertEquals(p0.getBlock(3).getWest(), b2);

			assertEquals(p0.getBlock(4).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getSouth(), b3);
			assertEquals(p0.getBlock(4).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getWest().isValidBlock(), false);

			assertEquals(p0.getBlock(5).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getWest(), b3);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void testDefinedPieces() {
		assertEquals(dp.getPieces().size(), 35);
	}

	// Level Tests
	public void testLevel() {
		Level lev1 = model.getLevel(1);
		lev1.resetLevel();
		assertEquals(lev1.getLevelNum(), 1);

		assertEquals(lev1.isLocked(), false);
		lev1.unlock();
		assertEquals(lev1.isLocked(), false);
		assertEquals(lev1.getLevelNum(), 1); // wtf is going on here?

		lev1.unlock();
		assertEquals(lev1.isLocked(), false);
		lev1.lock();
		assertEquals(lev1.isLocked(), true);

		assertEquals(lev1.getStars(), 0);
		lev1.setStars(2);
		assertEquals(lev1.getStars(), 2);
		lev1.setStars(1);
		assertEquals(lev1.getStars(), 2);
		lev1.resetLevel();
		assertEquals(lev1.getStars(), 0);

		assertEquals(lev1.getEmptyTileCount(), 144);
		lev1.getBoard().getTile(2, 5).disable();
		assertEquals(lev1.getEmptyTileCount(), 143);
		assertEquals(lev1.getBullpen().getSize(), 0);
	}

	public void testPuzzleLevel() {
		PuzzleLevel pl = (PuzzleLevel) model.getLevel(1);
		pl.resetLevel();

		pl.setTotalMoves(2);
		pl.setRemaingMoves(2);
		assertEquals(pl.hasFinished(), false);
		pl.updateStars();
		assertEquals(pl.getStars(), 0);

		pl.setRemaingMoves(0);
		pl.disableAllTiles();

		assertEquals(pl.hasFinished(), true);
		pl.updateStars();
		assertEquals(pl.getStars(), 3);

		reloadLevels();
	}

	public void testLightningLevel() {
		LightningLevel ll = (LightningLevel) model.getLevel(6);
		ll.resetLevel();

		ll.forceStars(0);

		ll.setTotalTime(2);
		ll.setTimeRemaining(2);
		assertEquals(ll.hasFinished(), false);
		ll.updateStars();
		assertEquals(ll.getStars(), 0);

		ll.setTimeRemaining(0);
		ll.disableAllTiles();

		assertEquals(ll.hasFinished(), true);
		ll.updateStars();
		assertEquals(ll.getStars(), 3);
	}

	public void testReleaseLevel() {
		ReleaseLevel rl = (ReleaseLevel) model.getLevel(11);
		rl.resetLevel();

		rl.getBullpen().addPiece(p0);

		LinkedList<ReleaseNumber> rnl = new LinkedList<ReleaseNumber>();
		for (int c = 0; c < 3; c++) {
			for (int n = 0; n <= 6; n++) {
				rnl.add(new ReleaseNumber(c, n));
			}
		}

		rl.resetSets();
		assertEquals(rl.hasFinished(), false);
		rl.updateStars();
		assertEquals(rl.getStars(), 0);

		for (int i = 0; i < rnl.size(); i++) {
			ReleaseNumber n = rnl.get(i);
			rl.addReleaseNumber(n);
		}

		assertEquals(rl.hasFinished(), true);
		rl.updateStars();
		assertEquals(rl.getStars(), 3);
	}

	public void testAchievements() throws InterruptedException {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(mcon);

		MainMenuController mmc = new MainMenuController(mcon, model);
		mmc.getRenderedView();
		click(70, 300);	
		clickBackButton();
	}

	// Boundary Test Cases

	// Controller Test Cases
	public void testSplashScreen() {
		SplashScreenController spc = new SplashScreenController(false);
		spc.getRenderedView();
		assertEquals(spc.get().getMainTitle(), "Kabasuji");
		clickBackButton();
	}

	public void testMainMenu() {
		MainMenuController mmc = new MainMenuController(mcon, model);
		mmc.getRenderedView();
	}

	public void testAchievementController() {
		MainMenuController mmc = new MainMenuController(mcon, model);
		AchievementController ac = new AchievementController(mcon, mmc);
		ac.getRenderedView();
		clickBackButton();
	}

	public void testLevelSelectController() {
		MainMenuController mmc = new MainMenuController(mcon, model);
		LevelSelectController lsc = new LevelSelectController(mcon, mmc, model);
		lsc.getRenderedView();

		PuzzleLevel pl = (PuzzleLevel) model.getLevel(1);
		pl.setTotalMoves(2);
		pl.setRemaingMoves(0);
		pl.disableAllTiles();
		pl.updateStars();
		PuzzleLevel pss;
		try {
			pss = (PuzzleLevel) pl.getFromFile(1);
			pss.setStars(pl.getStars());
			pss.saveToFile();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}

		LightningLevel ll = (LightningLevel) model.getLevel(6);
		ll.setTotalTime(2);
		ll.setTimeRemaining(0);
		ll.disableAllTiles();
		ll.updateStars();
		LightningLevel lss;
		try {
			lss = (LightningLevel) ll.getFromFile(6);
			lss.setStars(ll.getStars());
			lss.saveToFile();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}

		ReleaseLevel rl = (ReleaseLevel) model.getLevel(12);
		rl.getBullpen().addPiece(p0);
		LinkedList<ReleaseNumber> rnl = new LinkedList<ReleaseNumber>();
		for (int c = 0; c < 3; c++) {
			for (int n = 0; n <= 6; n++) {
				rnl.add(new ReleaseNumber(c, n));
			}
		}
		rl.resetSets();
		for (int i = 0; i < rnl.size(); i++) {
			ReleaseNumber n = rnl.get(i);
			rl.addReleaseNumber(n);
		}
		rl.updateStars();
		ReleaseLevel rss;
		try {
			rss = (ReleaseLevel) rl.getFromFile(11);
			rss.setStars(rl.getStars());
			rss.saveToFile();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}

		lsc.getRenderedView();
		reloadLevels();
		clickBackButton();
	}

	public void testPuzzleLevelController() throws Exception {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(mcon);

		MainMenuController mmc = new MainMenuController(mcon, model);
		LevelSelectController lsc = new LevelSelectController(mcon, mmc, model);
		PuzzleLevelController plc = new PuzzleLevelController(mcon, lsc, model, 1);
		model.getLevel(1).resetLevel();
		PuzzleLevel pl = (PuzzleLevel) model.getLevel(1);
		plc.getRenderedView();

		pl.getBullpen().addPiece(dp.getPiece(0));
		pl.getBullpen().addPiece(dp.getPiece(0));
		pl.getBullpen().addPiece(dp.getPiece(0));
		pl.setRemaingMoves(5);

		mcon.requestSwap(plc);

		int mask = InputEvent.BUTTON1_DOWN_MASK;
		minime.mouseMove(200 + 20, 200 + 200);
		Thread.sleep(500);
		minime.mousePress(mask);
		minime.mouseMove(200 + 300, 200 + 250);
		Thread.sleep(500);
		rotatePiece();
		minime.mouseRelease(mask);
		Thread.sleep(500);

		minime.mouseMove(200 + 20, 200 + 200);
		Thread.sleep(500);
		minime.mousePress(mask);
		minime.mouseMove(200 + 300, 200 + 250);
		Thread.sleep(500);
		rotatePiece();
		minime.mouseRelease(mask);
		Thread.sleep(500);

		minime.mouseMove(200 + 20, 200 + 200);
		Thread.sleep(500);
		minime.mousePress(mask);
		minime.mouseMove(200 + 300, 200 + 10);
		Thread.sleep(500);
		rotatePiece();
		minime.mouseRelease(mask);
		Thread.sleep(500);
		
		minime.mouseMove(200 + 300, 200 + 250);
		Thread.sleep(500);
		minime.mousePress(mask);
		Thread.sleep(500);
		minime.mouseRelease(mask);
		Thread.sleep(500);

		clickBackButton();
	}

	public void testLightningLevelController() {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(mcon);

		MainMenuController mmc = new MainMenuController(mcon, model);
		LevelSelectController lsc = new LevelSelectController(mcon, mmc, model);
		LightningLevelController llc = new LightningLevelController(mcon, lsc, model, 6);
		model.getLevel(6).resetLevel();
		LightningLevel ll = (LightningLevel) model.getLevel(6);
		llc.getRenderedView();

		ll.getBullpen().addPiece(dp.getPiece(0));
		ll.getBullpen().addPiece(dp.getPiece(0));
		ll.getBullpen().addPiece(dp.getPiece(0));
		ll.setTimeRemaining(60);

		mcon.requestSwap(llc);

		try {
			int mask = InputEvent.BUTTON1_DOWN_MASK;
			minime.mouseMove(200 + 20, 200 + 200);
			Thread.sleep(500);
			minime.mousePress(mask);
			minime.mouseMove(200 + 300, 200 + 250);
			Thread.sleep(500);
			rotatePiece();
			minime.mouseRelease(mask);
			Thread.sleep(500);

			minime.mouseMove(200 + 20, 200 + 200);
			Thread.sleep(500);
			minime.mousePress(mask);
			minime.mouseMove(200 + 300, 200 + 250);
			Thread.sleep(500);
			rotatePiece();
			minime.mouseRelease(mask);
			Thread.sleep(500);

			minime.mouseMove(200 + 20, 200 + 200);
			Thread.sleep(500);
			minime.mousePress(mask);
			minime.mouseMove(200 + 300, 200 + 10);
			Thread.sleep(500);
			rotatePiece();
			minime.mouseRelease(mask);
			Thread.sleep(500);
			
			minime.mouseMove(200 + 300, 200 + 250);
			Thread.sleep(500);
			minime.mousePress(mask);
			Thread.sleep(500);
			minime.mouseRelease(mask);
			Thread.sleep(500);
		} catch (Exception e) {

		}

		clickBackButton();
	}

	public void testReleaseLevelController() {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(mcon);

		MainMenuController mmc = new MainMenuController(mcon, model);
		LevelSelectController lsc = new LevelSelectController(mcon, mmc, model);
		ReleaseLevelController rlc = new ReleaseLevelController(mcon, lsc, model, 11);
		model.getLevel(11).resetLevel();
		ReleaseLevel rl = (ReleaseLevel) model.getLevel(11);
		rlc.getRenderedView();

		rl.getBullpen().addPiece(dp.getPiece(0));
		rl.getBullpen().addPiece(dp.getPiece(0));
		rl.getBullpen().addPiece(dp.getPiece(0));

		mcon.requestSwap(rlc);

		try {
			int mask = InputEvent.BUTTON1_DOWN_MASK;
			minime.mouseMove(200 + 20, 200 + 200);
			Thread.sleep(500);
			minime.mousePress(mask);
			minime.mouseMove(200 + 300, 200 + 250);
			Thread.sleep(500);
			rotatePiece();
			minime.mouseRelease(mask);
			Thread.sleep(500);

			minime.mouseMove(200 + 20, 200 + 200);
			Thread.sleep(500);
			minime.mousePress(mask);
			minime.mouseMove(200 + 300, 200 + 250);
			Thread.sleep(500);
			rotatePiece();
			minime.mouseRelease(mask);
			Thread.sleep(500);

			minime.mouseMove(200 + 20, 200 + 200);
			Thread.sleep(500);
			minime.mousePress(mask);
			minime.mouseMove(200 + 300, 200 + 10);
			Thread.sleep(500);
			rotatePiece();
			minime.mouseRelease(mask);
			Thread.sleep(500);
			
			minime.mouseMove(200 + 300, 200 + 250);
			Thread.sleep(500);
			minime.mousePress(mask);
			Thread.sleep(500);
			minime.mouseRelease(mask);
			Thread.sleep(500);
		} catch (Exception e) {

		}

		clickBackButton();
	}

	// Start of Builder Tests
	public void testBuilderSplashScreen() {
		SplashScreenController spc = new SplashScreenController(true);
		spc.getRenderedView();
		assertEquals(spc.get().getMainTitle(), "Kabasuji Level Builder");
	}

	public void testBuilderLevelSelectController() {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(bcon);
		
		BuilderLevelSelectController blsc = new BuilderLevelSelectController(bcon, bmodel);
		blsc.getRenderedView();
		wmg.render();
	}

	public void testBuilderPuzzleLevelController() throws InterruptedException {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(bcon);
		BuilderLevelSelectController blsc = new BuilderLevelSelectController(bcon, bmodel);
		BuilderPuzzleLevelController bplc = new BuilderPuzzleLevelController(bcon, blsc, bmodel, 1);
		wmg.swap(bplc.getRenderedView());
		Thread.sleep(500);
		
		click(340, 100);
		click(540, 100);
		click(540, 100);
		multiclick(500, 400, 16);
		click(440, 100);
		clickBackButton();
		
		clickBackButton();
		reloadLevels();
	}

	public void testBuilderLightningLevelController() throws InterruptedException {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(bcon);
		BuilderLevelSelectController blsc = new BuilderLevelSelectController(bcon, bmodel);
		BuilderLightningLevelController bllc = new BuilderLightningLevelController(bcon, blsc, bmodel, 6);
		wmg.swap(bllc.getRenderedView());
		Thread.sleep(500);
		
		click(340, 100);
		click(540, 100);
		click(540, 100);
		multiclick(500, 400, 16);
		click(440, 100);
		clickBackButton();

		clickBackButton();
		reloadLevels();
	}

	public void testBuilderReleaseLevelController() throws InterruptedException {
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(bcon);
		BuilderLevelSelectController blsc = new BuilderLevelSelectController(bcon, bmodel);
		BuilderReleaseLevelController brlc = new BuilderReleaseLevelController(bcon, blsc, bmodel, 11);
		wmg.swap(brlc.getRenderedView());
		Thread.sleep(500);
		
		click(340, 100);
		click(540, 100);
		click(540, 100);
		multiclick(500, 400, 16);
		click(440, 100);
		clickBackButton();

		clickBackButton();
		reloadLevels();
	}

	public void saveInitialLevels() {
		initLevel = new LinkedList<Level>();
		for (int i = 1; i <= 15; i++) {
			try {
				initLevel.add(model.getLevel(i).generateLevelCopy());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void reloadLevels() {
		for (int i = 0; i < 15; i++) {
			Level ss;
			ss = initLevel.get(i);
			ss.saveToFile();
		}
	}

	public void clickBackButton() {
		int mask = InputEvent.BUTTON1_DOWN_MASK;
		minime.mouseMove(200 + 65, 200 + 50);
		minime.mousePress(mask);
		minime.mouseRelease(mask);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void rotatePiece() {
		try {
			minime.keyPress(KeyEvent.VK_R);
			Thread.sleep(100);
			minime.keyPress(KeyEvent.VK_L);
			Thread.sleep(100);
			minime.keyPress(KeyEvent.VK_V);
			Thread.sleep(100);
			minime.keyPress(KeyEvent.VK_V);
			Thread.sleep(100);
			minime.keyPress(KeyEvent.VK_H);
			Thread.sleep(100);
			minime.keyPress(KeyEvent.VK_H);
			Thread.sleep(100);
		} catch (Exception e) {

		}
	}
	
	public void click(int x, int y){
		int mask = InputEvent.BUTTON1_DOWN_MASK;
		try {
			minime.mouseMove(200 + x, 200 + y);
			Thread.sleep(200);
			minime.mousePress(mask);
			Thread.sleep(200);
			minime.mouseRelease(mask);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void multiclick(int x, int y, int num){
		for(int i = 0; i < num; i++){
			click(x, y);
		}
	}
}
