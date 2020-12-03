package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("숫자 입력");
		//숫자를 문자열 형식으로 입력 받는다. "10", "20", "10.1", "10.2" ...
		String inputNum=scan.nextLine();
		//1.try 블럭을 실행하다가
		try {
			//입력한 숫자를 실제 숫자로 바꾸기
			double num=Double.parseDouble(inputNum);
			double result=num+100;
			System.out.println("입력한 숫자+100 : "+result);
		} catch(NumberFormatException nfe) {
			//2. NumberFormatException type 의 예외가 발생하면 여기가 실행된다
			System.out.println("숫자 형식에 맞게 입력 하세요.");
			//예외객체의 메소드를 이용해서 stack 에 일어난 일을 콘솔에서 출력하기 
			nfe.printStackTrace(); // 어디서 어떤 이유때문에 발생했는지 알려주는 기능
		}
		System.out.println("main메소드가 종료됩니다.");
	}
}

