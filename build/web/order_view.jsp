<%-- 
    Document   : order_view
    Created on : Mar 9, 2021, 1:45:01 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            body{
                background-color: #c1dad6;
                background-size: cover;
                background-repeat: no-repeat;
            }

            #order_box
            {
                width: 1700px;
                background-color: #6d929b;
                margin: auto;
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

            #order_box h2
            {
                margin-left: 100px;
                color: #d8e6df;
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
            }

            #page_table td{
                font-family:Georgia, 'Times New Roman', Times, serif;
                font-size: 20px;
                padding: 5px;
                text-align:center;
            }
            
            #pic
            {
                width: 550px;
                height: 250px;
            }
        </style>
        <div id="title">Thanks for using our service!</div>
        <div id="order_box">
            <h2 id="name">Name: ${sessionScope.cusName}</h2>
            <h2>Phone: ${sessionScope.cusPhone}</h2>
            <h2>Address: ${sessionScope.cusAddress}</h2>
            <h2>Rental date: ${sessionScope.rentalDate}</h2>
            <h2>Return date: ${sessionScope.returnDate}</h2>
            <h2>Total bill: ${sessionScope.total}$</h2>
            <table id="page_table" border="1">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>License plate</th>
                        <th>Image</th>
                        <th>Category</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sessionScope.orderDetail}" var="dto">
                        <tr>
                            <td>${dto.carName}</td>
                            <td>${dto.carID}</td>
                            <td>
                                <img id="pic" src="${dto.carImage}">
                            </td>
                            <td>${dto.category}</td>
                            <td>${dto.price} $</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>   

        </div>
            <div id="back">
            <a id="login" href="loadAllCar">Back to home page</a>
        </div>

    </body>
</html>
