<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/1/2024
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>

<form action="<c:url value='/admin/category/edit'/>" method="post">
  <label for="categoryname">Category name:</label><br>
  <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br><br>

  <label for="images">Link images:</label><br>
  <input type="text" id="images" name="images" value="${cate.images}"><br><br>

  <label >Status:</label><br>
  <input type="radio" id="status_active" name="status" value="1" ${cate.status==1?'checked':''}>
  <label for="status_active">Hoạt động</label><br>
  <input type="radio" id="status_inactive" name="status" value="0" ${cate.status!=1?'checked':''}>
  <label for="status_inactive">Không hoạt động</label><br><br>

  <input type="submit" value="Update">
</form>
