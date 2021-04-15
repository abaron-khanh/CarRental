<%-- 
    Document   : verify_code
    Created on : Mar 6, 2021, 3:31:11 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Code</title>
    </head>
    <body>
        <style>
            body{
                background-color: #c1dad6;
                background-size: cover;
                background-repeat: no-repeat;
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
                margin-top: 10px;
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
                text-align: center; 
            }
        </style>
        <div id="login_form">
            <h3 id="box_title">We already send a verification  code to your email.</h3>
            <form action="verifyCode" method="post">
                <div id="text_field">
                    <input type="text" name="authcode" placeholder="Type your verify code here">
                </div>
                <div id="button">
                    <input type="submit" value="Verify">
                </div>
            </form>
            <a id="login" href="login.html">Back to login page</a>
        </div>
    </body>
</html>
