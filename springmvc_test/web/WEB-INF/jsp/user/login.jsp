<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2018/10/12
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>denglu</title>
</head>
<body>
    <form action="login" method="post"  >
        id: <input type="text" name="username"/></br>
        passwd: <input type="text" name="password"/></br>
        <input type="submit" value="login"/>
        <c:if test="${allErrors!=null}">
            <c:forEach items="${allErrors}" var="error">
                <br/><font color="#7fff00">${error.defaultMessage}</font>
            </c:forEach>
        </c:if>

        <c:if test="${errorMsg!=null}">
            <font color="#ff7f50">${errorMsg}</font>
        </c:if>
    </form>
    <a href="${pageContext.request.contextPath}/user/loginout">注销</a>
</body>
</html>
