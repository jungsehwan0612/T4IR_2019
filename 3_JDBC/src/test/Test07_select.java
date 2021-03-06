package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBCUtil;

public class Test07_select {
	public static void main(String[] args) {
		
		String sql ="select * from book"; 
		
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//? 세팅작업 
			//실행
			rs  = ps.executeQuery();
			//결과값핸들링
			while(rs.next()) {
				System.out.print(rs.getString("title")+"  ");
				System.out.print(rs.getInt("price")+"  ");
				System.out.print(rs.getDate("pubdate")+"  ");
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		
		
	}
}






