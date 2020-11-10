package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.Member;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet(name = "MyPage", urlPatterns = { "/mypage" })
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		//null값(사용한적이 없기때문)
		HttpSession session = request.getSession(false);
		Member m = null;
		if(session!=null) {
			m = (Member)session.getAttribute("loginMember");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>회원가입 결과</title></head>");
		out.println("<body>");
		if(m!=null) {
			out.println("<fieldset>");
			out.println("<legend>회원정보</legend>");
			out.println("<form action='/updateMember' method='post'>");
			out.println("회원번호 : <input type='text' name='memNo' value='"+m.getMemNo()+"' readonly><br>");
			out.println("아이디 : <input type='text' name='memId' value='"+m.getMemId()+"' readonly><br>");
			out.println("비밀번호 : <input type='password' name='memPw' value='"+m.getMemPw()+"'><br>");
			out.println("이름 : <input type='text' name='memName' value='"+m.getMemName()+"' readonly><br>");
			out.println("전화번호 : <input type='text' name='phone' value='"+m.getPhone()+"'><br>");
			out.println("이메일 : <input type='text' name='email' value='"+m.getEmail()+"'><br>");
			out.println("성별 : <input type='text' name='gender' value='"+m.getGender()+"' readonly><br>");
			out.println("가입일 : <input type='text' name='enrollDate' value='"+m.getEnrollDate()+"' readonly><br>");
			out.println("<input type='submit' value='정보수정'><br>");
			out.println("</form>");
			out.println("<a href='/'>메인페이지로 이동</a>");
			out.println("</fieldset>");
		}else {
			out.println("<script>alert('로그인 후 이용가능');</script>");
			out.println("<script>location.href='/views/loginForm.html';</script>");
		}
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
