<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>
<h2><font color="red">An error has occurred.</font></h2>
<p>The error code is <%=response.getStatus() %><br>
Please go to <a href="index.zul">home page and cry</a>
</body>
</html>
