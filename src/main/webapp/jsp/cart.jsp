<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Internet Store - cart</title>
</head>
<body>
  <h1>Your cart</h1>
  <div>Total $ is: <c:out value="${totalPrice}" />p</div>
  <table class="cart">
    <thead>
    <tr>
      <th>Name</th>
      <th>Price</th>
    </tr>
    </thead>
    <tbody>
      <c:forEach items="${products}" var="product">
        <tr>
          <td><c:out value="${product.title}" /></td>
          <td><c:out value="${product.price}" /></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="/check_out">Check out</a>
</body>
</html>