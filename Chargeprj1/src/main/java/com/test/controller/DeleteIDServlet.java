package com.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.ChargeDao;
import com.test.model.Charge;

@WebServlet(urlPatterns = { "/Delete_ID" })
public class DeleteIDServlet extends HttpServlet {
	private ChargeDao dao;
	public DeleteIDServlet() {
		super();
		dao = new ChargeDao();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int idCharge = Integer.parseInt(request.getParameter("idCharge"));
        try {
        dao.deletCharge(idCharge);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/Success.jsp");
        rd.forward(request, response);
        }catch(Exception e) {
        	e.printStackTrace();
        	RequestDispatcher rd = request.getRequestDispatcher("jsp/Failed.jsp");
            rd.forward(request, response);
        }
        
      }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
