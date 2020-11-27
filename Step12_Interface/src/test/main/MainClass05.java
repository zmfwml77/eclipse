package test.main;

import test.mypac.Drill;

public class MainClass05 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 3개 뚫어요");
			}
		});
		//'()->{}' =>  카톡 사진확인..
		//'()->{}' 는 메소드가 하나일 때만 사용가능!
		//메소드가 하나라서 'new Drill'이 생략
		useDrill(()->{
			System.out.println("천장에 구멍을 2개 뚫어요");
		});
		//위 코드를 풀어쓰면
		Drill d1=()->{
			System.out.println("아무데나 구멍을 뚫어요");
		};
		useDrill(d1);
	}
	
	public static void useDrill(Drill d){
		d.hole();
	}
}
