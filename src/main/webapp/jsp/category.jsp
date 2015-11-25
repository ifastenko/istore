<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Internet Store - category</title>
  <style type="text/css">
    table {
      border: 1px solid #000;
      border-collapse: collapse;
    }
    table td {
      border: 1px solid #000;
    }
    table.products {
      float: left;
    }
  </style>
</head>
<body>
  <table class="products">
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
        <td><c:out value="${product.aid}" /></td>
        <td>
            <c:out value="${product.category.name}"/>
        </td>
        <td>
          <a href="product?id=<c:out value="${product.aid}"/>">
            <c:out value="${product.title}"/>
          </a>
        </td>
        <td><c:out value="${product.amount}" /></td>
        <td><c:out value="${product.price}" /></td>
        <td>
          <a href="/?product2cart=<c:out value="${product.aid}" />">Add to cart</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <a href="/cart">Go to cart</a>
</body>
</html>