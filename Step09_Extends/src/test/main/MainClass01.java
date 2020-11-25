package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass01 {
	//run 했을 때 application의 시작점 도입점이 되는 main 메소드
	public static void main(String[] args) {
		//Phone 의 참조값을 지역변수 p에 담을 예정. 언제 담기냐? Run했을 때.
		Phone p1 = new Phone();
		HandPhone p2 = new HandPhone();
		/* p1. 과  p2. 비교를하면  HandPhone Class에서 Phone Class를 'extends Phone' (상속)
		 * 받았기 떄문에 p2. 을 하면 Phone Class, HandPhone Class 두가지 메소드를 사용할 수 있다. */
		 
		 //부모클래스(Phone)에 정의된 메소드 호출가능
		p2.call();
		//자식클래스(HandPhone)에 추가된 메소드는 당연히 호출가능
		p2.mobileCall();
		p2.takePicture();
	}
}
