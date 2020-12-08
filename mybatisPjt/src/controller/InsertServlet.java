package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.StudentService;
import model.vo.Student;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet(name = "Insert", urlPatterns = { "/insert" })
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Student s = new Student();
		s.setStuName(request.getParameter("stuName"));
		s.setStuPhone(request.getParameter("stuPhone"));
		s.setEmail(request.getParameter("email"));
		s.setAddr(request.getParameter("addr"));
		
		int result = new StudentService().insert(s);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "등록 성공");
		}else {
			request.setAttribute("msg", "등록 실패");
		}
		request.setAttribute("loc", "/");
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
