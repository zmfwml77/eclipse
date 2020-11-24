package test.main;

import test.mypac.House;

public class MainClass02 {
	public static void main(String[] args) {
		//House 클래스를 이용해서 여러분들이 집에서 편한하게 3번 쉬어 보세요.
		House myHome=new House();
		myHome.relax("김구라");
		myHome.relax("김구라");
		myHome.relax("김구라");
		//for문 이용하면?
//		for(int i=0; i<3; i++) {
//			h1.relax("최윤원");
//		}
		
		//만약 House클래스의 relax 메소드가 static이면★★★ 
		//House.relax("최윤원"); 처럼 클래스명(House)에 점 찍고 실행★★★
		
		//집에서 100번 쉬어 보세요.
		for(int i=0; i<100; i++) {
			myHome.relax("원숭이");
		}
	}
}






