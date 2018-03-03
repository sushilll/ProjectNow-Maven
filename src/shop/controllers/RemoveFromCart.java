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

@WebServlet("/removefromcart")
public class RemoveFromCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean flag = true;
		// check id param
		if (req.getParameter("id") == null) {
			flag = false;
			resp.sendRedirect("_404");
		}else{
			req.getRequestDispatcher("sessionServlet").include(req, resp);
			HttpSession session = req.getSession(false);
			Object att = session.getAttribute("cart");
//			 cart exists
			if (att != null){
				ArrayList<ProductDto> list = (ArrayList<ProductDto>)att;
				int index = list.indexOf(new ProductDto(Integer.parseInt(req.getParameter("id"))));
				// if id is valid 
				if (index > -1) {
					ProductDto dto = list.get(index);
					dto.setQuantity(dto.getQuantity()-1);
					if(dto.getQuantity() < 1)
						list.remove(index);
					session.setAttribute("cartValue", ((int)session.getAttribute("cartValue"))-dto.getPrice());
					flag = false;
					resp.sendRedirect("cart");
				}
			}
		}
		if (flag) 
			resp.sendRedirect("_404");
	}
}
