package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* 자주 사용하지는 않지만 알아두면 좋음
 * HashSet 클래스는 Set 인터페이스를 구현한 클래스이다.
 * - 저장된 데이터를 순서없이 무작위로 관리한다.
 * - key 값도 없다.
 * - 중복을 허용하지 않는다( 같은 값이 두 개 이상 존재할 수 없다 )
 * - 어떤 data 를 묶음(집합) 으로 관리하고자 할 때 사용한다.
 * - 중복된 데이터를 제거할 때도 유용하다.
 */
public class MainClass09 {
	public static void main(String[] args) {
		//정수 값을 저장할 수 있는 HashSet 객체
		Set<Integer> set1=new HashSet<Integer>();
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(30);
		set1.add(30);
		//어떤 data 가 Set에 있는지 여부를 리턴하는 메소드
		boolean result1=set1.contains(10);
		boolean result2=set1.contains(50);
		System.out.println(result1); // ?
		System.out.println(result2); // ?
		
		//Set 이 비어있는지 여부를 리턴
		boolean result3=set1.isEmpty();
		System.out.println(result3); // ?
		
		int size = set1.size();
		System.out.println(size); // ?
		
		//set1 에는 인덱스도 없는 애들 무작위로 (10,20,30)이 있는데
		//원하는 data를 참조할 때는 어떻게?
		//정수가 일렬로 담겨진 Iterator 객체의 참조값 얻어내기
		Iterator<Integer> it=set1.iterator();
		//커서 다음에 데이터가 있으면
		while(it.hasNext()) {
			//커서를 다음 데이터로 옮겨서 해당 데이터를 읽어낸다
			Integer tmp=it.next();
			//읽어낸 데이터 콘손에 출력하기
			System.out.println(tmp);
		}
		//while(반복문)문은 정확한 갯수의 값을 알 수 없을 때 사용.
	}
}
