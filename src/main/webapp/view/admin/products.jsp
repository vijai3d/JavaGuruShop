<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="sidebar.jsp"/>

<div class="col-5" style="margin-top: 20px;">
    <div class="card">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="products" items="${productsList}" varStatus="iter">
                <tr>
                    <th scope="row">${iter.index + 1}</th>
                    <td>${products.name}</td>
                    <td>${products.price}</td>
                    <td>
                        <a class="btn btn-default" href="/admin/products/edit/${products.productId}" aria-label="Edit">
                            <i class="fa fa-pencil fa-lg" aria-hidden="true"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="/admin/products/delete/${products.productId}" aria-label="Delete">
                            <i class="fa fa-trash-o fa-lg" aria-hidden="true"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-primary" href="/admin/products?${products.productId}" aria-label="info">
                            <i class="fa fa-question fa-lg" aria-hidden="true"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%--Get info about Product--%>
<c:if test="${pageContext.request.queryString != null}">
    <div class="col-3" style="margin-top: 20px;">
        <div class="card">
            <c:choose>
                <c:when test="${selectedProduct.productId == pageContext.request.queryString}">
                    <ul class="list-group">
                        <li class="list-group-item"><strong>Customer details:</strong></li>
                        <li class="list-group-item">Name: ${selectedProduct.name}</li>
                        <li class="list-group-item">Description: ${selectedProduct.description}</li>
                        <li class="list-group-item">Price: ${selectedProduct.price}</li>
                    </ul>
                </c:when>
            </c:choose>
        </div>
    </div>
</c:if>
</div> <-- end of row
</body> <-- end of sidebar body
