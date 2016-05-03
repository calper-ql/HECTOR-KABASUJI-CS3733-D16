package entities;

import java.io.Serializable;

public class EmptyReleaseNumber extends ReleaseNumber implements Serializable {

	public EmptyReleaseNumber(){
		super(0, 0);
		
	}
	
	public int getColor(){
		return this.color;
	}
	
	public void setColor(String color){
	}
	
	public int getNum(){
		return 0;
	}
	
	public void setNum(int num){
	}
}
