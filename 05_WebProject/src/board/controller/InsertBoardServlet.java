package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet(name = "InsertBoard", urlPatterns = { "/insertBoard" })
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		//파일업로드 형식이 맞는지 검사(enctype=multipart/form-data인지 확인)
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "공지사항 작성 오류[enctype]");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
//		else {
//			String boardTitle = request.getParameter("boardTitle");
//			System.out.println(boardTitle);
//		}
		//파일 업로드 준비
		//1)파일 업로드 경로설정
		//WebContent폴더의 절대경로
		String root =getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/board";
		System.out.println(saveDirectory);
		//2)파일 최대크기 지정(cos라이브러리 무료버전의 경우 최대 10MB까지 가능)
		//byte=>kb=>mb=>gb=>tb
		int maxSize = 10*1024*1024;
		//request->MultipartRequest 객체로 변환하면서 파일이 업로드
		//요청,저장경로,최대크기,인코딩,이름지정규칙처리
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize,"UTF-8", new DefaultFileRenamePolicy());
		Board n = new Board();
		n.setBoardTitle(mRequest.getParameter("boardTitle"));
		n.setBoardWriter(mRequest.getParameter("boardWriter"));
		n.setBoardContent(mRequest.getParameter("boardContent"));
		n.setFilename(mRequest.getOriginalFileName("filename"));
		n.setFilepath(mRequest.getFilesystemName("filename"));
		
		int result = new BoardService().insertBoard(n);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "공지사항 등록 성공");
		}else {
			request.setAttribute("msg", "공지사항 등록 실패");
		}
		request.setAttribute("loc", "/boardList?reqPage=1");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
