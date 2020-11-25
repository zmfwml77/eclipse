package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass07 {
	public static void main(String[] args) {
		MainClass07.usePhone(new Phone());
		MainClass07.usePhone(new HandPhone());
		MainClass07.usePhone(new SmartPhone());
	}
	
	public static void usePhone(Phone p) {
		p.call();
		//만일 p 안에 있는 값이 HandPhone type이 맞다면..
		// instanceof 라는 연산자는 true of false 를 나타냄(=boolean type)
		//  ㄴ p가 HandPhone 타입이 맞으면 true
		if(p instanceof HandPhone) { 
			HandPhone p2=(HandPhone)p;
			p2.mobileCall();
		}
	}
}
