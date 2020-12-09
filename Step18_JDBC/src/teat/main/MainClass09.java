package teat.main;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MainClass09 {
	public static void main(String[] args) {
		// 850번 회원의 정보를 삭제하고자 한다.
		
		//이미 만들어진 클래스로 객체를 생성해서
		MemberDao dao=new MemberDao();
		//메소드를 사용하는 사용자 입장이다.
		boolean isSuccess=dao.delete(850);
		//하지만 위 작업의 성공 여부를 알 수 없다.
		//위의 클래스는 여러분의 상사인 대리가 설계해서 만들었다고 가정하자.
		//자~ 이제 여러분은 어떻게 할 것인가?
		if(isSuccess) {
			System.out.println("삭제 성공!");
		} else {
			System.out.println("삭제 실패!");
		}
		
		//insert
		MemberDto dto1=new MemberDto();
		dto1.setName("dd");
		dto1.setAddr("ff");
		boolean insert=dao.insert(dto1);
		if(insert) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
		System.out.println("main 메소드가 종료됩니다");
	}
}
