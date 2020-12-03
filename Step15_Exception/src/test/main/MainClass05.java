package test.main;
/*
 * Exception 의 종류는 크게 두 가지 이다.
 * 
 * 1.RuntimeException 을 상속받아서 만든 실행중에 발생하는 Exception
 * 2.RuntimeException 을 상속받지 않아서 만든 컴파일(문법체크) 중에 발생하는 Exception
 */
public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		//'Thread.sleep(5000);' 만 입력했을 경우에는 에러나 난다. 반드시 try, catch를 사용해줘야함
		// 이 얘기는 try, catch를 반드시 사용해줘야 하는 문법이 존재한다.
		try {
			//스레드(작업단위, Thread)를 5초 잡아두기
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료됩니다");
		
	}
}
