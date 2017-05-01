<jsp:include page="includes/header.jsp"/>

<div class="container" style="margin-top: 100px;">
    <table class="table table-striped">

        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Jurassic park</td>
            <td>9.99</td>
            <td>1</td>
            <td><a href="#">Update</a></td>
            <td><a href="#">Remove</a></td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Ticket to the moon</td>
            <td>5.89</td>
            <td>1</td>
            <td><a href="#">Update</a></td>
            <td><a href="#">Remove</a></td>
        </tr>
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
<jsp:include page="includes/footer.jsp"/>