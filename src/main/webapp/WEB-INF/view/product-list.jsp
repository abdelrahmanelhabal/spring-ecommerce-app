<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product Inventory</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div class="container">
    <h2>📦 Product Inventory</h2>
    <div class="top-bar">
        Manage and track your product catalog efficiently
        <a href="<c:url value='/products/add'/>" class="btn">+ Add Product</a>
    </div>

    <table>
        <tr>
            <th>Photo</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Availability</th>
            <th>Actions</th>
        </tr>

        <c:choose>
            <c:when test="${not empty products}">
                <c:forEach var="p" items="${products}">
                    <tr>
                        <td>
                            <div class="img-box">
                                <img src="${pageContext.request.contextPath}/resources/images/${p.productDetails.photo}"
                                     alt="" width="60" height="60" />

                            </div>
                        </td>
                        <td>
                            <strong>${p.name}</strong><br>
                            <small>${p.productDetails.manufacturer}</small>
                        </td>
                        <td>$${p.productDetails.price}</td>
                        <td>
                            <span class="badge ${p.productDetails.available ? 'in' : 'out'}">
                                    ${p.productDetails.available ? 'In Stock' : 'Out of Stock'}
                            </span>
                        </td>
                        <td class="actions">
                            <a href="${pageContext.request.contextPath}/products/${p.id}">👁 View</a>
                            <a href="${pageContext.request.contextPath}/products/edit/${p.id}">✏ Edit</a>
                            <a href="${pageContext.request.contextPath}/products/delete/${p.id}" onclick="return confirm('Delete this product?')">🗑 Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5" style="text-align:center;">No products found</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>

    <div class="footer">
        Showing ${fn:length(products)} products
    </div>
</div>

</body>
</html>