package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Member;

public class MemberDao {

	public int insertMember(Member m) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		String query = "insert into membership values(mem_seq.nextval,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPw());
			pstmt.setString(3, m.getMemName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getGender());
			result = pstmt.executeUpdate();
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public Member selectOneMember(Member m) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt = null;
		String query = "select * from membership where mem_id=? and mem_pw=?";
		ResultSet rset = null;
		Member loginMember = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPw());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				loginMember = new Member();
				int memNo = rset.getInt("mem_no");
				loginMember.setMemNo(memNo);
				loginMember.setMemId(rset.getString("mem_id"));
				loginMember.setMemPw(rset.getString("mem_pw"));
				loginMember.setMemName(rset.getString("mem_name"));
				loginMember.setPhone(rset.getString("phone"));
				loginMember.setEmail(rset.getString("email"));
				loginMember.setGender(rset.getString("gender"));
				loginMember.setEnrollDate(rset.getString("enroll_date"));
			}else {
				conn.rollback();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return loginMember;
	}

	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt = null;
		String query = "update membership set mem_pw=?, phone=?, email=? where mem_no=?";		
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, m.getMemPw());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setInt(4, m.getMemNo());
			result = pstmt.executeUpdate();
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		Connection conn=null;
		PreparedStatement pstmt = null;
		String query = "select * from membership";
		ResultSet rset = null;
		ArrayList<Member> am = new ArrayList<Member>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(query);			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				int memNo = rset.getInt("mem_no");
				m.setMemNo(memNo);
				m.setMemId(rset.getString("mem_id"));
				m.setMemPw(rset.getString("mem_pw"));
				m.setMemName(rset.getString("mem_name"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setGender(rset.getString("gender"));
				m.setEnrollDate(rset.getString("enroll_date"));
				am.add(m);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return am;
	}

	public int deleteMember(Member m) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		String query = "delete from membership where mem_no=?";		
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","webserver","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, m.getMemNo());
			result = pstmt.executeUpdate();
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
