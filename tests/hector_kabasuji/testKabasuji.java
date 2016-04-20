package hector_kabasuji;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.*;
import junit.framework.TestCase;

public class testKabasuji extends TestCase {

//First Phase Arbitrary Test Cases
public void testAchievement(){
	BufferedImage achievement_Image = null;
	
	try {
		URL img = boundary.BuilderLevelView.class.getResource("/img/888267.jpg");
		achievement_Image = ImageIO.read(img);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Image achievementImage = achievement_Image.getScaledInstance(35, 50, Image.SCALE_SMOOTH);
	//Test Achievement can be created properly
	Achievement testAchievement = new Achievement("Loaded Game", achievementImage, false);
	//Check that Achievement had correct values
	assertEquals(testAchievement.getName(), "Loaded Game");
	//Check that isUnlocked method returns correct value
	assertEquals(testAchievement.isUnlocked(), false);
	//Change the value of boolean in Achievement and check that check method works
	testAchievement.check();
	assertEquals(testAchievement.isUnlocked(), true);
	
} //EndMethodTestAchievement

public void testPeice() throws Exception{
	//Create piece and associated blocks
	Piece testPiece = new Piece(null);
	IBlock testBlock1 = new Block(testPiece);
	IBlock testBlock2 = new Block(testPiece);
	IBlock testBlock3 = new Block(testPiece);
	IBlock testBlock4 = new Block(testPiece);
	IBlock testBlock5 = new Block(testPiece);
	IBlock testBlock6 = new Block(testPiece);
	ArrayList<IBlock> blocks = new ArrayList<IBlock>(6);
	blocks.add(testBlock1);
	blocks.add(testBlock2);
	blocks.add(testBlock3);
	blocks.add(testBlock4);
	blocks.add(testBlock5);
	blocks.add(testBlock6);
	//Test you can get Block from an index < 6 and > 0
	assertEquals(testPiece.getBlock(0), testBlock6);
	//Test you can't get Block from an index > 6 or < 0
	 boolean thrown = false;

	  try {
		  testPiece.getBlock(-1);
	  } catch (Exception e) {
	    thrown = true;
	  }

	  assertTrue(thrown);
	  boolean thrown2 = false;

		  try {
			  testPiece.getBlock(6);
		  } catch (Exception e) {
		    thrown2 = true;
		  }

		  assertTrue(thrown2);
	
	
} //EndMethodTestBlock
}
