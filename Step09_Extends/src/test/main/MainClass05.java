package test.main;

import test.mypac.Phone;
import test.mypac.SmartPhone;
/*
 * 여러분이 키우는 자녀가 있다고 가정하자
 * 자녀가 현재 사용하는 핸드폰이 인터넷이 안 되는 구형폰이다
 * 여러분의 자녀가 인터넷을 하고싶어서 스마트폰이 갖고 싶다고 조른다
 * 여러분은 어떻게 할 것인가? 정답 1.
 * 
 * 1. 스마트폰을 새로 사준다(만들어서 준다)
 * 2. 스마트폰의 사용설명서만 가지고 와서 현재 폰의 설명서라고 우기고
 *    그냥 그 폰을 쓰라고 한다.
 */
public class MainClass05 {
	public static void main(String[] args) {
		//밑 코드의 이상한 점?
		//runtime 시에 ClassCastException이 발생한다.
		//위의 설명에서 2번같은 경우이다.
		Phone p1=new Phone();
//		Phone p1=new SmartPhone(); 정답은 이렇게.
		SmartPhone p2=(SmartPhone)p1;
		p2.doInternet();
	}
}
