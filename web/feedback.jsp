<%-- 
    Document   : feedback
    Created on : Mar 12, 2021, 10:01:44 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback Page</title>
    </head>
    <body>
        <script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("a");
                var valid = true;
                if (a.value.length <= 0)
                {
                    alert("Content can not be empty!");
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

            #home{
                text-decoration: none;
                font-family: Georgia, 'Times New Roman', Times, serif;
                color: #6d929b;
                padding: 1px 15px;
                background-color: #e8d0a9;
                border-radius: 2px;
                border: 2px dotted #6d929b;
            }

            #combo_box{
                width: 250px;
                margin-bottom: 10px;
            }

            #combo_box select{
                border: solid;
                width: 400px;
                margin: auto;
                padding: 7.5px 15px;
                border: 1px solid #bcbcbc;
                font-size: 90%;
                background-color: #e8d0a9;
            }
            
            #pic
            {
                width: 380px;
                height: 200px;
                margin: 10px 10px;
            }
            
            #login_form p
            {
                margin-left: 30px;
                font-size: 20px;
            }
        </style>
        <div id="header">FEEDBACK</div>
        <div id="login_form">
            <form action="feedback" method="POST">
                Car's name:
                <p>${param.orderDetailName}</p>
                <img id="pic" src="${param.orderDetailPic}"/> <br/>
                Feedback's content:
                <div id="text_field">
                    <input id="a" type="text" name="txtFeedback" placeholder="Content"/> <br/>
                </div>
                Rating stars:
                <div id="combo_box">
                    <select name="txtStar" size="1">
                        <c:forEach begin="0" end="10" var="num">
                            <option>${num}</option>
                        </c:forEach>
                    </select> <br/>
                </div>
                <div id="button">
                    <input type="submit" value="Send feedback" onclick="return validate()"/> <br/>
                </div>
                <input type="hidden" value="${param.orderDetailID}" name="txtID"/>
            </form>
            <a id="home" href="loadHistory">Back to history page</a>
        </div>
    </body>
</html>
