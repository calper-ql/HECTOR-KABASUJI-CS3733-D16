package entities;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A storage of all defined 35 hexominoes.
 * 
 * @author Courtney Davis
 *
 */
public class DefinedPieces {
	ArrayList<Piece> pieces;

	public DefinedPieces() {
		pieces = new ArrayList<Piece>(35);
		pieces.add(this.setUpPiece1());
		pieces.add(this.setUpPiece2());
		pieces.add(this.setUpPiece3());
		pieces.add(this.setUpPiece4());
		pieces.add(this.setUpPiece5());
		pieces.add(this.setUpPiece6());
		pieces.add(this.setUpPiece7());
		pieces.add(this.setUpPiece8());
		pieces.add(this.setUpPiece9());
		pieces.add(this.setUpPiece10());
		pieces.add(this.setUpPiece11());
		pieces.add(this.setUpPiece12());
		pieces.add(this.setUpPiece13());
		pieces.add(this.setUpPiece14());
		pieces.add(this.setUpPiece15());
		pieces.add(this.setUpPiece16());
		pieces.add(this.setUpPiece17());
		pieces.add(this.setUpPiece18());
		pieces.add(this.setUpPiece19());
		pieces.add(this.setUpPiece20());
		pieces.add(this.setUpPiece21());
		pieces.add(this.setUpPiece22());
		pieces.add(this.setUpPiece23());
		pieces.add(this.setUpPiece24());
		pieces.add(this.setUpPiece25());
		pieces.add(this.setUpPiece26());
		pieces.add(this.setUpPiece27());
		pieces.add(this.setUpPiece28());
		pieces.add(this.setUpPiece29());
		pieces.add(this.setUpPiece30());
		pieces.add(this.setUpPiece31());
		pieces.add(this.setUpPiece32());
		pieces.add(this.setUpPiece33());
		pieces.add(this.setUpPiece34());
		pieces.add(this.setUpPiece35());
	}
	
	/**
	 * Return the whole list of defined pieces.
	 * 
	 * @return The list being requested.
	 */
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
	/**
	 * Return a specified piece from a defined list of 35.
	 * 
	 * @param pieceNumber The index of the piece being requested.
	 * @return The piece being requested.
	 */
	public Piece getPiece(int pieceNumber) {
		return pieces.get(pieceNumber);
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece1() {
		// Set Up Piece and Link Blocks
		Piece piece1 = new Piece(Color.GREEN,1);
		Block block1 = new Block(piece1);
		Block block2 = new Block(piece1);
		Block block3 = new Block(piece1);
		Block block4 = new Block(piece1);
		Block block5 = new Block(piece1);
		Block block6 = new Block(piece1);
		block2.linkNorth(block1);
		block3.linkNorth(block2);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece1;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece2() {
		// Set Up Piece and Link Blocks
		Piece piece2 = new Piece(Color.RED,2);
		Block block1 = new Block(piece2);
		Block block2 = new Block(piece2);
		Block block3 = new Block(piece2);
		Block block4 = new Block(piece2);
		Block block5 = new Block(piece2);
		Block block6 = new Block(piece2);
		block2.linkEast(block1);
		block3.linkNorth(block2);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece2;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece3() {
		// Set Up Piece and Link Blocks
		Piece piece3 = new Piece(Color.CYAN, 3);
		Block block1 = new Block(piece3);
		Block block2 = new Block(piece3);
		Block block3 = new Block(piece3);
		Block block4 = new Block(piece3);
		Block block5 = new Block(piece3);
		Block block6 = new Block(piece3);
		block1.linkWest(block3);
		block3.linkNorth(block2);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece3;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece4() {
		// Set Up Piece and Link Blocks
		Piece piece4 = new Piece(Color.MAGENTA, 4);
		Block block1 = new Block(piece4);
		Block block2 = new Block(piece4);
		Block block3 = new Block(piece4);
		Block block4 = new Block(piece4);
		Block block5 = new Block(piece4);
		Block block6 = new Block(piece4);
		block1.linkWest(block4);
		block3.linkNorth(block2);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece4;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece5() {
		// Set Up Piece and Link Blocks
		Piece piece5 = new Piece(Color.PINK, 5);
		Block block1 = new Block(piece5);
		Block block2 = new Block(piece5);
		Block block3 = new Block(piece5);
		Block block4 = new Block(piece5);
		Block block5 = new Block(piece5);
		Block block6 = new Block(piece5);
		block3.linkEast(block2);
		block2.linkNorth(block1);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece5;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece6() {
		// Set Up Piece and Link Blocks
		Piece piece6 = new Piece(Color.GREEN, 6);
		Block block1 = new Block(piece6);
		Block block2 = new Block(piece6);
		Block block3 = new Block(piece6);
		Block block4 = new Block(piece6);
		Block block5 = new Block(piece6);
		Block block6 = new Block(piece6);
		block3.linkEast(block1);
		block1.linkSouth(block2);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece6;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece7() {
		// Set Up Piece and Link Blocks
		Piece piece7 = new Piece(Color.RED, 7);
		Block block1 = new Block(piece7);
		Block block2 = new Block(piece7);
		Block block3 = new Block(piece7);
		Block block4 = new Block(piece7);
		Block block5 = new Block(piece7);
		Block block6 = new Block(piece7);
		block3.linkEast(block1);
		block2.linkWest(block5);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece7;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece8() {
		// Set Up Piece and Link Blocks
		Piece piece8 = new Piece(Color.CYAN, 8);
		Block block1 = new Block(piece8);
		Block block2 = new Block(piece8);
		Block block3 = new Block(piece8);
		Block block4 = new Block(piece8);
		Block block5 = new Block(piece8);
		Block block6 = new Block(piece8);
		block3.linkEast(block1);
		block2.linkWest(block6);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece8;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece9() {
		// Set Up Piece and Link Blocks
		Piece piece9 = new Piece(Color.MAGENTA, 9);
		Block block1 = new Block(piece9);
		Block block2 = new Block(piece9);
		Block block3 = new Block(piece9);
		Block block4 = new Block(piece9);
		Block block5 = new Block(piece9);
		Block block6 = new Block(piece9);
		block1.linkWest(block4);
		block2.linkWest(block5);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece9;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece10() {
		// Set Up Piece and Link Blocks
		Piece piece10 = new Piece(Color.PINK, 10);
		Block block1 = new Block(piece10);
		Block block2 = new Block(piece10);
		Block block3 = new Block(piece10);
		Block block4 = new Block(piece10);
		Block block5 = new Block(piece10);
		Block block6 = new Block(piece10);
		block3.linkEast(block1);
		block1.linkEast(block2);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece10;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece11() {
		// Set Up Piece and Link Blocks
		Piece piece11 = new Piece(Color.GREEN, 11);
		Block block1 = new Block(piece11);
		Block block2 = new Block(piece11);
		Block block3 = new Block(piece11);
		Block block4 = new Block(piece11);
		Block block5 = new Block(piece11);
		Block block6 = new Block(piece11);
		block4.linkEast(block1);
		block1.linkEast(block2);
		block3.linkSouth(block4);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece11;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece12() {
		// Set Up Piece and Link Blocks
		Piece piece12 = new Piece(Color.RED, 12);
		Block block1 = new Block(piece12);
		Block block2 = new Block(piece12);
		Block block3 = new Block(piece12);
		Block block4 = new Block(piece12);
		Block block5 = new Block(piece12);
		Block block6 = new Block(piece12);
		block1.linkEast(block3);
		block3.linkEast(block2);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece12;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece13() {
		// Set Up Piece and Link Blocks
		Piece piece13 = new Piece(Color.CYAN, 13);
		Block block1 = new Block(piece13);
		Block block2 = new Block(piece13);
		Block block3 = new Block(piece13);
		Block block4 = new Block(piece13);
		Block block5 = new Block(piece13);
		Block block6 = new Block(piece13);
		block3.linkEast(block2);
		block1.linkEast(block4);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece13;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece14() {
		// Set Up Piece and Link Blocks
		Piece piece14 = new Piece(Color.MAGENTA, 14);
		Block block1 = new Block(piece14);
		Block block2 = new Block(piece14);
		Block block3 = new Block(piece14);
		Block block4 = new Block(piece14);
		Block block5 = new Block(piece14);
		Block block6 = new Block(piece14);
		block3.linkEast(block2);
		block1.linkEast(block5);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece14;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece15() {
		// Set Up Piece and Link Blocks
		Piece piece15 = new Piece(Color.PINK, 15);
		Block block1 = new Block(piece15);
		Block block2 = new Block(piece15);
		Block block3 = new Block(piece15);
		Block block4 = new Block(piece15);
		Block block5 = new Block(piece15);
		Block block6 = new Block(piece15);
		block1.linkEast(block6);
		block3.linkEast(block2);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece15;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece16() {
		// Set Up Piece and Link Blocks
		Piece piece16 = new Piece(Color.GREEN, 16);
		Block block1 = new Block(piece16);
		Block block2 = new Block(piece16);
		Block block3 = new Block(piece16);
		Block block4 = new Block(piece16);
		Block block5 = new Block(piece16);
		Block block6 = new Block(piece16);
		block2.linkWest(block4);
		block1.linkEast(block5);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece16;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece17() {
		// Set Up Piece and Link Blocks
		Piece piece17 = new Piece(Color.RED, 17);
		Block block1 = new Block(piece17);
		Block block2 = new Block(piece17);
		Block block3 = new Block(piece17);
		Block block4 = new Block(piece17);
		Block block5 = new Block(piece17);
		Block block6 = new Block(piece17);
		block1.linkEast(block4);
		block2.linkWest(block4);
		block4.linkNorth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece17;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece18() {
		// Set Up Piece and Link Blocks
		Piece piece18 = new Piece(Color.CYAN, 18);
		Block block1 = new Block(piece18);
		Block block2 = new Block(piece18);
		Block block3 = new Block(piece18);
		Block block4 = new Block(piece18);
		Block block5 = new Block(piece18);
		Block block6 = new Block(piece18);
		block4.linkEast(block2);
		block2.linkNorth(block1);
		block3.linkWest(block2);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece18;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece19() {
		// Set Up Piece and Link Blocks
		Piece piece19 = new Piece(Color.MAGENTA, 19);
		Block block1 = new Block(piece19);
		Block block2 = new Block(piece19);
		Block block3 = new Block(piece19);
		Block block4 = new Block(piece19);
		Block block5 = new Block(piece19);
		Block block6 = new Block(piece19);
		block4.linkEast(block2);
		block2.linkNorth(block1);
		block3.linkWest(block6);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece19;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece20() {
		// Set Up Piece and Link Blocks
		Piece piece20 = new Piece(Color.PINK, 20);
		Block block1 = new Block(piece20);
		Block block2 = new Block(piece20);
		Block block3 = new Block(piece20);
		Block block4 = new Block(piece20);
		Block block5 = new Block(piece20);
		Block block6 = new Block(piece20);
		block1.linkSouth(block2);
		block2.linkSouth(block3);
		block3.linkWest(block4);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece20;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece21() {
		// Set Up Piece and Link Blocks
		Piece piece21 = new Piece(Color.GREEN, 21);
		Block block1 = new Block(piece21);
		Block block2 = new Block(piece21);
		Block block3 = new Block(piece21);
		Block block4 = new Block(piece21);
		Block block5 = new Block(piece21);
		Block block6 = new Block(piece21);
		block3.linkWest(block5);
		block2.linkWest(block4);
		block1.linkSouth(block2);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece21;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece22() {
		// Set Up Piece and Link Blocks
		Piece piece22 = new Piece(Color.RED, 22);
		Block block1 = new Block(piece22);
		Block block2 = new Block(piece22);
		Block block3 = new Block(piece22);
		Block block4 = new Block(piece22);
		Block block5 = new Block(piece22);
		Block block6 = new Block(piece22);
		block4.linkWest(block1);
		block5.linkWest(block2);
		block6.linkWest(block3);
		block3.linkNorth(block2);
		block2.linkNorth(block1);
		return piece22;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece23() {
		// Set Up Piece and Link Blocks
		Piece piece23 = new Piece(Color.CYAN, 23);
		Block block1 = new Block(piece23);
		Block block2 = new Block(piece23);
		Block block3 = new Block(piece23);
		Block block4 = new Block(piece23);
		Block block5 = new Block(piece23);
		Block block6 = new Block(piece23);
		block1.linkEast(block4);
		block2.linkWest(block4);
		block3.linkSouth(block2);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece23;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece24() {
		// Set Up Piece and Link Blocks
		Piece piece24 = new Piece(Color.MAGENTA, 24);
		Block block1 = new Block(piece24);
		Block block2 = new Block(piece24);
		Block block3 = new Block(piece24);
		Block block4 = new Block(piece24);
		Block block5 = new Block(piece24);
		Block block6 = new Block(piece24);
		block1.linkEast(block4);
		block2.linkWest(block4);
		block3.linkWest(block5);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece24;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece25() {
		// Set Up Piece and Link Blocks
		Piece piece25 = new Piece(Color.PINK, 25);
		Block block1 = new Block(piece25);
		Block block2 = new Block(piece25);
		Block block3 = new Block(piece25);
		Block block4 = new Block(piece25);
		Block block5 = new Block(piece25);
		Block block6 = new Block(piece25);
		block1.linkEast(block5);
		block3.linkWest(block4);
		block2.linkSouth(block3);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece25;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece26() {
		// Set Up Piece and Link Blocks
		Piece piece26 = new Piece(Color.GREEN, 26);
		Block block1 = new Block(piece26);
		Block block2 = new Block(piece26);
		Block block3 = new Block(piece26);
		Block block4 = new Block(piece26);
		Block block5 = new Block(piece26);
		Block block6 = new Block(piece26);
		block1.linkSouth(block3);
		block3.linkWest(block2);
		block2.linkWest(block4);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece26;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece27() {
		// Set Up Piece and Link Blocks
		Piece piece27 = new Piece(Color.RED, 27);
		Block block1 = new Block(piece27);
		Block block2 = new Block(piece27);
		Block block3 = new Block(piece27);
		Block block4 = new Block(piece27);
		Block block5 = new Block(piece27);
		Block block6 = new Block(piece27);
		block3.linkWest(block1);
		block1.linkSouth(block2);
		block2.linkWest(block4);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece27;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece28() {
		// Set Up Piece and Link Blocks
		Piece piece28 = new Piece(Color.CYAN, 28);
		Block block1 = new Block(piece28);
		Block block2 = new Block(piece28);
		Block block3 = new Block(piece28);
		Block block4 = new Block(piece28);
		Block block5 = new Block(piece28);
		Block block6 = new Block(piece28);
		block3.linkNorth(block2);
		block2.linkWest(block1);
		block1.linkWest(block4);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece28;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece29() {
		// Set Up Piece and Link Blocks
		Piece piece29 = new Piece(Color.MAGENTA, 29);
		Block block1 = new Block(piece29);
		Block block2 = new Block(piece29);
		Block block3 = new Block(piece29);
		Block block4 = new Block(piece29);
		Block block5 = new Block(piece29);
		Block block6 = new Block(piece29);
		block2.linkSouth(block3);
		block3.linkWest(block1);
		block1.linkWest(block5);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece29;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece30() {
		// Set Up Piece and Link Blocks
		Piece piece30 = new Piece(Color.PINK, 30);
		Block block1 = new Block(piece30);
		Block block2 = new Block(piece30);
		Block block3 = new Block(piece30);
		Block block4 = new Block(piece30);
		Block block5 = new Block(piece30);
		Block block6 = new Block(piece30);
		block3.linkSouth(block4);
		block4.linkWest(block5);
		block1.linkSouth(block2);
		block2.linkEast(block5);
		block6.linkNorth(block5);
		return piece30;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece31() {
		// Set Up Piece and Link Blocks
		Piece piece31 = new Piece(Color.GREEN, 31);
		Block block1 = new Block(piece31);
		Block block2 = new Block(piece31);
		Block block3 = new Block(piece31);
		Block block4 = new Block(piece31);
		Block block5 = new Block(piece31);
		Block block6 = new Block(piece31);
		block1.linkWest(block2);
		block2.linkSouth(block3);
		block3.linkSouth(block4);
		block4.linkWest(block5);
		block6.linkNorth(block5);
		return piece31;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece32() {
		// Set Up Piece and Link Blocks
		Piece piece32 = new Piece(Color.RED, 32);
		Block block1 = new Block(piece32);
		Block block2 = new Block(piece32);
		Block block3 = new Block(piece32);
		Block block4 = new Block(piece32);
		Block block5 = new Block(piece32);
		Block block6 = new Block(piece32);
		block1.linkWest(block5);
		block3.linkWest(block2);
		block2.linkWest(block6);
		block5.linkNorth(block4);
		block6.linkNorth(block5);
		return piece32;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece33() {
		// Set Up Piece and Link Blocks
		Piece piece33 = new Piece(Color.CYAN, 33);
		Block block1 = new Block(piece33);
		Block block2 = new Block(piece33);
		Block block3 = new Block(piece33);
		Block block4 = new Block(piece33);
		Block block5 = new Block(piece33);
		Block block6 = new Block(piece33);
		block1.linkWest(block3);
		block2.linkSouth(block3);
		block3.linkSouth(block4);
		block4.linkWest(block6);
		block6.linkNorth(block5);
		return piece33;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece34() {
		// Set Up Piece and Link Blocks
		Piece piece34 = new Piece(Color.MAGENTA, 34);
		Block block1 = new Block(piece34);
		Block block2 = new Block(piece34);
		Block block3 = new Block(piece34);
		Block block4 = new Block(piece34);
		Block block5 = new Block(piece34);
		Block block6 = new Block(piece34);
		block1.linkSouth(block2);
		block2.linkWest(block3);
		block4.linkNorth(block3);
		block3.linkWest(block5);
		block6.linkNorth(block5);
		return piece34;
	}
	/**
	 * Assemble a piece by connecting blocks in correct fashion.
	 * @return The properly formatted hexomino.
	 */
	public Piece setUpPiece35() {
		// Set Up Piece and Link Blocks
		Piece piece35 = new Piece(Color.PINK, 35);
		Block block1 = new Block(piece35);
		Block block2 = new Block(piece35);
		Block block3 = new Block(piece35);
		Block block4 = new Block(piece35);
		Block block5 = new Block(piece35);
		Block block6 = new Block(piece35);
		block1.linkSouth(block2);
		block2.linkWest(block3);
		block3.linkSouth(block4);
		block4.linkWest(block5);
		block6.linkNorth(block5);
		return piece35;
	}
}