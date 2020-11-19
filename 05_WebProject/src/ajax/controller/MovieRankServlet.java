package ajax.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class MovieRankServlet
 */
@WebServlet(name = "MovieRank", urlPatterns = { "/movieRank" })
public class MovieRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieRankServlet() {
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
		String date = request.getParameter("date");
		//api접근하기 위한 키값
		String key ="b4794ce1363fe5104c0910bb9e0081d8";
		String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?";
		String result = Jsoup.connect(url).data("key",key).data("targetDt",date).userAgent("Mozilla").ignoreContentType(true).execute().body();
		System.out.println(result);
		//String 형태의 데이터를 JSON형태로 변환(실제 데이터의 생김새가 JSON이기 때문)
		//JSON또는 JSONArray형태로 변형해주는 객체 생성
		//파싱해오는 과정
		JsonParser parser = new JsonParser();
		JsonObject movieRank = (JsonObject)parser.parse(result);
		JsonObject boxOffice = (JsonObject)movieRank.get("boxOfficeResult");
		JsonArray movieList = (JsonArray) boxOffice. get("dailyBoxOfficeList");
		//최종결과
		JsonArray resultList = new JsonArray();
		for(int i=0;i<movieList.size();i++) {
			JsonObject movie = (JsonObject)movieList.get(i);
			JsonObject obj = new JsonObject();
			obj.add("rank", movie.get("rank"));
			obj.add("movieName", movie.get("movieNm"));
			obj.add("openDate", movie.get("openDt"));
			resultList.add(obj);
		}
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(resultList,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
