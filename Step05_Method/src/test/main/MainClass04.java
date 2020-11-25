package test.main;

import test.mypac.MyObject;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		//MyObject 클래스에 있는 usePhone() 메소드를 호출해 보세요.
		MyObject m1=new MyObject();
		Phone p1=new Phone();
		m1.usePhone(p1);
		
		System.out.println("- 위와 동일한 작업을 2 줄의 코딩으로 한다면 ");
		MyObject m2=new MyObject();
		m2.usePhone(new Phone());
		
		System.out.println("- 위와 동일한 작업을 1 줄의 코딩으로 한다면?");
		
		new MyObject().usePhone(new Phone());
		//new MyObject() => MyObject type
		//new Phone() => Phone type
		//new MyObject().usePhone(new Phone()) => void니까 type 이 없음.
		// type 이 없기 때문에 변수에 담을 수 없음
		m1.usePhone(p1);
	}
}






