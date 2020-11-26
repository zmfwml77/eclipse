package test.main;

import test.mypac.Zoo;
import test.mypac.Zoo.Cat;
import test.mypac.Zoo.Monkey;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * Zoo 클래스에 있는 getMonkey() 메소드를 호출해서
		 * 리턴되는 참조값을 m1이라는 지역변수에 담아보세요
		 */
		Monkey m1=new Zoo().getMonkey();
		m1.say();
//		Zoo z1=new Zoo();
//		Monkey m1=z1.getMonkey();
		
		//고양이
		Cat c1=new Zoo().getCat();
		c1.say();
	}
}
