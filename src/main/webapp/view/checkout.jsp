<jsp:include page="../includes/header.jsp"/>

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

        <div class="card">
            <div class="container">
                <form>
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
                </form>
            </div>
        </div>
    </div>
    <div class="col-6">
        <div class="row">
            <div class="card">
                <h4>[Purchase conditions]</h4>
            </div>
        </div>
        <div class="row">
            <div class="card">
                <h4>[Purchase calculations: shipping + total]</h4>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="../includes/footer.jsp"/>