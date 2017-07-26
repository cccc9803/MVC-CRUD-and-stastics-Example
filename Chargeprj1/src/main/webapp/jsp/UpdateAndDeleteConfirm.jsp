

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import= "com.test.model.Charge" %>
<!DOCTYPE html>
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
        <!-- 使用 jQuery -->
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css" rel="stylesheet">

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>

        <script language="JavaScript">
            $(document).ready(
                    function () {
                        $("#dateChooser").datepicker({
                            dateFormat: 'yy-mm-dd'
                        });
                    }
            );

            function myFunctionA()
            {
                $('#Del').show();
                $('#Update').hide();
            }

            function myFunctionB()
            {
                $('#Del').hide();
                $('#Update').show();
            }


            function initialize()
            {
                $('#Del').hide();
                $('#Update').hide();

            }
        </script>
    </head>

</head>
<body onload="initialize();">
    <div class="container-fluid">
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="/Chargeprj1/index.html">首頁</a>
            <a href="/Chargeprj1/Insert.html">新增</a>
            <a href="/Chargeprj1//Query.html">查詢</a>
            <a href="/Chargeprj1/Statistic.html">統計</a>

        </div>
        <div class ="row"></div>
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
                    </tr>
                      <c:forEach  var="current"  items="${charges}" >
                            <tr>
                                <td><c:out value="${current.idCharge}" /></td>
                                <td><c:out value="${current.date}" /></td>
                                <td><c:out value="${current.subject}" /></td>
                                <td><c:out value="${current.cost}" /></td>
                                <td><c:out value="${current.reason}" /></td>
                                <td><c:out value="${current.note}" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="row"></div>
        <div class="col-xs-12">

            <form>
                <p>請選擇刪除或修改<br/>
                    <input type="radio" name="itemSelect" value="showDate" onclick="myFunctionA();"/>刪除<br/>
                    <input type="radio" name="itemSelect" value="showSubject" onclick="myFunctionB();"/>修改<br/>
                </p>
            </form>


            <form id ="Del" method="POST" action="Delete_ID">
                <h2>刪除<br/></h2>

                <p>請再次輸入ID:<br/>
                    <input type="text" name="idCharge">
                    <input type="submit" value="確定刪除">
                </p>
            </form>





            <form id="Update" method="POST" action="Update_ID"/>
            <h2>修改<br/></h2>
            <p>請輸入要修改的ID<br/>
                <input type="text" name="idCharge">
            </p>
            <p>支出日期<br/>
                <input type="text" name="Date" id="dateChooser">
            </p>    
            <p>支出項目<br/>
                <select name="subject">
                    <option value="飯錢">飯錢</option>
                    <option value="油錢">油錢</option>
                    <option value="買衣服">買衣服</option>
                    <option value="房租">房租</option>
                    <option value="教育費">教育費</option>
                    <option value="娛樂">娛樂</option>
                    <option value="剪髮">剪髮</option>
                    <option value="其它">其它</option>
                </select>
            </p>
            <p>金額<br/>
                <input type="text" name="Cost">
            </p>
            <p>支出原因<br/>
            <input type="text" name="Reason" value="">
                </p>
                <input type="submit" value="確認修改">
                </form>
                </div>
                </div>
                </div>
                </body>
                </html>
