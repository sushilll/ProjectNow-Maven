package shop.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dto.ProductDto;

@WebServlet("/cart")
public class CartController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		String userid = (String)session.getAttribute("userid");
		req.getRequestDispatcher("WEB-INF/jsps/cart.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		// check cart exists???
		if (session.getAttribute("cart") != null && ((ArrayList<ProductDto>)session.getAttribute("cart")).size() > 0) {
			// get params to change quan
			int hiddenId = Integer.parseInt(req.getParameter("hiddenId"));
			int quan = Integer.parseInt(req.getParameter("quan"));
			if (quan > 0) {
				ArrayList<ProductDto> list = (ArrayList<ProductDto>)session.getAttribute("cart");
				ProductDto dto = list.get(list.indexOf(new ProductDto(hiddenId)));
				int oldQ = dto.getQuantity();
				dto.setQuantity(quan);
				// change cartValue
				int diff = quan-oldQ;
				session.setAttribute("cartValue", (int)session.getAttribute("cartValue")+diff*dto.getPrice());
			}
			req.getRequestDispatcher("WEB-INF/jsps/cart.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("home");
		}
		
	}
}
