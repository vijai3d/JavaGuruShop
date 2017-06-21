<jsp:include page="${pageContext.request.contextPath}/includes/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="alert alert-success" role="alert">
    <strong>Order is successfully added!</strong> Confirmation order number is : ${orderRecord.confirmationNumber}
</div>


    <dib class="row">
        <div class="col-6">
            <div class="card">
                <div class="container">
                    <table class="table table-striped">

                        <tbody>
                        <c:forEach var="orderedProduct" items="${orderedProducts}" varStatus="iter">
                        <tr>
                            <th scope="row"></th>
                            <td>${products[iter.index].name}</td>
                            <td>${products[iter.index].price}</td>
                            <td>${orderedProduct.quantity}</td>
                            <td>${products[iter.index].price * orderedProduct.quantity}</td>
                        </tr>
                        </c:forEach>
                        <tr>
                            <th scope="row"></th>
                            <td><strong>Total:</strong></td>
                            <td><strong></strong></td>
                            <td><strong></strong></td>

                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="col-6">
            <div class="card">
                <h4>Order details</h4>
                <p>Shipping surcharge: </p>
                <p>Total(including shipping price): ${orderRecord.amount}</p>
                <p>Date: ${orderRecord.dateCreated}</p>
                <br/>

                <table  class="table">
                    <tr class="header">
                        <th>Please check your delivery address:</th>
                    </tr>

                    <tr>
                        <td>
                            Name: ${customer.name}
                            <br>
                            Address: ${customer.address}
                            <br>
                            City: ${customer.city}
                            <br>
                            Country: ${customer.country}
                            <br>
                            <hr>
                            <strong>Email:</strong> ${customer.email}
                            <br>
                            <strong>Phone:</strong> ${customer.phone}
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </dib>
<jsp:include page="${pageContext.request.contextPath}/includes/footer.jsp"/>
