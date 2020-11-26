package test.mypac;

//미완성의 메소드를 멤버로 가지고 있으려면 absrtact 예약어를 붙인다.
public abstract class Weapon {
	//무기 작동을 준비하는 메소드
	public void prepare() {
		System.out.println("무기 작동을 준비합니다.");
	}
	//공격하는 메소드
//	public void attack(); =>  중괄호가 없어서 문법적으로 맞지 않음.
	//여기서 오류가 발생하지 않게하는 방법은
	public abstract void attck(); // 미완성의 메소드를 만들 때 abstract 예약어를 만든다
//	new Weapon().attck();
}
