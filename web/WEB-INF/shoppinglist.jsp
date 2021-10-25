

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Lists: </title>
    </head>
    <body>
        <h1>Shopping Lists </h1>
        <h3>Hello ${userName}</h3>
        <h3><a href="<c:url value='/ShoppingList'><c:param name='acts' value='logout' /></c:url>">Logout</a></h3>
        
        <form action="" method="POST">
            <p>Add an Item </p>
            <input type="text" name="item">
            <input type="submit" value="Add Item">
            <input type="hidden" name="acts" value="add">
        </form>
        
        <form action="" method="POST">
            <ul>
                <c:forEach items="${items}" var="item">
                    <li><input type="radio" name="item" value="${item}">${item}</li>
                </c:forEach>  
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="acts" value="del">
        </form>
            
        
              
    </body>
</html>
