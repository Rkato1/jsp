package ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxTest1Servlet
 */
@WebServlet(name = "AjaxTest9", urlPatterns = { "/ajaxTest9" })
public class AjaxTest9Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest9Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<User> list = new ArrayList<User>();
		User user1 = new User("이름1",20,"주소1");
		User user2 = new User("이름2",21,"주소2");
		User user3 = new User("이름3",22,"주소3");
		User user4 = new User("이름4",23,"주소4");
		User user5 = new User("이름5",24,"주소5");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
		HashMap<String, User> map = new HashMap<String, User>();
		map.put(user1.getName(), user1);
		map.put(user2.getName(), user2);
		map.put(user3.getName(), user3);
		map.put(user4.getName(), user4);
		map.put(user5.getName(), user5);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(map,response.getWriter());		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
