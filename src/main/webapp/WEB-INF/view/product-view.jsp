<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h3 class="mb-0">Product Details</h3>
        </div>
        <div class="card-body">
            <div class="text-center mb-4">
                    <img src="${pageContext.request.contextPath}/resources/images/${product.productDetails.photo}"
                         alt="No Image Available" class="img-fluid rounded" style="max-height: 200px;">
            </div>

            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <tbody>
                    <tr>
                        <th scope="row">ID</th>
                        <td>${product.id}</td>
                    </tr>
                    <tr>
                        <th scope="row">Name</th>
                        <td>${product.name}</td>
                    </tr>
                    <tr>
                        <th scope="row">Expiration Date</th>
                        <td>${product.productDetails.expiration_date}</td>
                    </tr>
                    <tr>
                        <th scope="row">Manufacturer</th>
                        <td>${product.productDetails.manufacturer}</td>
                    </tr>
                    <tr>
                        <th scope="row">Availability</th>
                        <td>
                            <c:choose>
                                <c:when test="${product.productDetails.available}">
                                    <span class="badge bg-success">Available</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge bg-danger">Out of Stock</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Price</th>
                        <td>$${product.productDetails.price}</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="mt-3">
                <a href="<c:url value='/products'/>" class="btn btn-outline-secondary">
                    &larr; Back to Product List
                </a>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>