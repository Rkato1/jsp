package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDao;
import model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		Member m = new Member();
		m.setMemId(memId);
		m.setMemPw(memPw);
		Member loginM = new MemberDao().selectOneMember(m);
		if(loginM!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginM);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/msg.jsp");
		if(loginM!=null) {
			request.setAttribute("msg", "로그인 성공");
		}else {
			request.setAttribute("msg", "로그인 실패");
		}
		request.setAttribute("loc", "/");
		rd.forward(request, response);
		//사용자를 이동시키는 함수
		//response.sendRedirect("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

