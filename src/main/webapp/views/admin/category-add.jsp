<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/1/2024
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>

<form action="<c:url value='/admin/category/insert'/>" method="post" enctype="multipart/form-data">
    <label for="categoryname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname"><br><br>

    <label for="images">Link images:</label><br>
    <input type="text" id="images" name="images"><br><br>
    <label for="imageUpload">Upload Image:</label><br>
    <input type="file" onchange="chooseFile(this)" id="imageUpload" name="imageUpload"><br><br>

    <label >Status:</label><br>
    <input type="radio" id="status_active" name="status" value="1">
    <label for="status_active">Hoạt động</label><br>
    <input type="radio" id="status_inactive" name="status" value="0">
    <label for="status_inactive">Không hoạt động</label><br><br>

    <input type="submit" value="Submit">
</form>
