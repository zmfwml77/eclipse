package test.mypac;

public class HandPhone extends Phone/* 'expends Object' 가 생략돼있음 */{
	//디폴트 생성자 'public HandPhone(){}' 가 생략돼있음
	//이동중에 전화를 걸어요
	public void mobileCall() {
		System.out.println("이동중에 전화를 걸어요");
	}
	public void takePicture() {
		System.out.println("30만 화소의 사진을 찍어요");
	}
	
}
