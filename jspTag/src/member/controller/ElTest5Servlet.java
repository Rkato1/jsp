package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;

/**
 * Servlet implementation class ElTestServlet
 */
@WebServlet(name = "ElTest5", urlPatterns = { "/elTest5" })
public class ElTest5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElTest5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m1 = new Member("이름1",1,"주소1");
		Member m2 = new Member("이름2",2,"주소2");
		Member m3 = new Member("이름3",3,"주소3");
		Member m4 = new Member("이름4",4,"주소4");
		
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/el/elTest5.jsp");
		request.setAttribute("m", m1);
		request.setAttribute("m2", m2);
		session.setAttribute("m3", m3);
		session.setAttribute("m", m4);
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
