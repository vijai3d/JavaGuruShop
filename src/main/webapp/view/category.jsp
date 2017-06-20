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
                            <c:forEach var="pictures" items="${pictureList}" varStatus="iter">
                                <c:if test="${pictures.product.equals(product)}">
                                <c:if test="${pictures.prymary != null}">
                                    <li class="list-group-item">
                                        <img class="card-img-top" alt="${pictures.name}"
                                             src="data:image/png;base64,${pictures.encodedData}"
                                             data-holder-rendered="true" style="height: 180px; width: 100%; display: block;">
                                    </li>
                                </c:if>
                                </c:if>
                            </c:forEach>
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