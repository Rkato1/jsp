package board.model.service.copy;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardPageData;

public class BoardService {

	public BoardPageData selectList(int reqPage) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		BoardDao dao = new BoardDao();
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
		//System.out.println(start);
		//System.out.println(end);
		
	
		ArrayList<Board> list = dao.selectList(conn, reqPage,start,end);
		//페이지네비게이션만들기
		//밑 버튼의 길이
		int pageNaviSize = 5;
		//페이지 네비태그 작성용
		String pageNavi="";
		//페이지 네비 시작번호 구하기
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
//		//이전버튼, 페이지 시작번호가 1이 아닌 경우에만 이전버튼 생성
//		if(pageNo != 1) {
//			pageNavi += "<a class='btn' href='/boardList?reqPage="+(pageNo-1)+"'>이전</a>";
//		}
//		//페이지 네비 숫자
//		//기존코드
//		for(int i=0; i<pageNaviSize; i++) {
//			//현재페이지
//			if(reqPage==pageNo) {
//				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
//			}else {
//				pageNavi += "<a class='btn' href='/boardList?reqPage="+pageNo+"'>"+pageNo+"</a>";
//			}
//			pageNo++;
//			if(pageNo>totalPage) {
//				break;
//			}
//		}
				
		//뭔가 꼬였음 주말에 해결
		if(pageNaviSize%2==1) {
			if((reqPage-pageNaviSize/2) > 1) {
				pageNavi += "<a class='btn' href='/boardList?reqPage="+(pageNo-1)+"'>이전</a>";
			}
			int max = reqPage+pageNaviSize/2+1;
			System.out.println("premax"+max);
			if(max<=pageNaviSize) {
				max=pageNaviSize+1;
			}
			System.out.println("aftermax1"+max);
			int min = reqPage-pageNaviSize/2;
			if(min<1) {
				min=1;
			}
			else if(max>totalPage) {
				min=reqPage-(pageNaviSize/2)*2;
				max=totalPage;
			}
			System.out.println("aftermin"+min);
			System.out.println("aftermax2"+max);
			for(int i=min; i<max; i++) {				
				if(reqPage==i) {
					pageNavi += "<span class='selectPage'>"+i+"</span>";
				}else {
					pageNavi += "<a class='btn' href='/boardList?reqPage="+i+"'>"+i+"</a>";
				}				
				if(i>=totalPage) {
					break;
				}
			}
			//다음버튼, 번호가 최대치를 넘기지 않는 경우
			if(pageNo<= totalPage) {
				pageNavi += "<a class='btn' href='/boardList?reqPage="+pageNo+"'>다음</a>";
			}
			BoardPageData npd = new BoardPageData(list, pageNavi);
			JDBCTemplate.close(conn);
			return npd;
		}else {
			if(pageNo != 1) {
				pageNavi += "<a class='btn' href='/boardList?reqPage="+(pageNo-1)+"'>이전</a>";
			}
			for(int i=0; i<pageNaviSize; i++) {
				//현재페이지
				if(reqPage==pageNo) {
					pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
				}else {
					pageNavi += "<a class='btn' href='/boardList?reqPage="+pageNo+"'>"+pageNo+"</a>";
				}
				pageNo++;
				if(pageNo>totalPage) {
					break;
				}
			}
			//다음버튼, 번호가 최대치를 넘기지 않는 경우
			if(pageNo<= totalPage) {
				pageNavi += "<a class='btn' href='/boardList?reqPage="+pageNo+"'>다음</a>";
			}
			BoardPageData npd = new BoardPageData(list, pageNavi);
			JDBCTemplate.close(conn);
			return npd;
		}
		
		
//		if(pageNo<= totalPage) {
//			pageNavi += "<a class='btn' href='/boardList?reqPage="+pageNo+"'>다음</a>";
//		}
//		BoardPageData npd = new BoardPageData(list, pageNavi);
//		JDBCTemplate.close(conn);
//		return npd;
	}

}
