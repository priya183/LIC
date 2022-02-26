<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
</head>
<body style="background-color:pink;">
    <div align="center">
        <h2>User Registration Form</h2>
        <form action="userform" method="get" >
        <fieldset style="background-color:white;" >
        <table >
        <tr>
        <td>First Name:</td>
        <td><input type="text" name="firstName"/></td>
        </tr>
       <tr>
        <td>Last Name:</td>
        <td><input type="text" name="lastName"/></td>
        </tr>
        <tr>
        <td>Pan No:</td>
        <td><input type="text" name="panNo"/></td>
        </tr>
        <tr>
        <td>Adhar No:</td>
        <td><input type="text" name="adharNo"/></td>
        </tr>
        <tr>
        <td>Address:</td>
        <td><input type="text" name="address"/></td>
        </tr>
       </table>
            <input type="submit" value="Submit"/>
            </fieldset>
        </form>
    </div>
</body>
</body>
</html>