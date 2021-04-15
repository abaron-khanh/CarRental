<%-- 
    Document   : home
    Created on : Mar 4, 2021, 7:44:20 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
                return true;
            }
            ;
        </script>
        <style>
            body{
                background-color: #c1dad6;
                background-size: cover;
                background-repeat: no-repeat;
            }

            body h1{
                text-align: center;
                font-family: Georgia, 'Times New Roman', Times, serif;
                font-size: 350%;
                opacity: 0.5;
                border-radius: 2px;
                width: 1550px;
                margin: 10px auto 10px auto;
            }

            #car
            {
                width: 1700px;
                margin: 10px auto;
                border: 4px solid #c1dad6;
                border-radius: 5px;
                background-color: whitesmoke;
                display: grid;
                grid-template-columns: 600px 1000px;
                grid-gap: 10px;
            }
            #car_detail
            {

            }

            #car img
            {
                width: 550px;
                height: 250px;
            }

            #page_number{
                text-align: center;
                margin-top: 25px;
                margin-bottom: 50px;
                text-decoration: none;
            }

            #page_index{
                border: solid #79a58f;
                border-radius: 10px;
                font-size: 150%;
                padding: 5px;
                background-color: #e8d0a9;
                margin: 1px;
                font-family: Georgia, 'Times New Roman', Times, serif;
                text-decoration: none;
            }

            .form-group
            {
                width: 300px;
                margin: 0px auto 15px;
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

            #header
            {
                width: 1690px;
                height: 300px;
                margin: 10px auto;
                border-radius: 5px;
                display: grid;
                grid-template-columns: 1300px 380px;
                grid-gap: 10px;
            }

            #title_box
            {
                width: 1280px;
                border: 4px solid #6d929b;
                border-radius: 5px;
            }

            #title_box img
            {
                width: 1272px;
                height: 292px;
            }

            #search_date_box
            {
                background-color: #6d929b ;
                width: 380px;
                border: 4px solid #6d929b;
                border-radius: 5px;
            }

            #category_box
            {
                height: 89px;
                width: 1690px;
                margin: 25px auto;
                border: 4px solid #6d929b;
                border-radius: 5px;
                background-color: #6d929b;
            }

            #category
            {
                margin: 5px 36px;
                width: 1690px;
                height: 62px;
                display: grid;
                grid-template-columns: 170px 170px 170px 170px 170px 170px 170px 170px 170px;
                grid-gap: 10px;
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
                margin-left: 1200px;
                text-decoration: none;
            }

            #login_button a
            {
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

            #history_button a
            {
                text-decoration: none;
            }

            #search_date_box h3
            {
                text-align: center;
                margin-bottom: 25px;
                font-weight: bold;
            }

            #search_date_box p
            {
                font-size: 120%;
                margin-left: 20px;
                font-weight: bold;
            }

            #search_date_button
            {
                padding: 7.5px 15px;
                float: right;
                margin-top: 5px;
                margin-right: 15px;
                border-radius: 5px;
                background-color: #c1dad6;
            }


            #category_box input
            {
                border: 4px solid #c1dad6;
                font-weight: bold;
            }

            #car
            {
                border: 4px solid #6d929b;
            }

            #add_cart
            {
                padding: 7.5px 85px;
                float: right;
                margin-top: 5px;
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
            
            #search_name
            {
                margin-left: 10px;
                padding: 2px 2px;
                border-radius: 5px;
            }
            
            #combo
            {
                margin-left: 10px;
                padding: 4px 2px;
                border-radius: 5px;
                width: 120px;
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
            <!--            <form action="searchName" method="POST">
                            <li>
                                <input id="search_text" type="text" name="txtSearchName" placeholder="Type car's name to search">
                            </li>
                            <li>
                                <input id="search_button" type="submit" value="Search">
                            </li>
                        </form>-->
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
        <div id="header">
            <div id="title_box">
                <img src="https://cdn07.carsforsale.com/CustomTemplatePhotos/706360/images/ss2.6bf0b769.jpg">
            </div>
            <div id="search_date_box">
                <h3>SEARCH AVAILABLE CAR</h3>
                <form action="searchByDate" method="POST" onsubmit="return checkDate()">
                    <input id="search_name" type="text" name="txtSearchName" placeholder="Type car's name here"/>
                    OR:
                    <select id="combo" size="1" name="txtCategory">
                        <option>Sedan</option>
                        <option>Hatchback</option>
                        <option>SUV</option>
                        <option>Crossover</option>
                        <option>MPV</option>
                        <option>Coupe</option>
                        <option>Pick-up</option>
                        <option>Convertible</option>
                        <option>Super</option>
                        <option>Muscle</option>
                    </select>
                    <p>From:</p>
                    <div class="form-group">
                        <div class='input-group date' id='datepicker1'>
                            <input id="1" type='text' value="${sessionScope.currentDate}" class="form-control" readonly="" name="txtRentalDate"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                    <p>To:</p>
                    <div class="form-group">
                        <div class='input-group date' id='datepicker2'>
                            <input id="2" type='text' value="${sessionScope.currentDate}" class="form-control" readonly="" name="txtReturnDate"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                    <input id="search_date_button" type="submit" value="Search">
                </form>
            </div>
        </div>
        <!--        <div id="category_box">
                    <form action="searchByCategory" method="POST">
                        <div id="category">
                            <input type="submit" value="Sedan" name="btnCategory">
                            <input type="submit" value="Hatchback" name="btnCategory">
                            <input type="submit" value="SUV" name="btnCategory">
                            <input type="submit" value="Crossover" name="btnCategory">
                            <input type="submit" value="MPV" name="btnCategory">
                            <input type="submit" value="Coupe" name="btnCategory">
                            <input type="submit" value="Pick-up" name="btnCategory">
                            <input type="submit" value="Convertible" name="btnCategory">
                            <input type="submit" value="Super" name="btnCategory">
                            <input type="submit" value="Muscle" name="btnCategory">
                        </div>
                    </form>
                </div>-->
        <br/>
        <c:if test="${not empty requestScope.listCar}">
            <h1>CAR LIST</h1>
        </c:if>
        <c:if test="${empty requestScope.listCar and not empty requestScope.listSearchCar}">
        <c:choose>
            <c:when test="${requestScope.searchName eq ''}">
                <h1>CAR LIST FOR "${requestScope.searchCategory}"</h1>
                <h1>BETWEEN ${requestScope.searchRentalDate} AND ${requestScope.searchReturnDate}</h1>
            </c:when>
            <c:otherwise>
                <h1>CAR LIST FOR "${requestScope.searchName}"</h1>
                <h1>BETWEEN ${requestScope.searchRentalDate} AND ${requestScope.searchReturnDate}</h1>
            </c:otherwise>
        </c:choose>
            </c:if>
        <c:if test="${not empty requestScope.listCar}">
            <c:forEach items="${requestScope.listCar}" var="dto">
                <div id="car">
                    <img src="${dto.carImage}">
                    <div id="car_detail">
                        <h4 id="name">Name: ${dto.carName}</h4>
                        <h3>License plate: ${dto.carID}</h3>
                        <h4>Year of Manufacture: ${dto.yearOfManufacture}</h4>
                        <h4>Category: ${dto.category}</h4>
                        <h4>Color: ${dto.carColor}</h4>
                        <%--<c:if test="${dto.availableQuantity > 0}">--%>
                            <!--<h4>Quantity: ${dto.availableQuantity}</h4>-->
                        <%--</c:if>--%>
                        <%--<c:if test="${dto.availableQuantity == 0}">--%>
                        <!--<h4 style="color: red">Quantity: Out of stock</h4>-->
                        <%--</c:if>--%>
                        <h4>Price (per day): ${dto.price} $</h4>
                        <%--<c:if test="${dto.availableQuantity > 0}">--%>
                        <form action="addToCart" method="POST">
                            <input id="add_cart" type="submit" value="Add to Cart"/>
                            <input type="hidden" name="cartCarID" value="${dto.carID}"/>
                            <input type="hidden" name="PageIndex" value="${currentPage}"/>
                        </form>
                        <%--</c:if>--%>
                    </div>
                </div>
            </c:forEach>
            <c:if test="${countHomePage>1}">
                <div id="page_number">     
                    <c:forEach begin="1" end="${countHomePage}" var="page">
                        <a id="page_index" href="loadAllCar?PageIndex=${page}">${page}</a>
                    </c:forEach>
                </div>
            </c:if>
        </c:if>
        <c:if test="${empty requestScope.listCar and not empty requestScope.listSearchCar}">
            <c:forEach items="${requestScope.listSearchCar}" var="dto">
                <div id="car">
                    <img src="${dto.carImage}">
                    <div id="car_detail">
                        <h4 id="name">Name: ${dto.carName}</h4>
                        <h3>License plate: ${dto.carID}</h3>
                        <h4>Year of Manufacture: ${dto.yearOfManufacture}</h4>
                        <h4>Category: ${dto.category}</h4>
                        <h4>Color: ${dto.carColor}</h4>
                        <%--<c:if test="${dto.availableQuantity > 0}">--%>
                            <!--<h4>Quantity: ${dto.availableQuantity}</h4>-->
                        <%--</c:if>--%>
                        <%--<c:if test="${dto.availableQuantity == 0}">--%>
                        <!--<h4 style="color: red">Quantity: Out of stock</h4>-->
                        <%--</c:if>--%>
                        <h4>Price (per day): ${dto.price} $</h4>
                        <%--<c:if test="${dto.availableQuantity > 0}">--%>
                        <form action="addToCart" method="POST">
                            <input id="add_cart" type="submit" value="Add to Cart"/>
                            <input type="hidden" name="cartCarID" value="${dto.carID}"/>
                            <input type="hidden" name="isSearch" value="isSearch"/>
                            <input type="hidden" name="SearchPageIndex" value="${currentSearchPage}"/>
                            <input type="hidden" name="txtRentalDate" value="${searchRentalDate}"/>
                            <input type="hidden" name="txtReturnDate" value="${searchReturnDate}"/>
                            <input type="hidden" name="txtSearchName" value="${searchName}"/>
                            <input type="hidden" name="txtCategory" value="${searchCategory}"/>
                        </form>
                        <%--</c:if>--%>
                    </div>
                </div>
            </c:forEach>
            <%--   <c:if test="${not empty requestScope.searchName}">
                    <c:if test="${countSearchPage>1}">
                        <div id="page_number">     
                            <c:forEach begin="1" end="${countSearchPage}" var="page">
                                <a id="page_index" href="searchName?SearchPageIndex=${page}&txtSearchName=${searchName}">${page}</a>
                            </c:forEach>
                        </div>
                    </c:if>
                </c:if>
                <c:if test="${not empty requestScope.searchCategory}">
                    <c:if test="${countSearchPage>1}">
                        <div id="page_number">     
                            <c:forEach begin="1" end="${countSearchPage}" var="page">
                                <a id="page_index" href="searchByCategory?SearchPageIndex=${page}&btnCategory=${searchCategory}">${page}</a>
                            </c:forEach>
                        </div>
                    </c:if>
                </c:if> --%>
            <c:if test="${not empty requestScope.searchRentalDate and not empty requestScope.searchReturnDate}">
                <c:if test="${countSearchPage>1}">
                    <div id="page_number">     
                        <c:forEach begin="1" end="${countSearchPage}" var="page">
                            <a id="page_index" href="searchByDate?SearchPageIndex=${page}&txtRentalDate=${searchRentalDate}&txtReturnDate=${searchReturnDate}&txtSearchName=${searchName}&txtCategory=${searchCategory}">${page}</a>
                        </c:forEach>
                    </div>
                </c:if>
            </c:if>
        </c:if>
    </body>
</html>
