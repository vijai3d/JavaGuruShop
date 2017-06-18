<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="sidebar.jsp"/>

<div class="col-6" style="margin-top: 20px;">
    <div class="card">
        <form action="${pageContext.request.contextPath}/admin/products/add" method="post" enctype="multipart/form-data">
            <div class="form-group col-6">
                <label>Category</label>
                <select class="form-control" id="categorySelect"  name="productCategoryId">
                    <c:forEach var="categories" items="${categoryList}">
                        <option value="${categories.categoryId}">${categories.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-6">
                <label for="exampleInputName">Name:</label>
                <input  type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp"
                         name="productName" value="Title"/>
            </div>
            <div class="form-group col-12">
                <label for="description">Description:</label>
                <textarea  class="form-control" id="description" rows="6"
                          name="productDesc" ></textarea>
            </div>
            <div class="form-group col-2">
                <label for="inputPrice">Price:</label>
                <input  type="text" class="form-control" id="inputPrice" aria-describedby="emailHelp"
                        name="productPrice"/>
            </div>
            <div class="form-group" col-6>
                <label for="exampleInputFile1">Upload image Nr1</label>
                <input type="file" class="form-control-file" id="exampleInputFile1" aria-describedby="fileHelp" name="productImage"/>
                <small id="fileHelp1" class="form-text text-muted">Max size of image is 1Mb and dimensions 1024x1024px</small>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="isPrimaryValue" value="1">
                        Make Primary
                    </label>
                </div>
            </div>
            <div class="form-group" col-6>
                <label for="exampleInputFile2">Upload image Nr2</label>
                <input type="file" class="form-control-file" id="exampleInputFile2" aria-describedby="fileHelp" name="productImage"/>
                <small id="fileHelp2" class="form-text text-muted">Max size of image is 1Mb and dimensions 1024x1024px</small>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="isPrimaryValue" value="2">
                        Make Primary
                    </label>
                </div>
            </div>

            <div class="form-group col-1">
                <input class="btn btn-primary "
                       type="submit"
                       name="submit"
                       value="Add">
            </div>
        </form>
    </div>
</div>
</div> <-- end of row
</body> <-- end of sidebar body
