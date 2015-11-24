<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Internet Store - catalog</title>
</head>
<body>
<div id='container'>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Category</th>
            <th>Title</th>
            <th>Count</th>
            <th>Price</th>
            <th>&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.category}" /></td>
                <td><c:out value="${product.title}" /></td>
                <td><c:out value="${product.count}" /></td>
                <td><c:out value="${product.price}" /></td>
                <td><button>Add to cart</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- place for cart -->
</div>
</body>
</html>