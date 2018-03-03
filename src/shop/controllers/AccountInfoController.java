package shop.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.UserDao;
import shop.dto.UserDto;

@WebServlet("/accountinfo")
public class AccountInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		String userid = (String)session.getAttribute("userid");
		if (userid.equals("Guest")) {
			resp.sendRedirect("home");
		}else{
			req.getRequestDispatcher("WEB-INF/jsps/accountinfo.jsp").forward(req, resp);
		}
	}
}