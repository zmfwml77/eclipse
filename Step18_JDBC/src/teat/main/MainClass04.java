package teat.main;
/*
 * member 테이블에서
 * num 이 804 번인 회원의
 * 주소를 노량진으로 수정하는 코드를 작성해보세요.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass04 {
	public static void main(String[] args) {
		//아래의 정보를 member 테이블에 저장하고자 한다.
		int num=804;
		String addr="노량진";
		
		//DB 연결 객체를 담을 지역변수
		Connection conn=null;
		try {
			//드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB정보
			String url="jdbc:oracle:thin:@14.63.164.99:1521:xe";
//			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//접속하고 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "acorn01", "tiger01");
//			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//위 코드는 몰라도 되지만 흐름은 이해하기
		
		//UPDATE 문이기 때문에 결과값 (ResultSet) 은 필요없음!
				PreparedStatement pstmt=null;
				int flag=0;
				try {
					String sql="UPDATE member"
							+ " SET addr=?"
							+ " WHERE num=?";
					pstmt=conn.prepareStatement(sql);
					// ? 에 순서대로 값을 바인딩 하기
					pstmt.setString(1, addr);
					pstmt.setInt(2, num);
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
					System.out.println("작업(INSERT) 성공");
				} else {
					System.out.println("작업(INSERT) 실패");
				}
	}
}
