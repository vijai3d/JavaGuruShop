<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="${pageContext.request.contextPath}/includes/header.jsp"/>
<div class="card">
    <div class="container">
        <form:form action="signup" method="post" modelAttribute="newCustomer">

                <div class="form-group">
                    <label for="name">First name and last name:</label>
                    <form:input type="text" class="form-control"
                           size="31"
                           maxlength="45"
                           id="name"
                           path="name"
                           name="name"
                           />
                        <strong style="color:red;"> <form:errors path="name"  /></strong>

                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <form:input type="text" class="form-control"
                           size="31"
                           maxlength="16"
                           id="phone"
                           name="phone"
                                path="phone"/>
                    <strong style="color:red;"> <form:errors path="phone"/></strong>
                </div>
                <div class="form-group">
                    <label for="country">Country:</label>
                    <form:input type="text" class="form-control"
                           size="31"
                           maxlength="45"
                           id="country"
                           name="country"
                           path="country"/>
                    <strong style="color:red;"> <form:errors path="country"/></strong>
                </div>
                <div class="form-group">
                    <label for="city">City:</label>
                    <form:input type="text" class="form-control"
                           size="31"
                           maxlength="45"
                           id="city"
                           name="city"
                           path="city"/>
                    <strong style="color:red;"> <form:errors path="city"/></strong>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <form:input type="text" class="form-control"
                           size="31"
                           maxlength="245"
                           id="address"
                           name="address"
                           path="address"/>
                    <strong style="color:red;"> <form:errors path="address"/></strong>
                </div>
                <div class="form-group">
                    <label for="email">Email address:</label>
                    <form:input type="email" class="form-control"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           path="email"/>
                    <strong style="color:red;"> <form:errors path="email"/></strong>
                </div>
            <div class="form-group">
                <label for="email">Password:</label>
                <form:input type="password" class="form-control"
                            size="31"
                            maxlength="45"
                            id="email"
                            name="password"
                            path="password"/>
                <strong style="color:red;"> <form:errors path="password"/></strong>
            </div>
            <div class="form-group">
                <label for="email">Confirm password:</label>
                <input type="password" class="form-control"
                            size="31"
                            maxlength="45"
                            id="email"
                            name="confirmPassword"
                            />
                <strong style="color:red;">${passwordMessage}</strong>
            </div>
                <button type="submit" class="btn btn-default">Submit</button>

        </form:form>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/includes/footer.jsp"/>