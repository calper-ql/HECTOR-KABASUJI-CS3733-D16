package entities;

public interface IBlock {

	void rotateBlock(IBlock block);

	void flipBlock(IBlock block, boolean horizontal);
	
	IBlock getNorth();
	IBlock getSouth();
	IBlock getEast();
	IBlock getWest();
	boolean isValidBlock();
	Piece getPiece();
	
}
