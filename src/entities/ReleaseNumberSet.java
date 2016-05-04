package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.io.Serializable;

public class ReleaseNumberSet implements Serializable{
	int color;
	LinkedList<ReleaseNumber> numbers = new LinkedList<ReleaseNumber>();
	
	public ReleaseNumberSet(int color, LinkedList<ReleaseNumber> numbers){
		this.color = color;
		this.numbers = numbers;
	}
	
	public int getColor(){
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
			con1 |= (numbers.get(i).getNum() == 1);
			con2 |= (numbers.get(i).getNum() == 2);
			con3 |= (numbers.get(i).getNum() == 3);
			con4 |= (numbers.get(i).getNum() == 4);
			con5 |= (numbers.get(i).getNum() == 5);
			con6 |= (numbers.get(i).getNum() == 6);
		}
		
		return con1 & con2 & con3 & con4 & con5 & con6;
	}
	
	public boolean addNumber(ReleaseNumber number){
		if (number.getColor() == color){
			numbers.add(number);
			return true;
		} else return false;
	}
	
	public boolean removeNumber(ReleaseNumber number){
		return numbers.remove(number);
	}
	
	public void resetSet(){
		numbers.clear();
	}
}
