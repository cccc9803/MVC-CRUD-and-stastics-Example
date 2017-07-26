package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Billy
 */
@WebServlet(urlPatterns = {"/Query_Statistic"})
public class StatisticServlet extends HttpServlet {

    ArrayList QRes = new ArrayList();
    ArrayList QRate = new ArrayList();
    ArrayList<Integer> resSum1 = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/charge", "root", "root");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SelectSubject</title>");
            out.println("</head>");
            out.println("<body>");
            String monthSelect = request.getParameter("months");
            String[] subject = new String[]{"and subject = '飯錢'", "and subject = '油錢'", "and subject = '買衣服'", " and subject = '房租'", "and subject = '教育費'",
                "and subject ='娛樂'", "and subject = '剪髮'", "and subject = '其它'", ""};
            int[] resSum = new int[]{};
            viewTable(conn, out, monthSelect, subject, resSum);

            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        request.setAttribute("QueryResult", QRes);
        request.setAttribute("RateResult", QRate);
        request.setAttribute("resSum", resSum1);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/ViewStatistic.jsp");
        rd.forward(request, response);
        QRes.clear();
        QRate.clear();
        resSum1.clear();
    }

    public void viewTable(Connection con, PrintWriter out, String monthSelect, String[] subject, int[] resSum) throws SQLException {
        Statement stmt = null;

        for (int i = 0; i < subject.length; i++) {
            String query
                    = "select sum(COST) As summary From chargedb where " + monthSelect + subject[i];

            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    int sum = rs.getInt("summary");
                    resSum1.add(sum);

                    HashMap sp = new HashMap();
                    sp.put("sum", sum);

                    QRes.add(sp);

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }

        }
        calRes(resSum, resSum1);

    }

    public void calRes(int[] resSum, ArrayList resSum1) {

        /*Convert ArrayList to int[]*/
        resSum = new int[resSum1.size()];
        for (int x = 0; x < resSum.length; x++) {
            resSum[x] = (int) resSum1.get(x);
        }

        for (int i = 0; i < resSum.length; i++) {

            float x = (resSum[i] / (float) resSum[resSum.length - 1]) * 100;

            HashMap sp2 = new HashMap();
            sp2.put("rate", x);
            QRate.add(sp2);

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
