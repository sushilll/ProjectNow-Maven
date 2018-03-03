package shop.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.OrderDao;
import shop.dto.OrderDto;
import shop.dto.ProductDto;
import shop.dto.UserDto;

@WebServlet("/order")
public class OrderController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		UserDto user = (UserDto) session.getAttribute("user");
		if (user != null && ( user.getUserRole().equals("Employee") || user.getUserRole().equals("Manager"))) {
			req.setAttribute("auth", true);
			// check id param
			String id = req.getParameter("id");
			if (id == null) resp.sendRedirect("orders");else{try{Integer.parseInt(id);}catch(NumberFormatException e){resp.sendRedirect("orders");}}
			OrderDto orderDto =OrderDao.getOrder(Integer.parseInt(id));
			ArrayList<ProductDto> productList = OrderDao.getOrder_productList(Integer.parseInt(id));
			if (orderDto != null && productList != null) {
				req.setAttribute("name", orderDto.getCust_name());req.setAttribute("mobile", orderDto.getCust_mobile());req.setAttribute("email", orderDto.getCust_email());req.setAttribute("address", orderDto.getCust_address());
				req.setAttribute("productList", productList);
				req.getRequestDispatcher("WEB-INF/jsps/order.jsp").forward(req, resp);
			}else resp.sendRedirect("_404");
		}else{
			req.setAttribute("auth", false);
			req.getRequestDispatcher("WEB-INF/jsps/order.jsp").forward(req, resp);
		}
	}

}
