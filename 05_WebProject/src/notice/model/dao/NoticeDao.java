package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.vo.Notice;

public class NoticeDao {
	
	//페이징처리
	//사용자가 보내줘야하는 값
	//1. 몇번째 페이지를 요청하는지
	//개발자가 지정해야하는값
	//1.한페이지에 몇개의 게시물을 보여줄지여부(10)
	//2.페이지 네비게이션 길이(5), 밑 버튼의 길이
	//계산해야하는 값(총 게시물의 수, 몇번째 페이지 요청)
	public ArrayList<Notice> selectList(Connection conn, int reqPage, int start, int end) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		//1번부터 보여줄때
		//String query = "select * from notice";
		String query = "select * from(select rownum as rnum, n.* from (select * from notice order by 1 desc)n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Notice n = new Notice();
				n.setrNum(rset.getInt("rnum"));
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("notice_writer"));				
				n.setNoticeDate(rset.getString("notice_date"));				
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	//총게시물수 구하기
	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		String query = "select count(*) cnt from notice";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
