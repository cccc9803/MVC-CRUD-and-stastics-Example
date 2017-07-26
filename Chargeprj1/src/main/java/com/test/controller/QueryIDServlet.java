package com.test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.ChargeDao;
import com.test.model.Charge;

@WebServlet(urlPatterns = { "/Query_ID" })
public class QueryIDServlet extends HttpServlet {
	ChargeDao dao;

	public QueryIDServlet() {
		super();
		dao = new ChargeDao();
	}

	ArrayList QRes = new ArrayList();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Charge charge = new Charge();
		int idCharge = Integer.parseInt(request.getParameter("idCharge"));

		request.setAttribute("charges", dao.getChargeById(idCharge));
		RequestDispatcher rd = request.getRequestDispatcher("jsp/UpdateAndDeleteConfirm.jsp");
		rd.forward(request, response);

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
