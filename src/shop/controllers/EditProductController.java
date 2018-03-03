package shop.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.ProductDao;
import shop.dto.ProductDto;
import shop.dto.UserDto;

@WebServlet("/edit")
public class EditProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		UserDto user = (UserDto)session.getAttribute("user");
		//		check auth
		if (user != null && user.getUserRole().equals("Manager")) {
			req.setAttribute("auth", true);
			//			check id param
			String id = req.getParameter("id");
			if (id == null) resp.sendRedirect("productlist");else{try{Integer.parseInt(id);}catch(NumberFormatException e){resp.sendRedirect("productlist");}}
			ProductDto p = ProductDao.getProduct(Integer.parseInt(id));
			//			id param is valid
			if (p != null) {
				req.setAttribute("pid", p.getId());
				req.setAttribute("pname", p.getName());
				req.setAttribute("pdetails", p.getDetails());
				req.setAttribute("pprice", p.getPrice());
				req.setAttribute("imageLink", p.getImageLink());
				req.getRequestDispatcher("WEB-INF/jsps/editproduct.jsp").forward(req, resp);
			}else resp.sendRedirect("_404");
		}else{
			req.setAttribute("auth", false);
			req.getRequestDispatcher("WEB-INF/jsps/editproduct.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		UserDto user = (UserDto)session.getAttribute("user");
		// check auth
		if (user != null && user.getUserRole().equals("Manager")) {
			req.setAttribute("auth", true);
			// check id param
			String pid = req.getParameter("pid");
			if (pid == null) resp.sendRedirect("productlist");else{try{Integer.parseInt(pid);}catch(NumberFormatException e){resp.sendRedirect("productlist");}}
			ProductDto p = ProductDao.getProduct(Integer.parseInt(pid));
			// id param is valid
			if (p != null) {
				req.setAttribute("pid", pid);
				String pname = req.getParameter("pname");
				String pdetails = req.getParameter("pdetails");
				String pprice = req.getParameter("pprice");
				String imageLink = req.getParameter("imageLink");
				boolean noError = true;
				// validation
				if(pname == null || pname.trim().equals("")){req.setAttribute("pnameError", true);noError = false;}else req.setAttribute("pname", pname);
				if(pdetails == null || pdetails.trim().equals("")){req.setAttribute("pdetailsError", true);noError = false;}else req.setAttribute("pdetails", pdetails);
				try{Integer.parseInt(pprice);if(pprice == null || pprice.trim().equals("")){req.setAttribute("ppriceError", true);noError = false;}else req.setAttribute("pprice", pprice);}catch(NumberFormatException e){req.setAttribute("ppriceError", true);noError = false;}
				req.setAttribute("imageLink", imageLink);

				if (noError) {
					if(ProductDao.updateProduct(Integer.parseInt(pid), pname, pdetails, Integer.parseInt(pprice), imageLink)){
						req.setAttribute("editSuccess",true);
						req.getRequestDispatcher("WEB-INF/jsps/editproduct.jsp").forward(req, resp);
					}
					else resp.sendRedirect("serverError.html");
				}
				else req.getRequestDispatcher("WEB-INF/jsps/editproduct.jsp").forward(req, resp);
			
			}else resp.sendRedirect("_404");
		}else{
			req.setAttribute("auth", false);
			req.getRequestDispatcher("WEB-INF/jsps/editproduct.jsp");
		}
	}
}
