package test.main;

import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("나눌 수 입력");
		String inputNum1=scan.nextLine();
		System.out.println("나누어 지는 수 입력 : ");
		String inputNum2=scan.nextLine();
		
		try {
			//입력한 숫자형식의 문자열을 실제 정수로 바꾸기
			int num1=Integer.parseInt(inputNum1);
			int num2=Integer.parseInt(inputNum2);
			
			//정수를 정수로 나누면 소수점은 잘리고 정수만 남는다(나눈 몫이 구해진다)
			int result=num2/num1;
			int result2=num2%num1; // 나머지 연산자를 이용해서 나눈 나머지값을 구한다.
			System.out.println(num2+" 를"+num1+" 으로 나눈 몫은"+result);
			System.out.println(num2+" 를"+num1+" 으로 나눈 나머지는"+result2);
		} catch(NumberFormatException nfe) {
//			nfe.printStackTrace();
			System.out.println("정수를 입력하세요");
		} catch(ArithmeticException ae) {
			ae.printStackTrace();
			System.out.println("어떤 수를 0으로 나눌 수 없어요");
		}
		System.out.println("main 메소드가 종료됩니다.");
	}
}
