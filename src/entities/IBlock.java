package entities;

public interface IBlock {

	void rotateBlock(IBlock block);

	void flipBlock(IBlock block);
	
	IBlock getNorth();
	IBlock getSouth();
	IBlock getEast();
	IBlock getWest();
	boolean isValidBlock();
	
}
