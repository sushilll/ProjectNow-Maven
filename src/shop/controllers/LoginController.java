package shop.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.LoginDao;


@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		if(!session.getAttribute("userid").equals("Guest")){
			resp.sendRedirect("productlist");
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsps/login.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session =  req.getSession(false);
		if(session.getAttribute("userid").equals("Guest")){
			String userid = (String)req.getParameter("userid");
			String pwd = (String)req.getParameter("pwd");
			req.setAttribute("useridError", userid);
			if (userid == null || pwd == null || userid.trim().equals("") || pwd.trim().equals("")) {
				req.setAttribute("inputError", "Invalid User id or Password");
				req.getRequestDispatcher("WEB-INF/jsps/login.jsp").forward(req, resp);
			}else{
				boolean result = new LoginDao().checkLogin(userid, pwd);
				if (result) {
					session.setAttribute("userid", userid);
					resp.sendRedirect("accountinfo");
				}
				else {
					req.setAttribute("inputError", "Invalid User id or Password");
					req.getRequestDispatcher("WEB-INF/jsps/login.jsp").forward(req, resp);
				}

			}
		}else{
			resp.sendRedirect("home");
		}
		
		/*		LoginDao loginDao = new LoginDao();
		Boolean result = loginDao.checkLogin(userid, pwd);*/
		/*boolean result = new LoginDao().checkLogin(userid, pwd);
		if (result) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userid", userid);

			req.getRequestDispatcher("WEB-INF/jsps/login-success.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("WEB-INF/jsps/error.jsp").forward(req, resp);
		}*/
	}
}
