package photo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import photo.model.service.PhotoService;
import photo.model.vo.Photo;

/**
 * Servlet implementation class InsertPhotoServlet
 */
@WebServlet(name = "InsertPhoto", urlPatterns = { "/insertPhoto" })
public class InsertPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPhotoServlet() {
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
		if(!ServletFileUpload.isMultipartContent(request)){
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "enc 오류");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/photo";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize,"UTF-8", new DefaultFileRenamePolicy());
		Photo p = new Photo();
		p.setFilepath(mRequest.getFilesystemName("filename"));
		p.setPhotoContent(mRequest.getParameter("photoContent"));
		p.setPhotoWriter(mRequest.getParameter("photoWriter"));
//		System.out.println(p.getPhotoContent());
//		System.out.println(p.getPhotoWriter());
		int result = new PhotoService().insertPhoto(p);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "성공");
		}else {
			request.setAttribute("msg", "실패");
		}
		request.setAttribute("loc", "/photoList");
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
