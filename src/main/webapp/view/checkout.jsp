<jsp:include page="../includes/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="view" value="/checkout" scope="session"/>

<div class="container">
    <h2>Checkout</h2>
    <div class="container">
    <div class="row">
        <p>Shipping address:</p>
    </div>
    </div>
<div class="row">
    <div class="col-6">
        <c:if test="${!empty orderFailureFlag}">
            <div class="alert alert-danger" role="alert">
                <strong>Oh snap!</strong> Change a few things up and try submitting again.
            </div>
        </c:if>
        <div class="card">
            <div class="container">
                <form action="purchase" method="post">
                    <c:if test="${!empty validationErrorFlag}">
                    <div class="form-group">
                        <label for="name">First name and last name:</label>
                        <input type="text" class="form-control" id="name">
                    </div>
                    <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" id="phone">
                </div>
                    <div class="form-group">
                        <label for="country">Country:</label>
                        <input type="text" class="form-control" id="country">
                    </div>
                    <div class="form-group">
                        <label for="city">City:</label>
                        <input type="text" class="form-control" id="city">
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" class="form-control" id="address">
                    </div>
                    <div class="form-group">
                        <label for="email">Email address:</label>
                        <input type="email" class="form-control" id="email">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" class="form-control" id="pwd">
                    </div>
                    <div class="form-group">
                        <label for="pwd2">Confirm password:</label>
                        <input type="password" class="form-control" id="pwd2">
                    </div>

                    <button type="submit" class="btn btn-default">Submit</button>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
    <div class="col-6">
        <div class="row">
            <div class="card">
                <h4>[Purchase conditions]</h4>
                ${initParam.deliverySurcharge}
            </div>
        </div>
        <div class="row">
            <div class="card">


                <table id="priceBox">
                    <tr>
                        <td>subtotal:</td>
                        <td>
                            ${cart.subtotal}</td>
                    </tr>
                    <tr>
                        <td>Shipping and packaging:</td>
                        <td>
                            &euro; ${surcharge}</td>
                    </tr>
                    <tr>
                        <td>total:</td>
                        <td>
                           &euro; ${cart.total}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="../includes/footer.jsp"/>