package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.vo.Member;

/**
 * Servlet implementation class SelectAllMemberServlet
 */
@WebServlet(name = "SelectAllMember", urlPatterns = { "/selectAllMember" })
public class SelectAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ArrayList<Member> list = new MemberDao().selectAllMember();
		System.out.println(list.size());
		//결과 처리할 페이지 지정
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/selectAllMember.jsp");
		//결과 처리할 페이지에 필요한 데이터 등록
		request.setAttribute("list", list);
		//페이지 이동
		rd.forward(request, response);
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html><head><title> </title></head>");
//		out.println("<body>");
//		out.println("<h1>전체회원조회</h1><hr>");
//		if(list.size()==0) {			
//			out.println("<h3>회원이 존재하지 않습니다.</h3>");
//		}else {
//			out.println("<table border='1'>");
//			out.println("<tr>");
//			out.println("<th>회원번호</th><th>아이디</th><th>이름</th><th>전화번호</th><th>이메일</th><th>성별</th><th>가입일</th>");
//			out.println("</tr>");
//			for(int i=0; i<list.size(); i++) {
//				out.println("<tr>");
//				out.println("<td>"+list.get(i).getMemNo()+"</td>");
//				out.println("<td>"+list.get(i).getMemId()+"</td>");
//				out.println("<td>"+list.get(i).getMemName()+"</td>");
//				out.println("<td>"+list.get(i).getPhone()+"</td>");
//				out.println("<td>"+list.get(i).getEmail()+"</td>");
//				out.println("<td>"+list.get(i).getGender()+"</td>");
//				out.println("<td>"+list.get(i).getEnrollDate()+"</td>");
//				out.println("</tr>");
//			}
//			out.println("</table>");
//		}
//		
//		out.println("<a href='/'>메인페이지로 이동</a>");
//		out.println("</body></html>");
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
