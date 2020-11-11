package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import model.vo.Member;

public class MemberDao {

	public Member selectOneMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginMember = null;
		String query = "select * from member where mem_id=? and mem_pw=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPw());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				loginMember = new Member();
				loginMember.setAddress(rset.getString("address"));
				loginMember.setEnrollDate(rset.getString("enroll"));
				loginMember.setMemId(rset.getString("mem_id"));
				loginMember.setMemName(rset.getString("mem_name"));
				loginMember.setMemNo(rset.getInt("mem_no"));
				loginMember.setMemPw(rset.getString("mem_pw"));
				loginMember.setPhone(rset.getString("phone"));
				loginMember.setMemLevel(rset.getInt("mem_level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		// TODO Auto-generated method stub
		return loginMember;
	}

	public int insertMember(Connection conn, Member m) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member values(mem_seq.nextval,?,?,?,?,?,3,to_char(sysdate,'yyyy-mm-dd'))";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPw());
			pstmt.setString(3, m.getMemName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member selectOneMember(Connection conn, String memId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select * from member where mem_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getString("enroll"));
				m.setMemId(rset.getString("mem_id"));
				m.setMemName(rset.getString("mem_name"));
				m.setMemNo(rset.getInt("mem_no"));
				m.setMemPw(rset.getString("mem_pw"));
				m.setPhone(rset.getString("phone"));
				m.setMemLevel(rset.getInt("mem_level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		// TODO Auto-generated method stub
		return m;
	}

}
