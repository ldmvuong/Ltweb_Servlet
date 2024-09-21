<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/21/2024
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Forgot Password</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
        }

        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
        }

        input[type="text"]:focus, input[type="email"]:focus {
            border-color: #007bff;
        }

        button {
            background-color: #04AA6D;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin: 10px 0;
        }


        button:hover {
            background-color: #039c5b;
        }

        .loginbtn {
            background-color: #007bff;
        }

        .loginbtn:hover {
            background-color: #0069d9;
        }

        a {
            color: dodgerblue;
            text-decoration: none;
        }
        a.loginbtn {
            display: inline-block;
            background-color: #007bff;
            color: white;
            padding: 10px 15px;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            margin-top: 10px;
            width: 100%; /* Để link full width như button */
        }

        a.loginbtn:hover {
            background-color: #0069d9;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Quên Mật Khẩu</h2>

    <form action="/LtwebServlet_war_exploded/forgot-password" method="post" >
        <input type="text" name="username" placeholder="Nhập username" required>
        <input type="email" name="email" placeholder="Nhập email" required>
        <button type="submit">Tạo mật khẩu mới</button>
    </form>
    <c:if test="${alert !=null}">
        <h4 class="alert alertdanger">${alert}</h4>
    </c:if>
    <a href="/LtwebServlet_war_exploded/login" class="loginbtn">Quay về Đăng nhập</a>
</div>
</body>
</html>
