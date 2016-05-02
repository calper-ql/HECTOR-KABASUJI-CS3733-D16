package entities;

import java.io.Serializable;

public class EmptyBlock implements IBlock ,Serializable{
	
	public EmptyBlock(){}

	@Override
	public void rotateBlock(IBlock block) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flipBlock(IBlock block, boolean horizontal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBlock getNorth() {
		// TODO Auto-generated method stub
		return new EmptyBlock();
	}

	@Override
	public IBlock getSouth() {
		// TODO Auto-generated method stub
		return new EmptyBlock();
	}

	@Override
	public IBlock getEast() {
		// TODO Auto-generated method stub
		return new EmptyBlock();
	}

	@Override
	public IBlock getWest() {
		// TODO Auto-generated method stub
		return new EmptyBlock();
	}

	@Override
	public boolean isValidBlock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Piece getPiece() {
		// TODO Auto-generated method stub
		return null;
	}


}
