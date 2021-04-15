<%-- 
    Document   : history
    Created on : Mar 9, 2021, 2:59:26 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            function checkDate()
            {
                var x = document.getElementById("1").value;
                var y = document.getElementById("2").value;
                if (x.length == 0 || y.length == 0)
                {
                    alert("Date fields can not be empty!!!");
                    return false;
                }
                var year1 = x.substring(6, 10);
                var year2 = y.substring(6, 10);
                if (year1 > year2)
                {
                    alert("Year is not valid!!!");
                    return false;
                }
                var month1 = x.substring(0, 2);
                var month2 = y.substring(0, 2);
                if (month1 > month2)
                {
                    alert("Month is not valid!!!");
                    return false;
                }
                var day1 = x.substring(3, 5);
                var day2 = y.substring(3, 5);
                if (month1 >= month2 && day1 > day2)
                {
                    alert("Day is not valid!!!");
                    return false;
                }
                return true;
            }
            ;
        </script>
        <script>
            function confirmRemove()
            {
                var check = confirm("Do you want to delete this order from your history?");
                if (check == true)
                {
                    return true;
                } else
                {
                    return false;
                }
            }
            ;
        </script>
        <style>
            body{
                background-color: #c1dad6;
                background-size: cover;
                background-repeat: no-repeat;
            }

            img
            {
                width: 140px;
                height: 100px;
            }

            .form-group
            {
                width: 300px;
            }

            ul {
                list-style-type: none;
                overflow: hidden;
                background: #6d929b;
                padding: 5px;
                border-radius: 2px;
                width: 1690px;
                margin: auto;
            }

            li {
                float: left;
                margin-left: 5px;
                margin-right: 5px;
            }

            li a {
                display: block;
                padding: 8px;
                background-color: #d8e6df;
                margin: 2px;
                text-decoration: none;
                border-radius: 5px;
                font-family: Georgia, 'Times New Roman', Times, serif;
                color: black;  
            }

            #search_text
            {
                height: 40px;
                width: 250px;
                border-radius: 5px;
            }

            #search_button
            {
                height: 40px;
                width: 80px;
                border-radius: 5px;
                background-color: #c1dad6;
            }

            #login_username a
            {
                margin-left: 190px;
                text-decoration: none;
            }

            #cart_button a
            {
                text-decoration: none;
            }

            #home_button a
            {
                text-decoration: none;
            }

            #order_box
            {
                width: 1700px;
                background-color: #6d929b;
                margin: 20px auto;
                border: 4px solid #e8d0a9;
                border-radius: 5px; 
            }

            #title{
                text-align: center;
                margin-top: 100px;
                font-size: 80px;
                font-family: Georgia, 'Times New Roman', Times, serif;
                color: #6d929b;
                margin-bottom: 30px;
            }

            #order_box p
            {
                margin-left: 100px;
                color: #d8e6df;
                font-size: 25px;
            }

            #back
            {
                width: 1700px;
                margin: 50px auto;
            }

            #login{
                text-decoration: none;
                font-family: Georgia, 'Times New Roman', Times, serif;
                color: #6d929b;
                padding: 20px 50px;
                background-color: #d8e6df;
                border-radius: 2px;
                border: 2px solid #6d929b;
                text-align: center;
                margin-left: 735px;
            }

            #page_table{
                border-radius: 10px;
                margin: 50px auto 0px;
                heigth: auto;
                width: 1680px;
                border: solid;
                background-color:#d8e6df
            }

            #page_table th{
                font-family:Georgia, 'Times New Roman', Times, serif;
                font-size: 25px;
                padding: 5px;
                text-align:center;
            }

            #page_table td{
                font-family:Georgia, 'Times New Roman', Times, serif;
                font-size: 20px;
                padding: 5px;
                text-align:center;
            }

            #pic
            {
                width: 140px;
                height: 100px;
            }

            #add_cart
            {
                padding: 7.5px 85px;
                float: right;
                margin: 10px 50px;
                border-radius: 5px;
                background-color: #c1dad6;
            }

            #add_feedback
            {
                padding: 5px 5px;
                margin: 10px 50px;
                border-radius: 5px;
                background-color: #c1dad6;
            }

            #name
            {
                margin-top: 20px;
                font-size: 180%;
            }
            #logout_button input
            {
                height: 40px;
                width: 80px;
                border-radius: 5px;
                background-color: #c1dad6;
            }
        </style>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
        <script >
            $(function () {
                $('#datepicker').datepicker({
                    format: "mm/dd/yyyy",
                    autoclose: true,
                    todayHighlight: true,
                    showOtherMonths: true,
                    selectOtherMonths: true,
                    autoclose: true,
                    changeMonth: true,
                    changeYear: true,
                    orientation: "button"
                });
            });
            $(function () {
                $('#datepicker1').datepicker({
                    format: "mm/dd/yyyy",
                    autoclose: true,
                    todayHighlight: true,
                    showOtherMonths: true,
                    selectOtherMonths: true,
                    autoclose: true,
                    changeMonth: true,
                    changeYear: true,
                    orientation: "button"
                });
            });
        </script>
        <ul>
            <li id="home_button"><a href="loadAllCar">Home</a></li>
            <form action="searchNameHistory" method="POST">
                <li>
                    <input id="search_text" type="text" name="txtSearchNameHistory" placeholder="Type car's name to search">
                </li>
                <li>
                    <input id="search_button" type="submit" value="Search">
                </li>
            </form>
            <form action="searchDateHistory" method="POST" onsubmit="return checkDate()">
                <li>
                    <div class="form-group">
                        <div class='input-group date' id='datepicker'>
                            <input id="1" type='text' class="form-control" readonly="" name="txtOrderDateFrom" placeholder="Find order by order date here"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </li>
                <li>
                    <p style="margin-top: 5px;">To</p>
                </li>
                <li>
                    <div class="form-group">
                        <div class='input-group date' id='datepicker1'>
                            <input id="2" type='text' class="form-control" readonly="" name="txtOrderDateTo" placeholder="Find order by order date here"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </li>
                <li>
                    <input id="search_button" type="submit" value="Search">  
                </li>
            </form>
            <c:if test="${empty sessionScope.username}">
                <li id="login_button"><a href="login.html">Login</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.username}">
                <li id="login_username"><a href="#">Welcome,${sessionScope.username}</a></li>
                <li id="cart_button"><a href="view_cart.jsp">View Cart
                        <c:if test="${not empty sessionScope.shoppingCart.cart.values()}">
                            (${sessionScope.shoppingCart.cart.values().size()})
                        </c:if>
                    </a></li>
                <li id="logout_button">
                    <form action="logOutUser" method="POST">
                        <input type="submit" value="Logout">
                    </form>
                </li>
            </c:if>
        </ul>
        <div id="title">HISTORY</div>
        <c:if test="${not empty requestScope.listOrder}">
            <c:forEach items="${requestScope.listOrder}" var="DTO">
                <div id="order_box">
                    <div>
                        <p id="name">Name: ${DTO.customerName}</p>
                        <p>Phone: ${DTO.phone}</p>
                        <p>Address: ${DTO.address}</p>
                        <p>Create date: ${DTO.createDate}</p>
                        <p>Rental date: ${DTO.orderDate}</p>
                        <p>Return date: ${DTO.returnDate}</p>
                        <p>Total: ${DTO.total} $</p>

                        <form action="deleteOrder" method="POST">
                            <c:if test="${DTO.status eq 'Returned'}">
                                <input id="add_cart" type="submit" value="Delete" onclick="return confirmRemove()"/>
                            </c:if>
                            <input type="hidden" value="${DTO.orderID}" name="orderID"/>
                        </form>

                    </div>
                    <div>   
                        <table id="page_table" border="1">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Image</th>
                                    <th>Category</th>
                                    <th>Year of manufacture</th>
                                    <th>Color</th>
                                    <th>Price</th>
                                    <th>Feedback</th>
                                    <th>Star</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${DTO.detail}" var="dto">
                                    <tr>
                                        <td>${dto.carName}</td>
                                        <td>
                                            <img id="pic" src="${dto.carImage}">
                                        </td>
                                        <td>${dto.category}</td>
                                        <td>${dto.yearOfManufacture}</td>
                                        <td>${dto.carColor}</td>
                                        <td>${dto.price}</td>
                                        <td>
                                            <form action="feedback.jsp" method="POST">
                                                <c:if test="${DTO.status eq 'Returned'}">
                                                    <input id="add_feedback" type="submit" value="Feedback"/>
                                                </c:if>
                                                <input type="hidden" value="${dto.carID}" name="orderDetailID"/>
                                                <input type="hidden" value="${dto.carImage}" name="orderDetailPic"/>
                                                <input type="hidden" value="${dto.carName}" name="orderDetailName"/>
                                            </form>
                                            <br/>
                                            ${dto.feedback}
                                        </td>
                                        <td>
                                            <c:if test="${not empty dto.feedback or dto.rating > 0}">
                                                ${dto.rating}
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>    
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${empty requestScope.listOrder and not empty requestScope.listSearchOrder}">
            <c:forEach items="${requestScope.listSearchOrder}" var="DTO">
                <div id="order_box">
                    <div>
                        <p id="name">Name: ${DTO.customerName}</p>
                        <p>Phone: ${DTO.phone}</p>
                        <p>Address: ${DTO.address}</p>
                        <p>Create date: ${DTO.createDate}</p>
                        <p>Rental date: ${DTO.orderDate}</p>
                        <p>Return date: ${DTO.returnDate}</p>
                        <p>Total: ${DTO.total} $</p>

                        <form action="deleteOrder" method="POST">
                            <c:if test="${DTO.status eq 'Returned'}">
                                <input id="add_cart" type="submit" value="Delete" onclick="return confirmRemove()"/>
                            </c:if>
                            <input type="hidden" value="${DTO.orderID}" name="orderID"/>
                        </form>

                    </div>
                    <div>   
                        <table id="page_table" border="1">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Image</th>
                                    <th>Category</th>
                                    <th>Year of manufacture</th>
                                    <th>Color</th>
                                    <th>Price</th>
                                    <th>Feedback</th>
                                    <th>Star</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${DTO.detail}" var="dto">
                                    <tr>
                                        <td>${dto.carName}</td>
                                        <td>
                                            <img id="pic" src="${dto.carImage}">
                                        </td>
                                        <td>${dto.category}</td>
                                        <td>${dto.yearOfManufacture}</td>
                                        <td>${dto.carColor}</td>
                                        <td>${dto.price}</td>
                                        <td>
                                            <form action="feedback.jsp" method="POST">
                                                <c:if test="${DTO.status eq 'Returned'}">
                                                    <input id="add_feedback" type="submit" value="Feedback"/>
                                                </c:if>
                                                <input type="hidden" value="${dto.carID}" name="orderDetailID"/>
                                                <input type="hidden" value="${dto.carImage}" name="orderDetailPic"/>
                                                <input type="hidden" value="${dto.carName}" name="orderDetailName"/>
                                            </form>
                                            <br/>
                                            ${dto.feedback}
                                        </td>
                                        <td>
                                            <c:if test="${not empty dto.feedback or dto.rating > 0}">
                                                ${dto.rating}
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>    
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </body>
</html>
