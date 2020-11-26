package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * 여러분이 직접 Weapon 추상클래스를 상속받은 클래스를
		 * 정의해서 객체 생성을 하고 해당 참조값을 이용해서
		 * 아래의 useWeapon 메소드를 호출해보세요.
		 * (단, 클래스명은 myWeapon말고 다른걸로~~)
		 */
		Weapon g1=new Gun();
		/*MainClass02.(같은클래스여서 생략가능)*/useWeapon(g1);
	}
	
	//Weapon type의 참조값을 인자로 전달받는 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attck();
	}
}
