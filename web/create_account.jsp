<%-- 
    Document   : LoadUserServlet
    Created on : Mar 9, 2021, 11:16:32 AM
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
        <script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("a");
                var b = document.getElementById("b");
                var c = document.getElementById("c");
                var d = document.getElementById("d");
                var e = document.getElementById("e");
                var valid = true;
                var name = 0;
                var email = 0;
            <c:forEach items="${requestScope.userList}" var="DTO">
                if (a.value == "${DTO.username}")
                {
                    name = 1;
                }
            </c:forEach>
            <c:forEach items="${requestScope.userList}" var="DTO">
                if (e.value == "${DTO.email}")
                {
                    email = 1;
                }
            </c:forEach>
                if (name > 0)
                {
                    alert("ID is exist!");
                    valid = false;
                } 
                else if (a.value.length <= 0)
                {
                    alert("Username can not be empty!");
                    valid = false;
                } 
                else if (b.value.length <= 0)
                {
                    alert("Fullname can not be empty!");
                    valid = false;
                } 
                else if (e.value.length <= 0)
                {
                    alert("Email can not be empty!");
                    valid = false;
                } 
                else if (email > 0)
                {
                    alert("This email is used!");
                    valid = false;
                } 
                else if (c.value.length <= 0)
                {
                    alert("Password can not be empty!");
                    valid = false;
                } 
                else if (d.value.length <= 0)
                {
                    alert("Confirm password can not be empty!");
                    valid = false;
                } 
                else if (d.value != c.value)
                {
                    alert("Confirm password not match!");
                    valid = false;
                }
                return valid;
            }
            ;
        </script>
        <style>
            body{
                background-color: #c1dad6;
                background-size: cover;
                background-repeat: no-repeat;
            }

            #header
            {
                margin: 80px auto 20px;
                text-align: center;
                font-family: Georgia, 'Times New Roman', Times, serif;
                font-size: 200%;
                color: black;
                padding: 10px;
                background-color: #6d929b;
                opacity: 70%;
                border-radius: 10px;
                width: 20%;
                text-shadow: 5px -5px 5px white;
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

            #button{
                text-align: right;
                margin-top: 10px;
            }

            #button input{
                padding: 7.5px 15px;
                border-radius: 5px;
                background-color: #c1dad6;
                color: #6d929b;
                border: none;
                outline: none;
            }

            #login{
                text-decoration: none;
                font-family: Georgia, 'Times New Roman', Times, serif;
                color: #6d929b;
                padding: 1px 15px;
                background-color: #e8d0a9;
                border-radius: 2px;
                border: 2px dotted #6d929b;
            }
        </style>
        <div id="header">CREATE ACCOUNT</div>
        <div id="login_form">
            <form action="createAccount" method="POST" onsubmit="return validate()">
                Username:
                <div id="text_field">
                    <input id="a" type="text" name="txtNewUsername" placeholder="Username"/> </br>
                </div>
                Fullname:
                <div id="text_field">
                    <input id="b" type="text" name="txtNewFullname" placeholder="Fullname"/> </br>
                </div>
                Email:
                <div id="text_field">
                    <input id="e" type="text" name="txtNewEmail" placeholder="Email"/> </br>
                </div>
                Password:
                <div id="text_field">
                    <input id="c" type="password" name="txtNewPassword" placeholder="Password"/> </br>
                </div>
                Confirm:
                <div id="text_field">
                    <input id="d" type="password" placeholder="Confirm password"/> </br>
                </div>
                <div id="button">
                    <input type="submit" value="Create" name="actionBtn"/>
                </div>
            </form>
            <a id="login" href="login.html">Back to login page</a>
        </div>
    </body>
</html>
