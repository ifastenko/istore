<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Internet Store - product</title>
</head>
<body>
  <div id="product-container" style="float:left;">
      <h1>Product: "<c:out value="${product.title}"/>"</h1>
      <div>Category: <c:out value="${product.category.name}"/></div>
      <div>Price: <c:out value="${product.price}"/></div>
      <div>Amount: <c:out value="${product.amount}"/></div>
      <a href="/?product2cart=<c:out value="${product.aid}" />">Add to cart</a>
  </div>
  <a href="/cart">Go to cart</a>
</body>
</html>