<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/1/2024
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<a href="<c:url value='/admin/category/add'/>">Add Category</a>


<table>
    <tr>
        <th>STT</th>
        <th>Image</th>
        <th>Category name</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listcate}" var="cate" varStatus="STT">
        <tr>
            <td>${STT.index+1 }</td>
            <c:url value="${cate.images}" var="imgUrl"></c:url>
            <td><img height="150" width="200" src="${imgUrl}"/></td>
            <td>${cate.categoryname }</td>
            <td>
                <c:if test="${cate.status ==1}">
                    Hoạt động
                </c:if>
                <c:if test="${cate.status ==0}">
                    Khong hoat dong
                </c:if>
            </td>

            <td><a href="<c:url value='/admin/category/edit?id=${cate.categoryid }'/>" class="center">Sửa</a>
                | <a href="<c:url value='/admin/category/delete?id=${cate.categoryid }'/>" class="center">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

