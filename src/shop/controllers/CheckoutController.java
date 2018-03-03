package shop.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.OrderDao;
import shop.dto.ProductDto;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);

		if (session.getAttribute("cart") != null && ((ArrayList<ProductDto>)session.getAttribute("cart")).size() > 0) {
			req.getRequestDispatcher("WEB-INF/jsps/checkout.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("productlist");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		boolean noError = true;

		// get form's values
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");

		// validate values
		if (name == null || name.trim().equals("")){ 
			req.setAttribute("nameError", "nameError");noError=false;}
		else session.setAttribute("name", name);
		if (email == null || !email.toUpperCase().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
			req.setAttribute("emailError", "emailError");noError=false;}
		else session.setAttribute("email", email);
		try{Long.parseLong(mobile);}catch(NumberFormatException e){
			req.setAttribute("mobileError", "mobileError");noError=false;}
		if (mobile == null || mobile.trim().equals("") || mobile.length() <10 || mobile.length() >10) {
			req.setAttribute("mobileError", "mobileError");noError=false;
		}else session.setAttribute("mobile", mobile);
		if (address == null || address.trim().equals("")) {
			req.setAttribute("addressError", "addressError");noError=false;
		}else session.setAttribute("address", address);

		// no error
		if (noError) {
			if (session.getAttribute("cart")!= null) {
				ArrayList<ProductDto> cart = (ArrayList<ProductDto>) session.getAttribute("cart");
				int cartValue = (int) session.getAttribute("cartValue");
				// add order
				int orderNo = OrderDao.makeOrder(name, email, mobile, address, cart , cartValue);
				if(orderNo > 0){
					req.setAttribute("orderNo", orderNo);
					session.invalidate();
					req.getRequestDispatcher("WEB-INF/jsps/order-success.jsp").forward(req, resp);
				}
				else resp.sendRedirect("serverError.html");
			}
		}else{
			req.getRequestDispatcher("WEB-INF/jsps/checkout.jsp").forward(req, resp);
		}
	}
}
