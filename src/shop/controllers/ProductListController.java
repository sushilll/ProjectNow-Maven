package shop.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.ProductDao;
import shop.pagination.Pagination;

@WebServlet("/productlist")
public class ProductListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);

		int page = 1;
		boolean pageInRange = true;
		if (req.getParameter("page") != null){
			page = Integer.parseInt(req.getParameter("page"));
		}
		Pagination pagination = null;
		try{
			pagination = ProductDao.getPage(page);
		}catch (Exception e) {
			pageInRange = false;
			req.getRequestDispatcher("WEB-INF/jsps/_404.jsp").forward(req, resp);
		}
		if (pageInRange) {
			req.setAttribute("pagination", pagination);
			req.getRequestDispatcher("WEB-INF/jsps/productlist.jsp").forward(req, resp);
		}
	}
}
