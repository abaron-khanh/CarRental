<%-- 
    Document   : error
    Created on : Mar 16, 2021, 9:10:09 AM
    Author     : PC
--%>

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

            body h1{
                text-align: center;
                font-family: Georgia, 'Times New Roman', Times, serif;
                font-size: 250% ;
                opacity: 0.5;
                border-radius: 2px;
                width: 1550px;
                margin: 50px auto 10px auto;
            }

            body h2{
                text-align: center;
                font-family: Georgia, 'Times New Roman', Times, serif;
                font-size: 250% ;
                opacity: 0.5;
                border-radius: 2px;
                width: 1550px;
                margin: 50px auto 70px auto;
            }

            #in_page_link a{
                padding: 7.5px 15px;
                border-radius: 5px;
                background-color: #009999;
                color: #ffffff;
                margin-left: 850px;
                border:black dotted;
                text-decoration: none;
            }

            #in_page_link{
                margin-top: 10px;
            }
        </style>
        <h1 id="title">ERROR</h1>
        <h2>${error}</h2>
        <div id="in_page_link">
            <a href="login.html">Click to go back Login page!</a>
        </div>
    </body>
    </body>
</html>
