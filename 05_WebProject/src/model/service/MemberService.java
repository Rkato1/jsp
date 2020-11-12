package model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicBorders.RolloverButtonBorder;

import common.JDBCTemplate;
import model.dao.MemberDao;
import model.vo.Member;
import sun.management.jdp.JdpBroadcaster;

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

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDao().selectAllMember(conn);
		return list;
	}

	public int changeLevel(int memLevel, int memNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().changeLevel(conn, memLevel, memNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean changeAllLevel(String num, String level) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		StringTokenizer sT1 = new StringTokenizer(num,"/");
		StringTokenizer sT2 = new StringTokenizer(level,"/");
		boolean result = true;
		while(sT1.hasMoreTokens()) {
			int memNo = Integer.parseInt(sT1.nextToken());
			int memLevel = Integer.parseInt(sT2.nextToken());
			int result1 = new MemberDao().changeLevel(conn, memLevel, memNo);
			if(result1==0) {
				result = false;
				break;
			}
		}
		if(result) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Member> searchKeyword(String type, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = null;
		if(type.equals("memId")) {
			list = new MemberDao().searchKeywordId(conn,keyword);
		}else if(type.equals("memName")) {
			list = new MemberDao().searchKeywordName(conn,keyword);
		}
		JDBCTemplate.close(conn);
		// TODO Auto-generated method stub
		return list;		
	}

	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(conn,memId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

}
