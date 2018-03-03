package shop.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.ProductDao;
import shop.dto.UserDto;

@WebServlet("/addproduct")
public class AddProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		UserDto user = (UserDto) session.getAttribute("user");
		if(user != null && user.getUserRole().equals("Manager")){
			session.setAttribute("auth", true);
			int pid = ProductDao.getNewPid();
			if (pid > 0) {
				req.setAttribute("pid", pid);
			}else resp.sendRedirect("serverError.html");
		}
		else{
			session.setAttribute("auth", false);
		}
		req.getRequestDispatcher("WEB-INF/jsps/addproduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("sessionServlet").include(req, resp);
		HttpSession session = req.getSession(false);
		UserDto user = (UserDto) session.getAttribute("user");
//		chcek auth
		if(user != null && user.getUserRole().equals("Manager")){
			int pid = ProductDao.getNewPid();
			if (pid > 0) {
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
					if(ProductDao.addProduct(pname, pdetails, Integer.parseInt(pprice), imageLink))
						req.getRequestDispatcher("WEB-INF/jsps/productadded.jsp").forward(req, resp);
					else resp.sendRedirect("serverError.html");
				}else req.getRequestDispatcher("WEB-INF/jsps/addproduct.jsp").forward(req, resp);
			}
			else resp.sendRedirect("serverError.html");
		}
		else{
			session.setAttribute("auth", false);
			req.getRequestDispatcher("WEB-INF/jsps/addproduct.jsp").forward(req, resp);
		}
	}
}
