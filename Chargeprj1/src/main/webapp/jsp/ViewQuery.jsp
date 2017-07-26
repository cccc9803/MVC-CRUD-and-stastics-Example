
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.test.model.Charge" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel=stylesheet type="text/css" href="menucss.css" />
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
        <div class="container-fluid">
            <div id="mySidenav" class="sidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <a href="/Chargeprj1/index.html">首頁</a>
                <a href="/Chargeprj1/Insert.html">新增</a>
                <a href="/Chargeprj1//Query.html">查詢</a>
                <a href="/Chargeprj1/Statistic.html">統計</a>

            </div>
            <div class="row"></div>
            <div class="col-xs-12">
                <div id="main">
                    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; 功能</span>

                    <table border="1">
                        <tr>
                            <TH>ID</th>
                            <TH>日期</th>
                            <TH>項目</th>
                            <TH>支出金額</th>
                            <TH>支出原因</th>
                            <TH>備註</th>
                            <TH>刪除/<br/>修改</th>
                        </tr>                        
                        <c:forEach  var="value"  items="${charges}" >
                            <tr>
                                <td><c:out value="${value.idCharge}" /></td>
                                <td><c:out value="${value.date}" /></td>
                                <td><c:out value="${value.subject}" /></td>
                                <td><c:out value="${value.cost}" /></td>
                                <td><c:out value="${value.reason}" /></td>
                                <td><c:out value="${value.note}" /></td>
                                
                            <form method = "POST" action="Charge_Delete">
                                <td><input type="button" value="刪除/修改" onclick="location.href = 'UploadAndDelete.html'"></td>
                            </form>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
