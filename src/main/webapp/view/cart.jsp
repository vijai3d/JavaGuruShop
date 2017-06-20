<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header.jsp"/>

<div class="container" style="margin-top: 100px;">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Unit Price</th>
            <th>Total Price</th>
            <th>Qty</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">
            <c:set var="product" value="${cartItem.product}"/>
            <tr>
                <th scope="row">${iter.index + 1}</th>
                <td>${product.name}</td>
                <td>
                    ( &euro; ${product.price} / unit )
                </td>
                <td>
                    &euro; ${cartItem.total}
                </td>
                <td>
                    <form action="updateCart" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.productId}">
                        <input type="text"
                               maxlength="2"
                               size="2"
                               value="${cartItem.quantity}"
                               name="quantity"
                               style="margin:5px">
                        <input class="btn btn-primary"
                                type="submit"
                               name="submit"
                               value="Update">
                    </form>
                </td>

            </tr>
        </c:forEach>

        <tr>
            <th scope="row"></th>
            <td><strong>Total:</strong></td>
            <td><strong></strong></td>
            <td><strong>${cart.subtotal}</strong></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>

    <%-- clear cart widget --%>
    <c:if test="${!empty cart && cart.numberOfItems != 0}">

        <c:url var="url" value="viewCart">
            <c:param name="clear" value="true"/>
        </c:url>

        <a href="${url}" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Clear cart</a>
    </c:if>

    <%-- continue shopping widget --%>
    <c:set var="value">
        <c:choose>
            <%-- if 'selectedCategory' session object exists, send user to previously viewed category --%>
            <c:when test="${!empty selectedCategory}">
                category
            </c:when>
            <%-- otherwise send user to welcome page --%>
            <c:otherwise>
                /index
            </c:otherwise>
        </c:choose>
    </c:set>

    <c:url var="url" value="${value}"/>
    <a href="${url}" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Continue shopping</a>

    <%-- checkout widget --%>
    <c:if test="${!empty cart && cart.numberOfItems != 0}">
        <a href="checkout" class="btn btn-success btn-lg active" role="button" aria-pressed="true">Proceed to checkout</a>
        </div>
    </c:if>

<jsp:include page="../includes/footer.jsp"/>