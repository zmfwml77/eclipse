package teat.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 * Scanner 객체를 이용해서 검색할 회원의 번호를 입력받아서 
 * 입력받은 숫자를 이용해서 SELECT 문을 수행하고
 * 결과값을 MemberDto 객체를 생성해서 담아보세요.
 * 
 * 결과가 없다면 MemberDto 객체를 생성하지 마세요(null인 상태로 두기)
 */
public class MainClass07 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 번호 입력 : ");
		int num=scan.nextInt();
		
		//검색된 회원 정보가 담길 MemberDto 객체릐 참조값을 담을 지역변수
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT name, addr FROM member WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,  num);
			rs=pstmt.executeQuery();
			if(rs.next()) { //select 된 결과가 있다면
				//MemberDto 객체를 생성해서
				dto=new MemberDto();
				//setter 메소드를 이용해서 값을 담는다
				dto.setNum(num);
				//ResultSet 객체이 있는 값도 얻어와서 담아준다
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (Exception e) {}
			}
		}
	}
}
