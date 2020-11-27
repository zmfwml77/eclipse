package test.main;

import test.mypac.Remocon;

public class MainClass04 {
	public static void main(String[] args) {
		Remocon r1=new Remocon() {
			// 이 구역은 class인데 이름은 모르는 익명의 클래스.
			@Override
			public void up() {
				System.out.println("볼륨 업");
			}
			@Override
			public void down() {
				System.out.println("볼륨 다운");
			}
		};
		//r1 지연변수가 담긴값을 3번 사용해보기
		useRemocon(r1);
		useRemocon(r1);
		useRemocon(r1);
		
		//Remocon type의 참조값을 일회용으로 쓰기
		useRemocon(new Remocon() {
			@Override
			public void up() {
				System.out.println("커튼 올림");
			}
			@Override
			public void down() {
				System.out.println("커튼 내림");
			}
		});
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
