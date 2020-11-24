package practice;

import practice_constructor.Car01;

public class Main01 {
	public static void main(String[] args) {
		
		Car01 c1=new Car01();
		
		c1.drive();
		c1.stop();
		
		c1.cc=1000;
		c1.name="소나타";
		
		Car01 c2 = new Car01();
		
	}
}
