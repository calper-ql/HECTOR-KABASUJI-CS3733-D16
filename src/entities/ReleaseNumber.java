package entities;

public class ReleaseNumber {
	String color;
	int num;
	
	public ReleaseNumber(String color, int num){
		this.color = color;
		this.num = num;
		return;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public int getNum(){
		return num;
	}
}
