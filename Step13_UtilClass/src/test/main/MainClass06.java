package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		//MemberDto 객체의 참조값을 담을 수 있는 ArrayList 객체를 생성해서
		//ArrayList 객체의 참조값을 List type 지역변수 members에 담기
		List<MemberDto> members=new ArrayList<MemberDto>();
		//3명의 회원 정보를 members 배열의 담아보세요
		//선생님 답(다양한 예시)
		MemberDto mem1=new MemberDto();
		mem1.setNum(1);
		mem1.setName("김구라");
		mem1.setAddr("노량진");
		members.add(mem1);
		
		MemberDto mem2=new MemberDto(2,"해골","행신동");
		members.add(mem2);
		
		members.add(new MemberDto(3, "원숭이","상도동"));
		
		//mem1에 있는 number type '1'을 참조하는 방법은? => 밑 두가지 방법은 동일한 코드임
		mem1.getNum(); // num은 private로 되어있기 때문에 'mem1.num;' 이 안 됨
		members.get(0).getNum();
		
		//"행신동"을 참조하는 방법?
		mem2.getAddr();
		members.get(1).getAddr();
		
		//"원숭이"를 참조하는 방법?
		members.get(2).getName(); // 지역변수에 들어지 않기 때문에 이 방법 뿐임.
		
		/*
		 * members 에 들어있는 참조값을 이용해서 반복문 돌면서 
		 * 아래와 같은 형식으로 회원 정보를 출력해보세요
		 * 
		 * 번호는 1, 이름은 김구라, 주소는 노량진
		 * 번호는 2, 이름은 해골,  주소는 행신동
		 * 번호는 3, 이름은 원숭이, 주소는 상도동
		 */
		for(int i=0; i<members.size(); i++) {
			System.out.println("번호는 "+members.get(i).getNum()+
							   ", 이름은 "+members.get(i).getName() +
							   ", 주소는 "+members.get(i).getAddr());
		}
		System.out.println("----------------------------");
		for(int i=0; i<members.size(); i++) { //이 패턴을 더 추천하심.
			MemberDto tmp=members.get(i);
			String info="번호는 "+tmp.getNum()+
					    ", 이름은 "+tmp.getName()+
					    ", 주소는 "+tmp.getAddr();
			System.out.println(info);
		}
		System.out.println("----------------------------");
		for(int i=0; i<members.size(); i++) {
			MemberDto tmp=members.get(i);
			
		}
		 //바로 위 for문을 줄여서하면 이렇게.(확장 for문),i 가 필요없을 때 사용 => Generic의 타입 + 지역변수명:ArrayList 변수명
		for(MemberDto tmp:members) { 
			String info="번호는 "+tmp.getNum()+
				    ", 이름은 "+tmp.getName()+
				    ", 주소는 "+tmp.getAddr();
			System.out.println(info);
		}
	}
}
/*선생님 답 처럼 객체를 생성하면 heap영역에 객체가 총 4개(MemberDto 객체3개, ArrayList 객체1개)생성됨
 * ArrayList에는 MemberDto type의 index의 참조값이 들어있다.
 * 수업 내용 홈페이지 40쪽 참고!!*/
