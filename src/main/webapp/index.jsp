<jsp:include page="includes/header.jsp" />

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/java_guru_shop2"
                   user="root"  password="passw"/>
<sql:query var="categories" dataSource="${dataSource}">
    SELECT * FROM category
</sql:query>--%>

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
                    <!-- test to access context parameters -->
                    categoryImagePath: ${initParam.categoryImagePath}
                    productImagePath: ${initParam.productImagePath}
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
                    <c:forEach var="category" items="${categories}">
                    <div class="card" style="width: 30rem;">
                        <img class="card-img-top" src="${initParam.categoryImagePath}${category.categoryName}.jpg" alt="Card image cap">
                        <div class="card-block">
                            <h4 class="card-title">${category.categoryName}</h4>
                            <a href="category?${category.categoryId}" class="btn btn-primary">BUY Games</a>
                        </div>
                    </div>
                    </c:forEach>
                </div>

        </div>
    </div>
</div>

<jsp:include page="includes/footer.jsp"/>