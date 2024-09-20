<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <c:if test="${msg==false}">Đăng nhập thất bại</c:if>
    <c:if test="${msg==true}"><h1>Hello</h1>${uName}</c:if>

</head>
<body>

</body>
</html>