package test.main;

import test.mypac.Weapon;

public class MainClass03 {
	//Inner Class(내부 클레스에 한해서 필요하다면 static 에약어를 붙일 수 있다)
	class AirPlane extends Weapon{
		@Override
		public void attck() {
			System.out.println("공중에서 공격을해요");
		}
	}
	
	public static void main(String[] args) {
		//Local Inner Class
		class Sword extends Weapon{
			@Override
			public void attck() {
				System.out.println("칼로 공격해요!");
			}
		}
		Weapon w1=new Sword();
		useWeapon(w1);
		
		Weapon w2=new AirPlane();
		useWeapon(w2);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attck();
	}
}
