package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		//1초마다 하나의 값을 출력해보세요.
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("main 메소드가 종료됩니다");
	}
}
