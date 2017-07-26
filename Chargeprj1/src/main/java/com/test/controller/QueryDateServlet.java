package com.test.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.ChargeDao;
import com.test.model.Charge;

@WebServlet(urlPatterns = {"/Query_Date"})
public class QueryDateServlet extends HttpServlet {
    private ChargeDao dao; 
    public QueryDateServlet() {
    	super();
    	dao = new ChargeDao();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	 response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
         String dateStart = (request.getParameter("DateStart"));
         String dateEnd = (request.getParameter("DateEnd"));
         System.out.println(dateStart + "," +  dateEnd);
         List<Charge> ch = dao.getChargeByDate(dateStart, dateEnd);
         System.out.println(ch.size());
         request.setAttribute("charges",ch);
         try {
         RequestDispatcher view = getServletContext().getRequestDispatcher("/jsp/ViewQuery.jsp");
         view.forward(request, response);
         }catch(Exception e) {
        	 e.printStackTrace();
        	 RequestDispatcher rd = request.getRequestDispatcher("/jsp/Failed.jsp");
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
    }
}
