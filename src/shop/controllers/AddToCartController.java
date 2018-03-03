package shop.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.ProductDao;
import shop.dto.ProductDto;

@WebServlet("/addtocart")
public class AddToCartController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id param check
		if(req.getParameter("id")==null ){
			resp.sendRedirect("_404");
		}else{
			// product exists???
			ProductDto dto = ProductDao.getProduct(Integer.parseInt(req.getParameter("id")));
			// YES
			if(dto != null){
				dto.setQuantity(1);
				req.getRequestDispatcher("sessionServlet").include(req, resp);
				HttpSession session = req.getSession(false);
//				 cart exists ???
				Object att = session.getAttribute("cart");
//				 NO, create new
				if(att == null){
					ArrayList<ProductDto> cart = new ArrayList<>();
					cart.add(dto);
					session.setAttribute("cart", cart);
					session.setAttribute("cartValue", dto.getPrice());
				}
//				YES, add to existing
				else{
					ArrayList<ProductDto> cart = (ArrayList<ProductDto>)att;
					int index = cart.indexOf(dto);
					// product already in cart
					if (index > -1) {
						dto = cart.get(index);
						dto.setQuantity(dto.getQuantity()+1);
					} else{
						cart.add(dto);
					}
					session.setAttribute("cartValue", ((int)session.getAttribute("cartValue"))+dto.getPrice());
				}
				resp.sendRedirect("cart");
			}
			// NO
			else{
				resp.sendRedirect("_404");
			}
		}
	}
}
