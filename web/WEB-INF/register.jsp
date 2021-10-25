

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List: </h1>
        
        
        <form action="ShoppingList" method="POST">
            <label>User Name: </label>
            <input type="text" name="userName">
            <input type="hidden" name="acts" value="reg">
            <br>
            <input type="submit" value="Register">
            
            
        </form>
    </body>
</html>
