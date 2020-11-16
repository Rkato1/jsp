package board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet(name = "BoardDelete", urlPatterns = { "/boardDelete" })
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
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
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board n = new BoardService().selectOneBoard(boardNo);
		int result = new BoardService().deleteBoard(boardNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			//해당 공지사항에 첨부파일이 있는 경우
			if(n.getFilepath() != null) {
				String root = getServletContext().getRealPath("/");
				String saveDirectory = root+"upload/board/";
				File delFile = new File(saveDirectory+n.getFilepath());
				boolean delResult = delFile.delete();
				if(delResult) {
					System.out.println("파일 삭제 성공");
				}else {
					System.out.println("파일 삭제 성공");
				}
			}
			request.setAttribute("msg", "삭제완료");
			request.setAttribute("loc", "/boardList?reqPage=1");
		}else {
			request.setAttribute("msg", "공지사항 삭제 실패");
			request.setAttribute("loc", "/boardView?boardNo="+boardNo);
		}
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
