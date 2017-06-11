
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="sidebar.jsp"/>

<div class="col-6" style="margin-top: 20px;">
    <div class="card">
        <form action="/admin/edit-product/update" method="post">
            <div class="form-group col-6">
                <label for="categorySelect">Category</label>
                <select class="form-control" id="categorySelect" name="productCategory">
                    <option>${selectedProduct.category}</option>
                    <c:forEach var="categories" items="${categoryList}">
                    <option>${categories.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-6">
                <label for="exampleInputName">Name:</label>
                <input  type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp"
                       value="${selectedProduct.name}" name="productName">
            </div>
            <div class="form-group col-12">
                <label for="description">Description:</label>
                <textarea class="form-control" id="description" rows="6"
                           name="productDesc">${selectedProduct.description}</textarea>
            </div>
            <div class="form-group col-2">
                <label for="inputPrice">Price:</label>
                <input type="text" class="form-control" id="inputPrice" aria-describedby="emailHelp"
                       value="${selectedProduct.price}" name="productPrice">
            </div>
            <input type="hidden"
                   name="productId"
                   value="${selectedProduct.productId}">

            <div class="form-group col-1">
            <input class="btn btn-primary "
                   type="submit"
                   name="submit"
                   value="Update">
            </div>
        </form>
    </div>
</div>
</div> <-- end of row
</body> <-- end of sidebar body

