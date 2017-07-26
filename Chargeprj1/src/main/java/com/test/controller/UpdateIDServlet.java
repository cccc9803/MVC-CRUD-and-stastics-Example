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

@WebServlet(urlPatterns = {"/Update_ID"})
public class UpdateIDServlet extends HttpServlet {
	ChargeDao dao;
	public UpdateIDServlet() {
		dao = new ChargeDao();
	}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Charge charge = new Charge();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        charge.setIdCharge(Integer.parseInt(request.getParameter("idCharge")));
        charge.setDate(request.getParameter("Date"));
        charge.setSubject(request.getParameter("subject"));
        charge.setCost(request.getParameter("Cost"));
        charge.setReason(request.getParameter("Reason"));
        try {
        dao.updateChargeById(charge);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/Success.jsp");
        rd.forward(request, response);
        }catch(Exception ex){
        	ex.printStackTrace();
        	RequestDispatcher rd = request.getRequestDispatcher("jsp/Failed.jsp");
        	rd.forward(request, response);
        }
        
        
}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }
      @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
