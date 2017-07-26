package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.ChargeDao;
import com.test.model.Charge;


@WebServlet(urlPatterns = {"/Charge_Insert"})
public class InsertServlet extends HttpServlet {
    private ChargeDao dao; 
    public InsertServlet() {
    	super();
    	dao = new ChargeDao();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		Charge charge = new Charge();
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
                /* TODO output your page here. You may use following sample code. */

                charge.setDate(request.getParameter("Date"));;
                charge.setSubject(request.getParameter("subject"));
                charge.setCost(request.getParameter("Cost"));
                charge.setReason(request.getParameter("Reason"));                 
                try {
                dao.insertCharge(charge);
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/Success.jsp");
                rd.forward(request, response);
                }catch(Exception e) {
                	e.printStackTrace();
                	RequestDispatcher rd = request.getRequestDispatcher("/jsp/Failed.jsp");
                    rd.forward(request, response);
                }
                
        }
        
   /* @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
*/

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


  
}  
