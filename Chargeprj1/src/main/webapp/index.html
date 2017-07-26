
<%@page import="org.jfree.chart.plot.PiePlot"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page  import="java.awt.*" %>
<%@ page  import="java.io.*" %>
<%@ page  import="org.jfree.chart.*" %>
<%@ page  import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page  import="org.jfree.chart.entity.*" %>
<%@ page  import ="org.jfree.data.general.*"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel=stylesheet type="text/css" href="menucss.css" />
        <link rel=stylesheet type="text/css" href="picstyle.css" />
        <meta charset="utf-8">
        <title>阿祥的記帳本</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


        <script>
            function openNav() {
                document.getElementById("mySidenav").style.width = "250px";
                document.getElementById("main").style.marginLeft = "250px";
            }

            function closeNav() {
                document.getElementById("mySidenav").style.width = "0";
                document.getElementById("main").style.marginLeft = "0";
            }
        </script>
    </head>
    <body>

    <body>
        <div class="container-fluid">
            <div class="row"></div>
            <div class="col-xs-12">
                <div id="mySidenav" class="sidenav">
                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <a href="/Chargeprj1/index.html">首頁</a>
                    <a href="/Chargeprj1/Insert.html">新增</a>
                    <a href="/Chargeprj1//Query.html">查詢</a>
                    <a href="/Chargeprj1/Statistic.html">統計</a>

                </div>

                <div id="main">
                    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; 功能</span>
                    <div class="row"></div>

                    <table border="1">
                        <tr>

                            <th>飯錢</th>
                            <th>油錢</th>
                            <th>買衣服</th>
                            <th>房租</th>
                            <th>教育費</th>
                            <th>娛樂</th>
                            <th>剪髮</th>
                            <th>其它</th>
                            <th>總計</th>

                        </tr>
                        <%//抓每月開銷的金額%>
                        <c:forEach  var="current"  items="${QueryResult}" >

                            <td>
                                <c:out value="${current.sum}" />
                            </td> 

                        </c:forEach>

                        <%//抓每月開銷的百分比%>
                        <tr>
                            <c:forEach var = "now" items="${RateResult}">

                                <td>
                                    <c:out value="${now.rate}" />

                                </td>

                            </c:forEach>
                        </tr>



                    </table>


                    <%    

                        ArrayList itemsArray = (ArrayList) request.getAttribute("resSum");
                        Font font = new Font("新細明體", Font.BOLD, 20);
                        final DefaultPieDataset data = new DefaultPieDataset();

                        data.setValue("飯錢", new Integer((int) itemsArray.get(0)));
                        data.setValue("油錢", new Integer((int) itemsArray.get(1)));
                        data.setValue("買衣服", new Integer((int) itemsArray.get(2)));
                        data.setValue("房租", new Integer((int) itemsArray.get(3)));
                        data.setValue("教育費", new Integer((int) itemsArray.get(4)));
                        data.setValue("娛樂", new Integer((int) itemsArray.get(5)));
                        data.setValue("剪頭髮", new Integer((int) itemsArray.get(6)));
                        data.setValue("其它", new Integer((int) itemsArray.get(7)));

                        JFreeChart chart = ChartFactory.createPieChart("圓餅圖 ", data, true, false, false);
                        chart.getTitle().setFont(font);
                        chart.getLegend().setItemFont(font);
                        PiePlot pieplot = (PiePlot) chart.getPlot();
                        pieplot.setLabelFont(font);

                        final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());

                        String fname = ServletUtilities.saveChartAsJPEG(chart, 600, 400, info, session);
                        PrintWriter pw = new PrintWriter(out);
                        ChartUtilities.writeImageMap(pw, fname, info, false);
                        pw.flush();
                        String chartURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fname;


                    %>






                    <div class="row"></div>

                    <img SRC="<%= chartURL%>" WIDTH="600" HEIGHT="400"
                         BORDER="0" USEMAP="#<%= fname%>" alt="">

                </div>
            </div>
                      <a href="/Chargeprj1/Statistic.html" class="btn btn-default" align="center">查詢其它月份</a>

    </body>
</html>
