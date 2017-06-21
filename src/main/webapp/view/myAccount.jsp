<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="${pageContext.request.contextPath}/includes/header.jsp"/>
    <div class="container">
        <div class="col-7" style="margin-top: 20px;">
            <div class="card">
                        <ul class="list-group">
                            <li class="list-group-item"><strong>Customer details:</strong></li>
                            <li class="list-group-item">Name: ${customer.name}</li>
                            <li class="list-group-item">Email: ${customer.email}</li>
                            <li class="list-group-item">Phone: ${customer.phone}</li>
                            <li class="list-group-item">Country: ${customer.country}</li>
                            <li class="list-group-item">City: ${customer.city}</li>
                            <li class="list-group-item">Address: ${customer.address}</li>
                            <c:forEach var="orders" items="${ordersList}" varStatus="iter">
                                <li class="list-group-item">Order conf. number: <a href="#" >  ${orders.confirmationNumber}</a></li>
                            </c:forEach>
                        </ul>
            </div>
        </div>
    </div>
<jsp:include page="${pageContext.request.contextPath}/includes/footer.jsp"/>