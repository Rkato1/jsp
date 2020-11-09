package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title></title></head>");
		out.println("<body>");
		//알림창->성공/실패 여부->alert
		if(loginM!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginM);
			out.println("<script>alert('로그인 성공');</script>");
			out.println("<script>location.href='/';</script>");
		}else {
			out.println("<script>alert('아이디 또는 비밀번호를 확인하세요.');</script>");
			out.println("<script>location.href='/views/loginForm.html';</script>");
		}
		out.println("<script>location.href='/';</script>");
		//메인페이지로 이동->강제이동
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

