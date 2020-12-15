package test.main;

import test.mypac.MyUtil;

public class MainClass08 {
	public static void main(String[] args) {
		//MyUtil 클래스의 static 메소드를 사용해보기.
		MyUtil.draw();
		//MyUtil.send(); 는 throw했기 떄문에 호출하려면 반드시
		//try, catch로 마무리 해줘야 함.
		//따라서 throw는 현재위치 클래스에서만 사용이 용이하다.
		try {
			MyUtil.send();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
