package hector_Kabasuji;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
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
	Model model;
	Model bmodel;
	LinkedList<Level> initLevel = new LinkedList<Level>();
	Robot minime;
	
	/*  IMPORTANT, When any changes are made in the entities, you need to re generate them.
	 *  Do this by running the BaseLevelGenerator.java file, MANUALLY!
	 * 
	 * 
	 * 
	 */

	protected void setUp() throws Exception {
		game = new Application();
		builder = new Builder();
		mcon = new GameMainController(game);
		model = game.getModel();
		bmodel = builder.getModel();
		model.reload();
		bmodel.reload();
		minime = new Robot();
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
	
	public void testPieceCreate(){
		b0.linkEast(b1);
		b1.linkEast(b2);
		b2.linkNorth(b3);
		b3.linkWest(b4);
		b3.linkNorth(b5);
		try {
			assertEquals(p0.getBlock(0).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(0).getEast(), 	b1);
			assertEquals(p0.getBlock(0).getWest().isValidBlock(), false);
			
			assertEquals(p0.getBlock(1).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getEast(), 	b2);
			assertEquals(p0.getBlock(1).getWest(), 	b0);
			
			assertEquals(p0.getBlock(2).getNorth(), b3);
			assertEquals(p0.getBlock(2).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(2).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(2).getWest(), 	b1);
			
			assertEquals(p0.getBlock(3).getNorth(), b5);
			assertEquals(p0.getBlock(3).getSouth(), b2);
			assertEquals(p0.getBlock(3).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(3).getWest(), 	b4);
			
			assertEquals(p0.getBlock(4).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getEast(), 	b3);
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
	
	public void testPieceFlip(){
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
			assertEquals(p0.getBlock(0).getWest(), 	b1);
			
			assertEquals(p0.getBlock(1).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getSouth().isValidBlock(), false);
			assertEquals(p0.getBlock(1).getEast(), 	b0);
			assertEquals(p0.getBlock(1).getWest(), 	b2);
			
			assertEquals(p0.getBlock(2).getNorth(), b3);
			assertEquals(p0.getBlock(2).getSouth().isValidBlock(), false);			
			assertEquals(p0.getBlock(2).getEast(), 	b1);
			assertEquals(p0.getBlock(2).getWest().isValidBlock(), false);
			
			assertEquals(p0.getBlock(3).getNorth(), b5);
			assertEquals(p0.getBlock(3).getSouth(), b2);
			assertEquals(p0.getBlock(3).getEast(), 	b4);
			assertEquals(p0.getBlock(3).getWest().isValidBlock(), false);			
			
			assertEquals(p0.getBlock(4).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getSouth().isValidBlock(), false);			
			assertEquals(p0.getBlock(4).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(4).getWest(), 	b3);
			
			assertEquals(p0.getBlock(5).getNorth().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getSouth(), b3);
			assertEquals(p0.getBlock(5).getEast().isValidBlock(), false);
			assertEquals(p0.getBlock(5).getWest().isValidBlock(), false);
		} catch (Exception e) {
			
		}
	}
	
	public void testPieceRotateCounterClockwise(){
		b0.linkEast(b1);
		b1.linkEast(b2);
		b2.linkNorth(b3);
		b3.linkWest(b4);
		b3.linkNorth(b5);
		b0.rotate(true);
		 
		
		try{
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
	
	public void testPieceRotateClockwise(){
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
			assertEquals(p0.getBlock(3).getWest(), 	b2);
			
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
	
	public void testDefinedPieces(){
		DefinedPieces dp = new DefinedPieces();
		assertEquals(dp.getPieces().size(), 35);
	}

	// Level Tests
	public void testLevel(){
		Level lev10 = model.getLevel(10);
		assertEquals(lev10.getLevelNum(), 10);

		assertEquals(lev10.isLocked(),false);
		lev10.unlock();
		assertEquals(lev10.isLocked(),false);
		assertEquals(lev10.getLevelNum(), 10); // wtf is going on here?

		lev10.unlock();
		assertEquals(lev10.isLocked(),false);
		lev10.lock();
		assertEquals(lev10.isLocked(),true);
		
		assertEquals(lev10.getStars(), 0);
		lev10.setStars(2);
		assertEquals(lev10.getStars(), 2);
		lev10.setStars(1);
		assertEquals(lev10.getStars(), 2);
		lev10.resetLevel();
		assertEquals(lev10.getStars(), 0);

		
		assertEquals(lev10.getEmptyTileCount(), 144);	
		lev10.getBoard().getTile(2, 5).disable();
		assertEquals(lev10.getEmptyTileCount(), 143);
		assertEquals(lev10.getBullpen().getSize(), 0);
	}
	
	public void testPuzzleLevel(){
		PuzzleLevel pl = (PuzzleLevel) model.getLevel(1);
		
		pl.forceStars(0);
		
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
	}
	
	public void testLightningLevel(){
		LightningLevel ll = (LightningLevel) model.getLevel(6);
		
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
	
	public void testReleaseLevel(){
		ReleaseLevel rl = (ReleaseLevel) model.getLevel(12);
		
		rl.forceStars(0);
		
		rl.getBullpen().addPiece(p0);
		
		LinkedList<ReleaseNumber> rnl = new LinkedList<ReleaseNumber>();
		for(int c = 0; c < 3; c++){
			for(int n = 0; n <= 6; n++){
				rnl.add(new ReleaseNumber(c, n));
			}
		}
				
		rl.resetSets();
		assertEquals(rl.hasFinished(), false);
		rl.updateStars();
		assertEquals(rl.getStars(), 0);
		
		for(int i = 0; i < rnl.size(); i++){
			ReleaseNumber n = rnl.get(i);
			rl.addReleaseNumber(n);
		}
		
		assertEquals(rl.hasFinished(), true);
		rl.updateStars();
		assertEquals(rl.getStars(), 3);
	}
	
	public void testAchievements(){
		model.checkUnlockedAchievements();
	}
	
	// Boundary Test Cases
	
	// Controller Test Cases
	public void testSplashScreen(){
		SplashScreenController spc = new SplashScreenController(false);
		spc.getRenderedView();
		assertEquals(spc.get().getMainTitle(), "Kabasuji");
		clickBackButton();
	}
	
	public void testMainMenu(){
		MainMenuController mmc = new MainMenuController(mcon, model);
		mmc.getRenderedView();		
	}
	
	public void testAchievementController(){
		MainMenuController mmc = new MainMenuController(mcon, model);
		AchievementController ac = new AchievementController(mcon, mmc);
		ac.getRenderedView();
		reloadLevels();		
		clickBackButton();
	}
	
	public void testLevelSelectController(){
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
		for(int c = 0; c < 3; c++){
			for(int n = 0; n <= 6; n++){
				rnl.add(new ReleaseNumber(c, n));
			}
		}				
		rl.resetSets();
		for(int i = 0; i < rnl.size(); i++){
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
	
	public void testPuzzleLevelController() throws Exception{
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(mcon);
		
		MainMenuController mmc = new MainMenuController(mcon, model);
		LevelSelectController lsc = new LevelSelectController(mcon, mmc, model);
		PuzzleLevelController plc = new PuzzleLevelController(mcon, lsc, model, 1);
		plc.getRenderedView();
		
		model.getLevel(1).getBullpen().addPiece(p0);
		
		Piece p = model.getLevel(1).getBullpen().getPiece(0);
		assertEquals(p.equals(p0), true);
		try{
			Block b = p.getBlock(0);
			BlockController bc = new BlockController(b, plc);
			BlockView bv0 = new BlockView(bc);  
			LinkedList<JBlockPanel> list = bv0.render(b, 20, 20);
			
			mcon.requestSwap(plc);

//			plc.setCurrentBlockPanelList(list);			
//			plc.piecePressed(list.get(0));
						  
			plc.setCurrentBlockPanelList(list);
			plc.pieceReleased(list.get(0)); 
		}catch (Exception e){
		}	
		reloadLevels();		
		clickBackButton();
	}
	
	public void testLightningLevelController(){
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(mcon);
		
		MainMenuController mmc = new MainMenuController(mcon, model);
		LevelSelectController lsc = new LevelSelectController(mcon, mmc, model);
		LightningLevelController llc = new LightningLevelController(mcon, lsc, model, 6);
		llc.getRenderedView();
		
		model.getLevel(6).getBullpen().addPiece(p0);
		
		Piece p = model.getLevel(6).getBullpen().getPiece(0);
		assertEquals(p.equals(p0), true);
		try{
			Block b = p.getBlock(0);
			BlockController bc = new BlockController(b, llc);
			BlockView bv0 = new BlockView(bc);  
			LinkedList<JBlockPanel> list = bv0.render(b, 20, 20);
			
			mcon.requestSwap(llc);

//			plc.setCurrentBlockPanelList(list);			
//			plc.piecePressed(list.get(0));
						  
			llc.setCurrentBlockPanelList(list);
			llc.pieceReleased(list.get(0)); 
		}catch (Exception e){
		}	
		reloadLevels();		
		clickBackButton();
	}
	
	public void testReleaseLevelController(){
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(mcon);
		
		MainMenuController mmc = new MainMenuController(mcon, model);
		LevelSelectController lsc = new LevelSelectController(mcon, mmc, model);
		ReleaseLevelController rlc = new ReleaseLevelController(mcon, lsc, model, 11);
		rlc.getRenderedView();
		
		model.getLevel(11).getBullpen().addPiece(p0);
		
		Piece p = model.getLevel(11).getBullpen().getPiece(0);
		assertEquals(p.equals(p0), true);
		try{
			Block b = p.getBlock(0);
			BlockController bc = new BlockController(b, rlc);
			BlockView bv0 = new BlockView(bc);  
			LinkedList<JBlockPanel> list = bv0.render(b, 400, 400);
			
			mcon.requestSwap(rlc);

//			plc.setCurrentBlockPanelList(list);			
//			plc.piecePressed(list.get(0));
						  
			rlc.setCurrentBlockPanelList(list);
			rlc.pieceReleased(list.get(0));  
		}catch (Exception e){
		}
		reloadLevels();		
		clickBackButton();
	}
	
	// Start of Builder Tests
	public void testBuilderSplashScreen(){
		SplashScreenController spc = new SplashScreenController(true);
		spc.getRenderedView();
		assertEquals(spc.get().getMainTitle(), "Kabasuji Level Builder");
	}
	
	public void testBuilderLevelSelectController(){
		BuilderLevelSelectController blsc = new BuilderLevelSelectController(mcon, bmodel);
		blsc.getRenderedView();
	} 
	
	public void testBuilderPuzzleLevelController(){
		BuilderLevelSelectController blsc = new BuilderLevelSelectController(mcon, bmodel);
		BuilderPuzzleLevelController bplc = new BuilderPuzzleLevelController(mcon, blsc, model, 1);
		bplc.getRenderedView();
		reloadLevels();		
		clickBackButton();
	}
	
	public void testBuilderLightningLevelController(){
		BuilderLevelSelectController blsc = new BuilderLevelSelectController(mcon, bmodel);
		BuilderLightningLevelController bllc = new BuilderLightningLevelController(mcon, blsc, model, 6);
		bllc.getRenderedView();
		reloadLevels();		
		clickBackButton();
	}
	
	public void testBuilderReleaseLevelController(){
		BuilderLevelSelectController blsc = new BuilderLevelSelectController(mcon, bmodel);
		BuilderReleaseLevelController brlc = new BuilderReleaseLevelController(mcon, blsc, model, 11);
		brlc.getRenderedView();		
		reloadLevels();		
		clickBackButton();
	}
	
	public void saveInitialLevels(){
		for(int i = 1; i <= 15; i++){
			initLevel.add(model.getLevel(i));
		}
	}
	
	public void reloadLevels(){
		for(int i = 0; i < 15; i++){
			Level ss;
			ss = initLevel.get(i);
			ss.saveToFile();	
		} 
	}
	
	public void clickBackButton(){
		int mask = InputEvent.BUTTON1_DOWN_MASK;
		minime.mouseMove(200 + 65, 200 + 50);           
		minime.mousePress(mask);     
		minime.mouseRelease(mask);
	}
	
}
