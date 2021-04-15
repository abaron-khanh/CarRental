<%-- 
    Document   : view_cart
    Created on : Mar 8, 2021, 8:50:11 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <script type="text/javascript">
            function checkDate()
            {
                var x = document.getElementById("1").value;
                var y = document.getElementById("2").value;
                if (x.length == 0 || y.length == 0)
                {
                    alert("Rental date and return date can not be empty!!!");
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
                var a = document.getElementById("name").value;
                var b = document.getElementById("phone").value;
                var c = document.getElementById("address").value;
                if (a.length == 0 || b.length == 0 || c.length == 0)
                {
                    alert("Please fill your order information!!!");
                    return false;
                }
                return true;
            }
            ;
        </script>
        <script>
            function confirmRemove()
            {
                var check = confirm("Do you want to remove this car?");
                if (check == true)
                {
                    return true;
                } else
                {
                    return false;
                }
            }
            ;

            function confirmBuy()
            {
                var check = confirm("Confirm to order?");
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
                width: 280px;
                height: 200px;
            }

            .form-group
            {
                width: 300px;
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

            #title{
                text-align: center;
                margin-top: 20px;
                font-size: 80px;
                font-family: Georgia, 'Times New Roman', Times, serif;
                color: #6d929b;
                margin-bottom: 30px;
            }
            
            #notify{
                text-align: center;
                margin-top: 20px;
                font-size: 50px;
                font-family: Georgia, 'Times New Roman', Times, serif;
                color: red;
                margin-bottom: 30px;
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

            #login_username a
            {
                margin-left: 1300px;
                text-decoration: none;
            }

            #home_button a
            {
                text-decoration: none;
            }

            #history_button a
            {
                text-decoration: none;
            }

            #button{
                text-align: center;
                padding: 10px 15px;
                border-radius: 5px;
                background-color: #009999;
                color: #ffffff;
                border: none;
                outline: none;
            }

            #pic
            {
                width: 550px;
                height: 250px;
            }

            #login_form{
                width: 100%;
                max-width: 400px;
                margin: 20px auto;
                background-color: #6d929b;
                padding: 15px;
                border: 2px dotted #cccccc;
                border-radius: 10px;
                opacity: 0.7;
            }

            #box_title{
                font-family: Georgia, 'Times New Roman', Times, serif;
                color: #c1dad6;
                opacity: 1;
            }

            #text_field{
                margin-bottom: 10px;
            }

            #text_field input{
                padding: 7.5px 15px;
                width: 92%;
                border: 1px solid #cccccc;
                outline: none;
                background-color: #e8d0a9;
            }

            p
            {
                font-size: 120%;
                margin-left: 20px;
                font-weight: bold;
            }

            #button{
                margin: 10px auto;
            }

            #button input{
                padding: 10px 135px;
                border-radius: 5px;
                background-color: #c1dad6;
                color: #6d929b;
                border: none;
                outline: none;
            }
            
            #button_update{
                margin: 10px auto;
            }

            #button_update input{
                padding: 10px 125px;
                border-radius: 5px;
                background-color: #c1dad6;
                color: #6d929b;
                border: none;
                outline: none;
            }

            body h2{
                margin: 50px auto;
                text-align: center;
                font-size: 400%;
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
            $(function () {
                $('#datepicker2').datepicker({
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
                <c:if test="${not empty sessionScope.username}">
                <li id="history_button"><a href="loadHistory">History</a></li>
                </c:if>
                <c:if test="${empty sessionScope.username}">
                <li id="login_button"><a href="login.html">Login</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.username}">
                <li id="login_username"><a href="#">Welcome,${sessionScope.username}</a></li>
                <li id="logout_button">
                    <form action="logOutUser" method="POST">
                        <input type="submit" value="Logout">
                    </form>
                </li>
                </c:if>
        </ul>
        <div id="title">YOUR CART</div>
        <div id="notify">${requestScope.notify}</div>
        <div>
            <c:if test="${not empty sessionScope.shoppingCart.cart}">
                <table id="page_table" border="1">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>License plate</th>
                            <th>Image</th>
                            <th>Category</th>
                            <th>Price</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.shoppingCart.cart.values()}" var="DTO" varStatus="counter">
                            <tr>
                                <td>${DTO.carName}</td>
                                <td style="font-size: 25px; font-family: cursive">${DTO.carID}</td>
                                <td>
                                    <img id="pic" src="${DTO.carImage}">
                                </td>
                                <td>${DTO.category}</td>
                                <td>${DTO.price}</td>
                        <td>
                            <form action="addCarToCart" method="POST">
                                <input id="button" type="submit" value="Add one more car">
                                <input type="hidden" value="${DTO.carName}" name="txtName"> 
                            </form>
                            <p style="color: red">${DTO.error}</p>
                        </td>
                        <td>
                            <form action="removeFromCart" method="POST">
                                <input id="button" type="submit" value="Remove" onclick="return confirmRemove()">
                                <input type="hidden" value="${DTO.carID}" name="txtID"> 
                            </form>
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <c:if test="${not empty sessionScope.shoppingCart.cart}">
            <div id="login_form">
                <h3 id="box_title">CUSTOMER'S INFORMATION</h3>
                <h3 id="box_title">Total: ${sessionScope.total}$</h3>
                <form action="checkOut" method="POST" onsubmit="return checkDate()">
                    Name: <br/>
                    <div id="text_field">
                        <input id="name" type="text" value="${sessionScope.fullname}" name="txtCustomerName" readonly="" > <br/>
                    </div>
                    Phone: <br/>
                    <div id="text_field">
                        <input id="phone" type="text" value="${sessionScope.cusPhone}" name="txtCustomerPhone"> <br/>
                    </div>
                    Address: <br/>
                    <div id="text_field">
                        <input id="address" type="text" value="${sessionScope.cusAddress}" name="txtAddress">
                    </div>
                    <p>From:</p>
                    <div class="form-group">
                        <div class='input-group date' id='datepicker1'>
                            <input id="1" type='text' class="form-control" readonly="" name="txtRentalDate" value="${sessionScope.rentalDate}"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                    <p>To:</p>
                    <div class="form-group">
                        <div class='input-group date' id='datepicker2'>
                            <input id="2" type='text' class="form-control" readonly="" name="txtReturnDate" value="${sessionScope.returnDate}"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                    <div id="button_update">
                        <input type="submit" value="Update Total Price" name="btnAction">
                    </div>
                    <div id="button">
                        <input type="submit" value="Check out" name="btnAction" onclick="return confirmBuy()">
                    </div>
                </form>
            </div>
        </c:if>
        <c:if test="${empty sessionScope.shoppingCart.cart}">
            <h2 id="empty">ADD YOUR FAVORITE CAR NOW!!!</h2>
        </c:if>
    </body>
</html>
