package ajax.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.filters.RestCsrfPreventionFilter;

import common.JDBCTemplate;

public class AjaxDao {

	public ArrayList<String> selectAddr(String sel) {
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select addr2 from addr where addr1 = ?";
		ArrayList<String> list = new ArrayList<String>();		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sel);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String addr = rset.getString("addr2");
				list.add(addr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		return list;
	}

}
