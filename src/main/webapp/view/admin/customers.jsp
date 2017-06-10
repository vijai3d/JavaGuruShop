<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="sidebar.jsp"/>


<div class="col-5" style="margin-top: 20px;">
    <div class="card">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customers" items="${customerList}" varStatus="iter">
                <tr>
                    <th scope="row">${iter.index + 1}</th>
                    <td>${customers.name}</td>
                    <td>${customers.email}</td>
                    <td>${customers.phone}</td>
                    <td>
                        <a class="btn btn-danger" href="/admin/customers/delete/${customers.id}" aria-label="Delete">
                            <i class="fa fa-trash-o fa-lg" aria-hidden="true"></i>
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-primary" href="/admin/customers?${customers.id}" aria-label="info">
                            <i class="fa fa-question fa-lg" aria-hidden="true"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%--Get info about Customer--%>
<c:if test="${pageContext.request.queryString != null}">
    <div class="col-3" style="margin-top: 20px;">
        <div class="card">

            <c:choose>
                <c:when test="${selectedCustomer.id == pageContext.request.queryString}">
                    <ul class="list-group">
                        <li class="list-group-item"><strong>Customer details:</strong></li>
                        <li class="list-group-item">Name: ${selectedCustomer.name}</li>
                        <li class="list-group-item">Email: ${selectedCustomer.email}</li>
                        <li class="list-group-item">Phone: ${selectedCustomer.phone}</li>
                        <li class="list-group-item">Country: ${selectedCustomer.country}</li>
                        <li class="list-group-item">City: ${selectedCustomer.city}</li>
                        <li class="list-group-item">Address: ${selectedCustomer.address}</li>
                        <c:forEach var="orders" items="${ordersList}" varStatus="iter">
                            <li class="list-group-item">Order conf. number: <a href="#" >  ${orders.confirmationNumber}</a></li>
                        </c:forEach>

                    </ul>
                </c:when>
            </c:choose>
        </div>
    </div>
</c:if>
</div> <-- end of row
</body> <-- end of sidebar body
