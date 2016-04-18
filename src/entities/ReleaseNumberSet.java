package entities;

import java.util.LinkedList;

public class ReleaseNumberSet {
	String color;
	LinkedList<ReleaseNumber> numbers = new LinkedList<ReleaseNumber>();
	
	public ReleaseNumberSet(String color, LinkedList<ReleaseNumber> numbers){
		this.color = color;
		this.numbers = numbers;
	}
	
	public String getColor(){
		return color;
	}
	
	public boolean isComplete(){
		boolean con1 = false;
		boolean con2 = false;
		boolean con3 = false;
		boolean con4 = false;
		boolean con5 = false;
		boolean con6 = false;
		
		for(int i = 0; i < numbers.size(); i++){
			con1 |= (numbers.get(i).num == 1);
			con2 |= (numbers.get(i).num == 2);
			con3 |= (numbers.get(i).num == 3);
			con4 |= (numbers.get(i).num == 4);
			con5 |= (numbers.get(i).num == 5);
			con6 |= (numbers.get(i).num == 6);
		}
		
		return con1 & con2 & con3 & con4 & con5 & con6;
	}
}
