<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/21/2024
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Reset Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .reset-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            width: 350px;
        }

        .reset-container h3 {
            margin-bottom: 20px;
            color: #333;
        }

        .alert {
            color: #e74c3c;
            font-size: 14px;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
            color: #333;
        }

        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
        }

        button {
            background-color: #28a745;
            color: #fff;
            padding: 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
        }

        button:hover {
            background-color: #218838;
        }

        .loginbtn {
            display: block;
            margin-top: 20px;
            text-align: center;
            color: #007bff;
            text-decoration: none;
        }

        .loginbtn:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
%>
<div class="reset-container">
    <h3>Đặt lại mật khẩu</h3>
    <form action="/LtwebServlet_war_exploded/reset-password" method="POST">
        <label for="password">Mật khẩu mới:</label>
        <input id="password" type="password" name="password" required>

        <label for="confirmPassword">Xác nhận mật khẩu:</label>
        <input id="confirmPassword" type="password" name="confirmPassword" required>

        <input type="hidden" name="username" value="<%= username %>">

        <button type="submit">Đặt lại mật khẩu</button>
    </form>
    <c:if test="${alert !=null}">
        <div class="alert">${alert}</div>
    </c:if>
    <a href="/LtwebServlet_war_exploded/login" class="loginbtn">Quay về Đăng nhập</a>
</div>
</body>
</html>