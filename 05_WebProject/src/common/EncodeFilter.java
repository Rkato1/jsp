package common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodeFilter
 */
@WebFilter("/EncodeFilter")
public class EncodeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("필터 소멸");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("서블릿 실행 전!");
		HttpServletRequest req = (HttpServletRequest)request;
		//uri로 이동하는 URL 따올 수 있음
		String uri = req.getRequestURI();
		System.out.println("요청 URI : "+uri);
		request.setCharacterEncoding("utf-8");
		System.out.println("인코딩 완료");
		// pass the request along the filter chain
		//핵심
		//서블릿 실행코드
		chain.doFilter(request, response);
		System.out.println("서블릿 실행 후!");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터 생성(초기화) 완료!");
	}

}
