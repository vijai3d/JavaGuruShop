
<div class=<jsp:include page="${pageContext.request.contextPath}/includes/header.jsp"/>

     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
             <section>
    <div class="container py-3">
        <div class="card">
            <div class="row ">
                <div class="col-md-4">
                    <c:forEach var="pictures" items="${pictureList}" varStatus="iter">
                        <c:if test="${pictures.product.equals(product)}">
                            <c:if test="${pictures.prymary != null}">
                                <li class="list-group-item">
                                    <img class="card-img-top" alt="${pictures.name}"
                                         src="data:image/png;base64,${pictures.encodedData}"
                                         data-holder-rendered="true" style=" width: 100%; display: block;">
                                </li>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="col-md-8 px-3">
                    <div class="card-block px-3">
                        <h4 class="card-title">${product.name}</h4>
                        <p class="card-text">${product.description}</p>
                        <p class="card-text">${product.price}</p>
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
        </div>
    </div>
</div>
</section>

<jsp:include page="${pageContext.request.contextPath}/includes/footer.jsp"/>