package com.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.ChargeDao;

@WebServlet(urlPatterns = { "/Query_Subject" })
public class QuerySubjectServlet extends HttpServlet {
	ChargeDao dao;

	public QuerySubjectServlet() {
		super();
		dao = new ChargeDao();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String subSelect = request.getParameter("subject");

		request.setAttribute("charges", dao.getChargeBySubject(subSelect));
		RequestDispatcher rd = request.getRequestDispatcher("jsp/ViewQuery.jsp");
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
