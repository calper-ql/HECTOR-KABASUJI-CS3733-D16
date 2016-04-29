package hector_Kabasuji;

import java.awt.Color;

import generators.*;
import boundary.*;
import controllers.*;
import entities.*;
import kabasuji.application.*;
import move.*;
import junit.framework.TestCase;

public class testKabasuji extends TestCase {
	Application game;

	protected void setUp() throws Exception {
		game = new Application();
		WindowManager wmg = new WindowManager(200, 200, 640, 535);
		wmg.link(new GameMainController(new Application()));
	}

	// Start of Entity Controllers
	
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
	
	public void testPieceRotate(){
		b0.linkEast(b1);
		b1.linkEast(b2);
		b2.linkNorth(b3);
		b3.linkWest(b4);
		b3.linkNorth(b5);
		b0.flip();
		
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
	
	public void testPieceRotate(){
		b0.linkEast(b1);
		b1.linkEast(b2);
		b2.linkNorth(b3);
		b3.linkWest(b4);
		b3.linkNorth(b5);
		b0.rotate(true);
		
		try{
			
		} catch (Exception e) {
			
		}
	}
}
