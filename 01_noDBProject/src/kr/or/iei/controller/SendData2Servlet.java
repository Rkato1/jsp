package kr.or.iei.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendData2Servlet
 */
@WebServlet(name = "SendData2", urlPatterns = { "/sendData2" })
public class SendData2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//HTML에서 보내준 데이터가 한글일 경우를 처리하기 위한 인코딩과정
		request.setCharacterEncoding("utf-8");
		//넘어온 값 변수에 저장
		String str1 = request.getParameter("str1");
		//String을 int로 형변환(서버 에러 방지를 위한 유효성 검사의 개념도 포함)
		int num = Integer.parseInt(request.getParameter("num"));
		//라디오 버튼은 value값이 넘어옴
		String gender = request.getParameter("gender");
		//체크박스는 여러개가 넘어올수 있어서 배열로 받음
		String[] hobby = request.getParameterValues("hobby");
		//select도 value값으로 넘어옴
		String age = request.getParameter("age");
		//form태그 밖의 값 받기
		String str2 = request.getParameter("str2");
		System.out.println("str1 : "+str1);
		System.out.println("num : "+num);
		System.out.println("gender : "+gender);
		System.out.println("hobby : ");
		for(int i=0; i<hobby.length
				;i++) {
			System.out.print(hobby[i]+"/");
		}
		System.out.println("age : "+age);
		System.out.println("str2 : "+str2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
