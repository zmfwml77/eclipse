package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass04 {
	public static void main(String[] args) {
		//정수를 저장할 ArrayList 객체를 생성해서 참조값을 nums라는 지역변수에 담아보세요
		List<Integer> nums=new ArrayList<>(); //int 는 클래스가 아니라서 Integer로 해야함
//		nums.add(new Integer(10)); 정석은 이거임
		nums.add(10);
		nums.add(20);
		nums.add(30);
		
		//실수를 저장할 ArrayList 객체를 생성해서 참조값을 nums2라는 지역변수에 담아보세요
		List<Double>nums2=new ArrayList<>(); //double은 예약이 이기떄문에 Double로 해야함
		nums2.add(10.1);
		nums2.add(10.2);
		nums2.add(10.3);
	}
}
