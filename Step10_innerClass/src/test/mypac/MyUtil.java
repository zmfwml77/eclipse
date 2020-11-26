package test.mypac;

public class MyUtil {
	private String owner="김구라";
	
	private void test() {
		System.out.println("MyUtil 테스트중입니다.");
	}
	/*
	 * 내부 클래스 안에서 바깥에 자신을 포함하고 있는 클래스의
	 * 멤버(필드, 메소드)는 자유롭게 내 것 처럼 접근해서 사용할 수 있다.
	 * => System.out.println(owner);
			test();
		이런 편리함 때문에 android 프로그래밍 할 때 종종 사용된다.
	 */
	public class User{
		public void doSomething() {
			//바깥에 자신을 포함하고 있는 객체의 참조값을 가리키는 방법은
			//바깥클래스명.this 이다
			System.out.println(MyUtil.this.owner);
			MyUtil.this.test();
			
			//혼돈의 소지가 없다면 MyUtil.this 생략가능
			//'혼돈의 소지'의 예시는 doSomething class안에 'String owner="원숭이";' 가 될 수 있음.
			System.out.println(owner);
			test();
			//여기서 this는 User의 참조값을 가리킴.
			
			//아래의 type을 확인해보세요.
			MyUtil a = MyUtil.this;
			User b=this;
		}
	}
}
