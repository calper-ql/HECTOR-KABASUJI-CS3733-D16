package entities;

public class EmptyReleaseNumber extends ReleaseNumber {

	public EmptyReleaseNumber(String color, int num){
		super(color, num);
		
		this.color = "none";
		this.num = 0;
	}
	
	public String getColor(){
		return "none";
	}
	
	public void setColor(String color){
	}
	
	public int getNum(){
		return 0;
	}
	
	public void setNum(int num){
	}
}
