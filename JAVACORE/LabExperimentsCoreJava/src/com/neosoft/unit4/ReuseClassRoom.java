package com.neosoft.unit4;
import com.neosoft.unit3.Roomclass;
public class ReuseClassRoom extends Roomclass {
	Roomclass r;
	
	public void createHouse() {
		r=new Roomclass();
	}
	
	void displayHouse() {
		r.displayData();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReuseClassRoom h=new ReuseClassRoom();
		h.createHouse();
		h.displayHouse();

	}

}
