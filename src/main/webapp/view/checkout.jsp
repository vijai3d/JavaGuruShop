<jsp:include page="${pageContext.request.contextPath}/includes/header.jsp"/>
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
                        <input type="text" class="form-control"
                               size="31"
                               maxlength="45"
                               id="name"
                               name="name"
                               value="${param.name}">
                        <c:if test="${!empty nameError}">
                            <div class="alert alert-danger" role="alert">
                                <strong>Please correct</strong> This field cannot be empty or too long.
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control"
                           size="31"
                           maxlength="16"
                           id="phone"
                           name="phone"
                           value="${param.phone}">
                        <c:if test="${!empty phoneError}">
                            <div class="alert alert-danger" role="alert">
                                <strong>Please correct</strong> This field cannot be empty or too long.
                            </div>
                        </c:if>
                </div>
                    <div class="form-group">
                        <label for="country">Country:</label>
                        <input type="text" class="form-control"
                               size="31"
                               maxlength="45"
                               id="country"
                               name="country"
                               value="${param.country}">
                        <c:if test="${!empty countryError}">
                            <div class="alert alert-danger" role="alert">
                                <strong>Please correct</strong> This field cannot be empty or too long.
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="city">City:</label>
                        <input type="text" class="form-control"
                               size="31"
                               maxlength="45"
                               id="city"
                               name="city"
                               value="${param.city}">
                        <c:if test="${!empty cityError}">
                            <div class="alert alert-danger" role="alert">
                                <strong>Please correct</strong> This field cannot be empty or too long.
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" class="form-control"
                               size="31"
                               maxlength="45"
                               id="address"
                               name="address"
                               value="${param.address}">
                        <c:if test="${!empty addressError}">
                            <div class="alert alert-danger" role="alert">
                                <strong>Please correct</strong> This field cannot be empty or too long.
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="email">Email address:</label>
                        <input type="email" class="form-control"
                               size="31"
                               maxlength="45"
                               id="email"
                               name="email"
                               value="${param.email}">
                        <c:if test="${!empty emailError}">
                            <div class="alert alert-danger" role="alert">
                                <strong>Please correct</strong> This field cannot be empty or too long.
                            </div>
                        </c:if>
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
<jsp:include page="${pageContext.request.contextPath}/includes/footer.jsp"/>