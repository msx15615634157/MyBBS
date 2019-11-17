package cn.bbs.backgroundfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class TestFilter implements Filter {

    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("进入01过滤器");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(session.getAttribute("account")==null) {
			session.setAttribute("userid", 1001);
		}
		chain.doFilter(request, response);
		System.out.println("01过滤器结束");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
