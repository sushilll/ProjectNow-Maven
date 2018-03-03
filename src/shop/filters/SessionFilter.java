//package shop.filters;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////@WebFilter("/")
//public class SessionFilter implements Filter{
//	int i = 1;
//	@Override
//	public void destroy() {
//	}
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		System.out.println("filter call "+i++);
//		HttpServletRequest request = (HttpServletRequest)req;
//		HttpSession session = request.getSession(false);
//		if (session == null || session.getAttribute("userid") == null){
//			if (session != null)
//				session.setAttribute("userid", "Guest");
//			((HttpServletResponse)res).sendRedirect("home");
//		}
//		else
//			chain.doFilter(req, res);
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//	}
//
//}
