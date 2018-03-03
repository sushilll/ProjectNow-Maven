package shop.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rdInclude = req.getRequestDispatcher("sessionServlet");
		rdInclude.include(req, resp);
		
		HttpSession session = req.getSession(false);
		if (!session.getAttribute("userid").equals("Guest")) {
			session.removeAttribute("userid");
			session.invalidate();
		}
		resp.sendRedirect("home");
	}
}
