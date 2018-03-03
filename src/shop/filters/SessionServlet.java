package shop.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.UserDao;
import shop.dto.UserDto;

@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		session = session == null ? req.getSession(true): session;
		if (session.getAttribute("userid") == null || session.getAttribute("userid").equals("Guest")) {
			session.setAttribute("userid", "Guest");
		}else{
			String userid = (String)session.getAttribute("userid");
				UserDto dto = UserDao.getUser(userid);
				if (dto != null) {
					session.setAttribute("user", dto);
			}
		}
		resp.sendRedirect("home");
	}
}
