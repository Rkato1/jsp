package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;

public class NoticeService {

	public NoticePageData selectList(int reqPage) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		int totalCount = dao.totalCount(conn);
		//한페이지 당 게시물 수
		int numPerPage = 10;
		int totalPage = 0;
		if(totalCount%numPerPage==0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		int start = (reqPage-1)*numPerPage + 1;
		int end = reqPage*numPerPage;
		System.out.println(start);
		System.out.println(end);
		
		//System.out.println(totalCount);
		ArrayList<Notice> list = dao.selectList(conn, reqPage,start,end);
		//페이지네비게이션만들기
		//밑 버튼의 길이
		int pageNaviSize = 5;
		//페이지 네비태그 작성용
		String pageNavi="";
		//페이지 네비 시작번호 구하기
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		//이전버튼, 페이지 시작번호가 1이 아닌 경우에만 이전버튼 생성
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		//페이지 네비 숫자
		for(int i=0; i<pageNaviSize; i++) {
			//현재페이지
			if(reqPage==pageNo) {
				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class='btn' href='/noticeList?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼, 번호가 최대치를 넘기지 않는 경우
		if(pageNo<= totalPage) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage="+pageNo+"'>다음</a>";
		}
		NoticePageData npd = new NoticePageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return npd;
	}

	public int insertNotice(Notice n) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Notice selectOneNotice(int noticeNo){
		Connection conn = JDBCTemplate.getConnection();
		Notice n = new NoticeDao().selectOneNotice(conn, noticeNo);
		if(n!=null) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return n;
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNotice(conn, noticeNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNotice(conn, n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
