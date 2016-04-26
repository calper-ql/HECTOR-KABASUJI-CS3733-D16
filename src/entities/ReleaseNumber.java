package entities;

import java.io.Serializable;

public class ReleaseNumber implements Serializable {
	int color; // 0 to 2
	int num;
	
	public ReleaseNumber(int color, int num){
		this.color = color;
		this.num = num;
	}
	
	public int getColor(){
		return color;
	}
	
	public void setColor(int color){
		this.color = color;
	}
	
	public int getNum(){
		return num;
	}
	
	public void setNum(int num){
		this.num = num;
	}
}