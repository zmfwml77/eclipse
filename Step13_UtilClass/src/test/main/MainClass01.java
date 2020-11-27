package test.main;

import java.io.InputStream;
import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		/* Scanner scan=new Scanner(System.in); 의 코드의 뜻은 아래와 같다.
		 * 
		 * 키보드로부터 문자열을 입력받기 위한 Scanner 객체를 생성한다.
		 * 생성자의 인자로는 키보드로부터 입력받을 수 있는 InputStream type
		 * 객체를 전달해주어야 한다.
		 * 해당 객체는 System 클래스에 static final 상수 in 이라는 필드에
		 * 참조값이 미리 준비되어 있으므로 그 값을 생성자에게 전달하면 된다.
		 * (여태까지 우리가 사용했던 system. 의 기능은 out이었음.)
		 */
		Scanner scan=new Scanner(System.in);
		//콘솔창을 여는 용도로 문자열을 한 줄 출력해 준다.
		System.out.println("문자열 입력:");
		//콘솔로부터 문자열 한 줄 입력받기
		String line=scan.nextLine(); // 여기 줄에 실행이 멈춰있음.
		System.out.println("입력한 내용 :"+line);
		System.out.println("메소드가 종료됩니다");
//		InputStream is=System.in;   이렇게 담을 수도 있다.
	}
}
