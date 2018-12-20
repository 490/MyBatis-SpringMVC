<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2018/10/12
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>水果列表</title>
</head>

<body>
    <form action="queryFruitsByCondition" method="post"  >
        name: <input type="text" name="name"/>&nbsp;&nbsp;
        area: <input type="text" name="producing_area"/>
        <input type="submit" value="sososo"/>

        <c:if test="${allErrors!=null}">
            <c:forEach items="${allErrors}" var="error">
                <font color="#8b0000">${error.defaultMessage}</font><br/>
            </c:forEach>
        </c:if>
    </form>
<hr/>
<h3>搜索结果</h3>
<table width="300px;" border="1">
    <tr>
        <td>name</td>
        <td>area</td>
        <td>price</td>
    </tr>
    <c:forEach items="${fruitsList}" var="fruit">
        <tr>
            <td>${fruit.name}</td>
            <td>${fruit.producing_area}</td>
            <td>${fruit.price}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
