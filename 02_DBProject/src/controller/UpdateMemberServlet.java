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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet(name = "UpdateMember", urlPatterns = { "/updateMember" })
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
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
		String pw = request.getParameter("memPw");
		String ph = request.getParameter("phone");
		String email = request.getParameter("email");
		int no = Integer.parseInt(request.getParameter("memNo"));
		String id = request.getParameter("memId");
		Member m = new Member();
		m.setMemNo(no);
		m.setMemId(id);
		m.setMemPw(pw);
		m.setEmail(email);
		m.setPhone(ph);
		
		int result = new MemberDao().updateMember(m);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title></title></head>");
		out.println("<body>");
		if(result>0) {
			out.println("<script>alert('정보 변경 성공');</script>");
			HttpSession session = request.getSession(false);
			Member loginMember = new MemberDao().selectOneMember(m);
			session.setAttribute("loginMember", loginMember);
		}else {
			out.println("<script>alert('정보 변경 실패');</script>");
		}
		out.println("<script>location.href='/';</script>");		
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
