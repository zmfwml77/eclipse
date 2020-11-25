package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * [ 다형성 ] 
		 * 
		 * - 객체는 여러가지 type 을 가질 수 있다.
		 * - 상속 관게에 따라서 여러가지 type 이 된다
		 * - 아래의 HandPhone 객체는 3가지 type(Phone, HandPhone, Object)을 가진다.*/
		
		//HandPhone 객체를 생성해서 참조값을 HandPhone type 변수에 담기
		HandPhone p1 = new HandPhone();
		//HandPhone 객체를 생성해서 참조값을 Phone type 변수에 담기
		Phone p2 = new HandPhone(); /* p2. 하면 HandPhone에 있는 메소드는 사용하지 못함. 왜? 타입이 Phone타입이라서
				 					      근데 방법은 있음. MainClass03 에서..(캐스팅 사용) */
		//HandPhone 객체를 생성해서 참조값을 Object type 변수에 담기
		Object p3 = new HandPhone(); /* p3. 하면 HandPhone에 있는 메소드는 사용하지 못함. 왜? 타입이 Object타입이라서
		 								근데 방법은 있음. MainClass03 에서..(캐스팅 사용) */
	}
}
