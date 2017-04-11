<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vuclip
  Date: 09/04/17
  Time: 3:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/student/submit.html" method="post">
    <table>
        <tr>
            <td>Student Name:</td>
            <td><input type="text" name="name"></td>
        </tr>

        <tr>
            <td>Student Age:</td>
            <td><input type="text" name="age"></td>
        </tr>
    </table>

    <input type="submit" value="Submit Data">
</form>

</body>
</html>
