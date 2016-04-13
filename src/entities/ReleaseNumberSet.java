package entities;

import java.util.ArrayList;

public class ReleaseNumberSet {
	String color;
	ArrayList<ReleaseNumber> numbers;
	
	public ReleaseNumberSet(String color, ArrayList<ReleaseNumber> numbers){
		this.color = color;
		this.numbers = numbers;
		return;
	}
}
