<jsp:include page="../../includes/header.jsp"/>

<div class="container" style="margin-top: 100px;">
    <table class="table table-striped">

        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Jurassic park</td>
            <td>9.99</td>
            <td>
                <label class="sr-only" for="inlineFormInputGroup">1</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <div class="input-group-addon">Qty</div>
                    <select class="cant_p">
                        <option value="1" selected="">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>
                </div>
            </td>
            <td><a href="#">Update</a></td>
            <td><a href="#">Remove</a></td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Ticket to the moon</td>
            <td>5.89</td>
            <td>
                <label class="sr-only" for="inlineFormInputGroup">1</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <div class="input-group-addon">Qty</div>
                    <select class="cant_p">
                        <option value="1" selected="">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>
                </div>
            </td>
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
<jsp:include page="../../includes/footer.jsp"/>