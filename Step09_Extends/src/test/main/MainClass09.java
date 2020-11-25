package test.main;

import test.auto.Car;
import test.auto.Engine;

public class MainClass09 {
	public static void main(String[] args) {
//		Car car1=new Car(); 안됨. 왜? 생성자를 정의해줘서 디폴트 생성자가 사라졌으니까
		Car car1=new Car(new Engine());
		car1.drive();
	}
}
