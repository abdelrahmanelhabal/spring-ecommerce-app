<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Add New Product</title>
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-5 p-4 bg-white rounded shadow-sm">

  <a href="<c:url value='/products'/>"  class="text-decoration-none mb-3 d-inline-block">← Back to Inventory</a>

  <h2 class="mb-1">Add New Product</h2>
  <small class="text-muted mb-3 d-block">Enter the details for the new product</small>
  <form:form action="${pageContext.request.contextPath}/products" modelAttribute="product" >
    <form:hidden path="id"/>

    <label class="form-label" >Product Image</label>

    <div class="mb-3 text-center border border-dashed p-4 rounded bg-light">
      <label class="btn btn-outline-secondary">
        <form:input path="productDetails.photo" type="file" />
      </label>
      <p class="text-muted small mt-1">Max file size: 10MB</p>
    </div>


    <div class="mb-3">
      <label class="form-label">Product Name *</label>
      <form:input path="name" name="name" cssClass="form-control" placeholder="e.g. Premium Organic Coffee"/>
      <form:errors path="name" cssClass="text-danger"/>
    </div>

    <div class="row g-3 mb-3">
      <div class="col-md-6">
        <label class="form-label">Price *</label>
        <form:input path="productDetails.price" name="price" type="number" step="0.01" cssClass="form-control"/>
        <form:errors path="productDetails.price" cssClass="text-danger"/>
      </div>
      <div class="col-md-6">
        <label class="form-label">Availability *</label>
        <form:select path="productDetails.available" name="available" cssClass="form-select">
          <form:option value="true" label="In Stock"/>
          <form:option value="false" label="Out of Stock"/>
        </form:select>
        <form:errors path="productDetails.available" cssClass="text-danger"/>
      </div>
    </div>

    <div class="mb-3">
      <label class="form-label">Manufacturer *</label>
      <form:input path="productDetails.manufacturer" name="manufacturer" cssClass="form-control" placeholder="e.g. Acme Corporation"/>
      <form:errors path="productDetails.manufacturer" cssClass="text-danger"/>
    </div>

    <div class="mb-3">
      <label class="form-label">Expiration Date *</label>
      <form:input path="productDetails.expiration_date" name="expiration_date" type="date" cssClass="form-control"/>
      <form:errors path="productDetails.expiration_date" cssClass="text-danger"/>
    </div>

    <div class="d-flex justify-content-between mt-4">
      <button type="submit" class="btn btn-dark">Add Product</button>
      <a href="<c:url value='/products'/>" class="btn btn-outline-secondary">Cancel</a>
    </div>

  </form:form>

</div>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>