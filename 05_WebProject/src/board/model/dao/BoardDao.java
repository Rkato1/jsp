package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.model.vo.Board;
import common.JDBCTemplate;
import board.model.vo.Board;

public class BoardDao {
	
	//페이징처리
	//사용자가 보내줘야하는 값
	//1. 몇번째 페이지를 요청하는지
	//개발자가 지정해야하는값
	//1.한페이지에 몇개의 게시물을 보여줄지여부(10)
	//2.페이지 네비게이션 길이(5), 밑 버튼의 길이
	//계산해야하는 값(총 게시물의 수, 몇번째 페이지 요청)
	public ArrayList<Board> selectList(Connection conn, int reqPage, int start, int end) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();		
		String query = "select * from (select rownum as rnum, n.* from (select * from board order by 1 desc)n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setrNum(rset.getInt("rnum"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setBoardTitle(rset.getString("board_title"));
				b.setBoardWriter(rset.getString("board_writer"));				
				b.setBoardDate(rset.getString("board_date"));				
				list.add(b);
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
		String query = "select count(*) cnt from board";
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

	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result=0;
		String query="insert into board values(board_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardWriter());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setString(4, b.getFilename());
			pstmt.setString(5, b.getFilepath());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Board selectOneBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board n = null;
		String query = "select * from board where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				n = new Board();
				n.setBoardNo(rset.getInt("board_no"));
				n.setBoardTitle(rset.getString("board_title"));
				n.setBoardWriter(rset.getString("board_writer"));
				n.setBoardContent(rset.getString("board_content"));
				n.setBoardDate(rset.getString("board_date"));
				n.setFilename(rset.getString("filename"));
				n.setFilepath(rset.getString("filepath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return n;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query="delete from board where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result=0;
		String query="update board set board_title=?,board_content=?,filename=?,filepath=? where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getFilename());
			pstmt.setString(4, b.getFilepath());
			pstmt.setInt(5, b.getBoardNo());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
