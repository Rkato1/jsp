package model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import model.dao.MemberDao;
import model.vo.Member;

public class MemberService {

	public Member selectOneMember(Member m) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		Member loginMember = new MemberDao().selectOneMember(conn, m);
		JDBCTemplate.close(conn);
		return loginMember;
	}

	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMember(conn, m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member selectOneMember(String memId) {
		Connection conn = JDBCTemplate.getConnection();
		Member result = new MemberDao().selectOneMember(conn, memId);
		JDBCTemplate.close(conn);
		return result;
	}

}
