package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateFormServlet
 */
@WebServlet(name = "NoticeUpdateForm", urlPatterns = { "/noticeUpdateForm" })
public class NoticeUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateFormServlet() {
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
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice n = new NoticeService().selectOneNotice(noticeNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/notice/noticeUpdateForm.jsp");
		request.setAttribute("n", n);
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
