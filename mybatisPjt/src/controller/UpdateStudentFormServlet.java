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
 * Servlet implementation class UpdateStudentFormServlet
 */
@WebServlet(name = "UpdateStudentForm", urlPatterns = { "/updateStudentForm" })
public class UpdateStudentFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		Student s = new StudentService().searchStudent(stuNo);
		if(s!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/updateStudentForm.jsp");
			request.setAttribute("s", s);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/msg.jsp");
			request.setAttribute("msg", "회원정보없음");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
