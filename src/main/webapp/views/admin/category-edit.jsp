<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/1/2024
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglib.jsp" %>

<form action="<c:url value='/admin/category/edit'/>" method="post">
    <input type="text" id="id" name="id" value="${cate.categoryid}" hidden="hidden">
    <label for="categoryname">Category name:</label><br>
    <input type="text" id="categoryname" name="name" value="${cate.categoryname}"><br><br>

    <c:if test="${cate.images.substring(0,5) != 'https'}">
        <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
    </c:if>
    <c:if test="${cate.images.substring(0,5) == 'https'}">
        <c:url value="${cate.images}" var="imgUrl"></c:url>
    </c:if>

    <label for="images">Link images:</label><br>
    <input type="text" id="images" name="images" value="${cate.images}"><br><br>
    <label for="imageUpload">Upload Image:</label><br>
    <img height="150" width="200" src="${imgUrl}"/>
    <input type="file" onchange="chooseFile(this)" id="imageUpload" name="imageUpload" value="${cate.images}"><br><br>

    <label>Status:</label><br>
    <input type="radio" id="status_active" name="status" value="1" ${cate.status==1?'checked':''}>
    <label for="status_active">Hoạt động</label><br>
    <input type="radio" id="status_inactive" name="status" value="0" ${cate.status!=1?'checked':''}>
    <label for="status_inactive">Không hoạt động</label><br><br>
    <input type="submit" value="Update">
</form>
