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
            <th>Update</th>
            <th>Remove</th>
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
                    <input type="text" value="1" size="1" maxlength="2">
                </td>
                <td><a href="#">Update</a></td>
                <td><a href="#">Remove</a></td>
            </tr>
        </c:forEach>

        <tr>
            <th scope="row"></th>
            <td><strong>Total:</strong></td>
            <td><strong>14.89</strong></td>
            <td><strong>2</strong></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>

    <a href="#" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Clear cart</a>
    <a href="#" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Continue shopping</a>
    <a href="#" class="btn btn-success btn-lg active" role="button" aria-pressed="true">Proceed to checkout</a>
</div>
<jsp:include page="../includes/footer.jsp"/>