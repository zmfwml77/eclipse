package test.pratice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

public class MainSelect01 {
	public static void main(String[] args) {
		//member 테이블의 모든 내용을 select해서 console에 출력
		Connection conn=null;
		conn=new DBConnect().getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM member ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				System.out.println(num+name+addr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {}
		}
	}
}
