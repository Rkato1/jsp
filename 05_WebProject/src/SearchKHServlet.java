

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

/**
 * Servlet implementation class SearchKHServlet
 */
@WebServlet(name = "SearchKH", urlPatterns = { "/searchKH" })
public class SearchKHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchKHServlet() {
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
		String text = request.getParameter("text");
		Kh kh = new Dao.selectOneKh(text);
		
		JSONObject result = new JSONObject();
		result.put("no", kh.getKhNo());
		result.put("khName", URLEncoder.encode(kh.getKhName(),"UTF-8"));
		result.put("fax", URLEncoder.encode(kh.getFax(),"UTF-8"));
		result.put("addr", URLEncoder.encode(kh.getAddr(),"UTF-8"));
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
