package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;

public class MainClass03 {
	// Inner Class (내부 클래스에 한해서 필요하다면 static 예약어를 붙일수 있다) 
	static class AirPlane extends Weapon{
		@Override
		public void attack() {
			System.out.println("공중에서 공격을 해요");
		}
	}
	
	public static void main(String[] args) {
		//Local Inner Class 
		class Sword extends Weapon{
			@Override
			public void attack() {
				System.out.println("칼로 공격을 해요!");
			}
		}
		//Sword객체를 생성해서 참조값을 Weapon type으로 받기
		Weapon w1=new Sword(); //Local Inner Class
		useWeapon(w1);
		//AirPlane객체를 생성해서 참조값을 Weapon type으로 받기
		Weapon w2=new AirPlane(); // inner class
		useWeapon(w2);
		//Gun객체를 생성해서 참조값을 Weapon type으로 받기
		Weapon w3=new Gun(); // external class
		useWeapon(w3);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
