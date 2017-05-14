<jsp:include page="../includes/header.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<c:set var="view" value="/category" scope="session" />

<%--<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/java_guru_shop2"
                   user="root" password="passw"/>

<sql:query var="categories" dataSource="${dataSource}">
    SELECT * FROM category
</sql:query>

<sql:query var="selectedCategory" dataSource="${dataSource}">
    SELECT * FROM category WHERE id=?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>

<sql:query var="categoryProducts" dataSource="${dataSource}">
    SELECT * FROM product WHERE category_id=?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>--%>
<c:if test="${pageContext.request.getParameter('submit') != null}">
    <script>
        window.setTimeout(function() {
            $(".alert").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 2000);
    </script>
    <div class="alert alert-success" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <strong>Success!</strong> Product is added!
    </div>
</c:if>

<div class="container-fluid">
    <div class="row">
        <div class="col-2">
            <%--left column--%>
            <div class="card">
                <div class="card-block">
                    <h4>Categories:</h4>
                    <div class="list-group">
                        <c:forEach var="category" items="${categories}">
                            <c:choose>
                                <c:when test="${category.categoryId == pageContext.request.queryString}">
                                    <div class="list-group-item active">
                                            ${category.categoryName}
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <a href="category?${category.categoryId}" class="list-group-item list-group-item-action">
                                            ${category.categoryName}
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-10">
            <div class="card">
                <div class="navbar navbar-light bg-faded">
                    <h4 class="navbar-brand">Explore our new ${selectedCategory.categoryName} collection</h4>
                </div>
            </div>
            <hr/>
            <%--right column--%>
            <div class="row">
                <c:forEach var="product" items="${categoryProducts}" varStatus="iter">
                    <div class="col-sm-12 col-md-4 col-lg-3">
                        <div class="card card-block">
                            <img class="card-img-top" data-src="holder.js/100px180/" alt="100%x180"
                                 src="data:image/svg+xml;charset=UTF-8,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22318%22%20height%3D%22180%22%20viewBox%3D%220%200%20318%20180%22%20preserveAspectRatio%3D%22none%22%3E%3C!--%0ASource%20URL%3A%20holder.js%2F100px180%2F%0ACreated%20with%20Holder.js%202.8.2.%0ALearn%20more%20at%20http%3A%2F%2Fholderjs.com%0A(c)%202012-2015%20Ivan%20Malopinsky%20-%20http%3A%2F%2Fimsky.co%0A--%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%3C!%5BCDATA%5B%23holder_153cdb63a13%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A16pt%20%7D%20%5D%5D%3E%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_153cdb63a13%22%3E%3Crect%20width%3D%22318%22%20height%3D%22180%22%20fill%3D%22%23777%22%2F%3E%3Cg%3E%3Ctext%20x%3D%22118.0859375%22%20y%3D%2297.35%22%3E318x180%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
                                 <%--TODO--%>
                            <%--<img src="${initParam.productImagePath}${product.name}.png" alt="${product.name}">--%>
                                 data-holder-rendered="true" style="height: 180px; width: 100%; display: block;">
                            <div class="card-block">
                                <h4 class="card-title">${product.name}</h4>
                                <p class="card-text">${fn:substring(product.description, 0, 22)}...</p>
                                <p class="card-text">&euro;${product.price}</p>
                                <form action="addToCart" method="post">
                                    <input type="hidden"
                                           name="productId"
                                           value="${product.productId}">
                                    <input class="btn btn-primary"  type="submit"
                                           name="submit"
                                           value="Add to cart">
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>


            </div>
        </div>
    </div>
</div>

<jsp:include page="../includes/footer.jsp"/>