package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 * 회원정보(member 테이블) 의 내용을
 * select
 * insert
 * update
 * delete
 * 작업을 할 객체를 생성할 클래스 설계하기
 * 
 * -필요한 객체를 담을 지역변수를 선언하는 위치도 중요하다
 * -필요한 객체를 생성하는 위치도 중요하다
 * 
 * Data Access Object (DAO)
 * 
 * -DB에 INSERT, UPDATE, DELETE, SELECT  작업을 수행하는 객체
 * -Table 마다 하나의 DAO 혹은 주제(카테고리) 마다 하나의 DAO를 작성하게 된다.
 * -DAO를 만들기 위해서는 DTO클래스를 미리 설계를 하고 만들어야한다.
 * -주제(카테고리) 에 관련된 DAO는 여러개의 Table 의 join이 일어날 수도 있다.
 *  따라서 하나의 Table당 하나의 DAO는 아닌 것이다.
 *  예를 들어 사원정보를 출력한다고 가정을 해보면
 *  emp,dept,salgrade 3개의 테이블의 join이 일어날 수도 있다.
 */
public class MemberDao {
	//모든 회원의 정보를 SELECT 해서 리턴하는 메소드
	public List<MemberDto> selectAll(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//ArrayList<>는 한 개만 있으면 되므로 while문 밖에서 생성하고
		//리턴해줘야하므로 try밖에서 생성해주어야 한다.(try 안에서 생성하면 try안에서만 사용가능하기 때문)
		List<MemberDto> list=new ArrayList<>();
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT * FROM member ORDER BY num DESC";
			pstmt=conn.prepareStatement(sql);
			// ? 에 바인딩 할 게 있으면 하고 아님 말고
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//select 된 row 하나의 정보를 MemberDto 객체를 생성해서 담고
				MemberDto dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				//새로 생성한 MemberDto 객체의 참조값을 ArrayList 객체에 누적시킨다.
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {}
		}
		return list;
	}
	
	
	//회원 한 명의 정보를 SELECT 해서 리턴하는 메소드
	public MemberDto select(int num) {
		//회원 한 명의 정보를 담고 있는 MemberDto 객체를 담을 지역변수 만들기
		MemberDto dto=null;
		//필요한 객체의 참조값을 담을 지역변수 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT name,addr FROM member WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			// ? 에 바인딩하기
			pstmt.setInt(1, num);
			//SELECT문 수행하고 결과를 ResultSet으로 받기
			rs=pstmt.executeQuery();
			if(rs.next()) {//만일 select 된 row가 있다면
				//결과를 MemberDto 객체를 생성해서 담는다.
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {}
		}
		
		return dto;
	}
	
	//1.회원 한 명의 정보를 저장하는 메소드를 만들어보세요.
	//메소드명 : insert
	//리턴 type : 알아서
	// 메소드에 전달하는 인자의 type : MemberDto
	public boolean insert(MemberDto dto) {
		//insert 문이기 때문에 결과값 (ResultSet) 은 필요없음!
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			//미완성의 insert 문
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			// ? 에 순서대로 값을 바인딩 하기
			pstmt.setString(1, dto.getName()); // 여기서 1은 위의 첫번째 물음표
			pstmt.setString(2, dto.getAddr()); // 2는 두번째 물음표
			//executeUpdate() 는 INSERT, UPDATE, DELETE 들을 사용할 떄 사용.
			//executeQuery() 는 SELECT 문을 사용할 때 사용.
			//완성된 sql문을 수행하고 번화된 row의 갯수를 리턴받는다.
			//INSERT문 수행하기 (1개의 row가 추가됐으므로 1이 리턴된다
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다.");
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {}
		}
		if(flag>0) {
			return true;
		} else {
			return false;
		}
	}
	
	//2.회원 한 명의 정보를 수정하는 메소드를 만들어보세요.
	//메소드명 : update
	//리턴 type : 알아서
	// 메소드에 전달하는 인자의 type : MemberDto
	public boolean update(MemberDto dto) {
		PreparedStatement pstmt=null;
		Connection conn=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			// ? 에 값을 바인딩할 게 있으면 여기서 한다
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			//executeUpdate() 는 INSERT, UPDATE, DELETE 들을 사용할 떄 사용.
			//executeQuery() 는 SELECT 문을 사용할 때 사용.
			//완성된 sql문을 수행하고 번화된 row의 갯수를 리턴받는다.
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 수정했습니다.");
			System.out.println(flag);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
		if(flag>0) {
			return true;
		} else {
			return false;
		}
	}
	
	//회원 한 명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		
		//필요한 참조값을 담을 지역변수 미리 만들고 초기화하기
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
		if(flag>0) {
			return true;
		} else {
			return false;
		} 
	}
}
