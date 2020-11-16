package board.controller;

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
 * Servlet implementation class BoardUpdateFormServlet
 */
@WebServlet(name = "BoardUpdateForm", urlPatterns = { "/boardUpdateForm" })
public class BoardUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateFormServlet() {
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
		Board b = new BoardService().selectOneBoard(boardNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/boardUpdateForm.jsp");
		request.setAttribute("b", b);
		rd.forward(request, response);
		//기존 첨부 파일이 있는 경우
		//-변화없이 적용 되는 경우
		//-기존 파일 삭제 후 새 파일이 업로드 되는 경우
		
		//기존 첨부 파일이 없는 경우
		//-변화없이 적용 되는 경우
		//-새 파일이 업로드 되는 경우
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
