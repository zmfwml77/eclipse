package teat.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/* MainClass01음 참고
 * 접속 ip 주소 : 14.63.164.99
 * 아이디 : acorn01
 * 비밀번호 : tiger01
 * 
 * 위의 DB 에 접속해서
 * emp 테이블의 내용중에서 사원번호(empno), 사원이름(ename), 부서번호(deptno)
 * 를 select 해서 콘솔창에 출력해보세요.
 * 단, 사원번호에 대해서 오름차순 정렬..
 */
public class MainClass02 {
	public static void main(String[] args) {
		//DB 연결 객체를 담을 지역변수
		Connection conn=null;
		try {
			//드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB정보
			String url="jdbc:oracle:thin:@14.63.164.99:1521:xe";
			//접속하고 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "acorn01", "tiger01");
			System.out.println("Oracle DB 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//위 코드는 몰라도 되지만 흐름은 이해하기
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="SELECT empno, ename, deptno FROM emp ORDER BY empno DESC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				int deptno=rs.getInt("deptno");
				System.out.println(empno+"|"+ename+"|"+deptno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
		System.out.println("main 메소드가 종료됩니다");
	}
}
