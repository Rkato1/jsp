package board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardFileDownloadServlet
 */
@WebServlet(name = "BoardFileDownload", urlPatterns = { "/boardFileDownload" })
public class BoardFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFileDownloadServlet() {
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
		String filename = request.getParameter("filename");
		String filepath = request.getParameter("filepath");
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/board/";
		//파일과 현재 서블릿 연결
		//메인스트림
		FileInputStream fis = new FileInputStream(saveDirectory+filepath);
		//서브스트림
		BufferedInputStream bis = new BufferedInputStream(fis);
		//읽어온 파일을 사용자에게 전달하기 위한 객체 생성
		ServletOutputStream sos  = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		//브라우저가 IE인지 판단여부
		String resFilename="";
		//어떤 브라우저 인지판별
		//그후 종류에 따른 파일명 변경 로직
		boolean bool = request.getHeader("user-agent").indexOf("MSIE") != -1 || request.getHeader("user-agent").indexOf("Trident") != -1;
		System.out.println("IE여부:"+bool);
		//IE인 경우
		if(bool) {
			resFilename = URLEncoder.encode(filename,"UTF-8");
			resFilename = resFilename.replaceAll("\\\\", "%20");
		}
		//그 외인 경우
		else {
			resFilename = new String(filename.getBytes("UTF-8"),"ISO-8859-1");
		}
		//파일 다운르도를 위한 HTTP Header설정
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+resFilename);
		//파일 전송		
		int read = -1;
		//data 존재시 read 값은 0이 됨, 다 읽었을 때는 -1
		while((read=bis.read())!=-1) {
			bos.write(read);
		}
		bos.close();
		bis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
