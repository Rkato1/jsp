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
 * Servlet implementation class ExitMemberServlet
 */
@WebServlet(name = "ExitMember", urlPatterns = { "/exitMember" })
public class ExitMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitMemberServlet() {
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
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title> </title></head>");
		out.println("<body>");
		out.println("<script>");
		if(session!=null) {
			Member m = (Member) session.getAttribute("loginMember");
			int result = new MemberDao().deleteMember(m);
			
			//세션파기코드
			session.invalidate();
			
			out.println("alert('탈퇴되었습니다.');");
			out.println("location.href='/';");
		}else {
			out.println("alert('로그인되지 않았습니다');");
			out.println("location.href='/';");
		}
		out.println("</script>");		
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
