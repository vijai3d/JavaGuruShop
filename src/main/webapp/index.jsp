<jsp:include page="includes/header.jsp" />

<div class="alert alert-success" role="alert">
    <strong>Well done!</strong> You successfully read this important alert message.
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-3">
            <%--left column--%>
            <div class="card">
                <div class="card-block">
                    <h2>Welcome to our new shop!</h2>
                    <hr/>
                    <p>
                        It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                    </p>
                </div>
            </div>
        </div>
        <div class="col-9">
            <%--right column--%>
                <div class="card-deck">
                    <div class="card" style="width: 30rem;">
                        <img class="card-img-top" src="resources/images/games.png" alt="Card image cap">
                        <div class="card-block">
                            <h4 class="card-title">Game section</h4>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">BUY Games</a>
                        </div>
                    </div>
                    <div class="card" style="width: 30rem;">
                        <img class="card-img-top" src="resources/images/books.png" alt="Card image cap">
                        <div class="card-block">
                            <h4 class="card-title">Books section</h4>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">BUY Books</a>
                        </div>
                    </div>
                    <div class="card" style="width: 30rem;">
                        <img class="card-img-top" src="resources/images/cds.jpg" alt="Card image cap">
                        <div class="card-block">
                            <h4 class="card-title">CD's section</h4>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">BUY CD's</a>
                        </div>
                    </div>
                    <div class="card img-thumbnail" style="width: 30rem;">
                        <img class="card-img-top" src="resources/images/dvds.jpg" alt="Card image cap">
                        <div class="card-block">
                            <h4 class="card-title">DVD's section</h4>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">BUY DVD's</a>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</div>

<jsp:include page="includes/footer.jsp"/>