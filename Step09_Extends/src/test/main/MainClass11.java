package test.main;

import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass11 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		/*
		 * 콘솔창을 확인해서 부모객체가 미리 만들어지는 것을 체크하세요.
		 * 
		 * =>부모객체에서 먼저 호출되고 하나의 묶음(id)으로 관리됨.
		 */
		new SmartPhone();
		Phone p2=new SmartPhone();
//		HandPhone p3=new SmartPhone();   도 가능
//		SmartPhone p4=new SmartPhone();  도 가능
		
		
		System.out.println("main 메소드가 종료되었습니다");
	}
}
