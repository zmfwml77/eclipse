package teat.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

/*
 * member 테이블에서
 * 회원번호가 832 번 회원 정보를 삭제하는 기능을 완성해보기
 * [hint]
 * new DBConntext().getConn();
 */
public class MainClass05 {
	public static void main(String[] args) {
		//삭제할 회원의 번호
		int num=832;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 sql 문의 뼈대 준비하기
			String sql="DELETE FROM member WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩하기
			pstmt.setInt(1, num);
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 삭제했습니다");
			System.out.println("flag : "+flag);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
		if(flag>0) {
			System.out.println("삭제(DELETE) 성공");
		} else {
			System.out.println("삭제(DELETE) 실패");
		} // 마지막에 실패라고 뜨는 이유는 이미 삭제했기 때문.
	}
}
