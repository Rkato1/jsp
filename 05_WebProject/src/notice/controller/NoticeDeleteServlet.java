package notice.controller;

import java.io.File;
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
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet(name = "NoticeDelete", urlPatterns = { "/noticeDelete" })
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
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
		int result = new NoticeService().deleteNotice(noticeNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			//해당 공지사항에 첨부파일이 있는 경우
			if(n.getFilepath() != null) {
				String root = getServletContext().getRealPath("/");
				String saveDirectory = root+"upload/notice/";
				File delFile = new File(saveDirectory+n.getFilepath());
				boolean delResult = delFile.delete();
				if(delResult) {
					System.out.println("파일 삭제 성공");
				}else {
					System.out.println("파일 삭제 성공");
				}
			}
			request.setAttribute("msg", "삭제완료");
			request.setAttribute("loc", "/noticeList?reqPage=1");
		}else {
			request.setAttribute("msg", "공지사항 삭제 실패");
			request.setAttribute("loc", "/noticeView?noticeNo="+noticeNo);
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
