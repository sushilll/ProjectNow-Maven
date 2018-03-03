package shop.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.OrderDao;
import shop.dto.UserDto;

@WebServlet("/orders")
public class OrdersController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		UserDto user = (UserDto) session.getAttribute("user");
		if (user != null && ( user.getUserRole().equals("Employee") || user.getUserRole().equals("Manager"))) {
			req.setAttribute("auth", true);
			req.setAttribute("orderCount", OrderDao.getTotalCount());
			req.setAttribute("orders", OrderDao.getAllOrders());
		}else{
			req.setAttribute("auth", false);
		}
		req.getRequestDispatcher("WEB-INF/jsps/orders.jsp").forward(req, resp);
	}
}
