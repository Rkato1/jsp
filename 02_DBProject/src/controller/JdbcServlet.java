package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.vo.Member;

/**
 * Servlet implementation class JdbcServlet
 */
@WebServlet(name = "Jdbc", urlPatterns = { "/Jdbc" })
public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.view에서 넘어온 데이터저장
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memName = request.getParameter("memName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		Member m = new Member(0, memId, memPw, memName, phone, email, gender, null);
		//3.비지니스로직
		int result = new MemberDao().insertMember(m);
		//4.결과처리
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>회원가입 결과</title></head>");
		out.println("<body>");
		//알림창->성공/실패 여부->alert
		if(result>0) {
			out.println("<script>alert('회원가입 성공');</script>");
		}else {
			out.println("<script>alert('회원가입 실패');</script>");
		}
		out.println("<script>location.href='/';</script>");
		//메인페이지로 이동->강제이동
		
		out.println("</body></html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
