package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import util.JDBCUtil;

public class Test03 {
	public static void main(String[] args) {

		String sname =
				JOptionPane.showInputDialog("검색할 사원의 이름을 입력하세요!");
	
        Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
//String sql="select * from emp where lower(ename) like '%'||?||'%'";
			String sql="select * from emp where lower(ename) like ?";
			con = JDBCUtil.getConnection();

			ps = con.prepareStatement(sql);
			//? 세팅작업 
			//ps.setString(1, sname.toLowerCase());
			ps.setString(1, "%"+sname.toLowerCase()+"%");
			
			//실행
			rs = ps.executeQuery();
			//결과값핸들링
			while(rs.next()) {
				System.out.print(rs.getString("ename")+"  ");
				System.out.print(rs.getString("deptno")+"  ");
				System.out.print(rs.getString("job")+"  ");
				System.out.print(rs.getDate("hiredate")+"  ");
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






