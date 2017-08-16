<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<title>Dashboard</title>
</head>
<style>

h1 {
margin-left: 50px;
margin-top: 20px;
}
.container {
	text-align: center;
	background-color: lightgrey;
    width: 350px;
    border: 3px solid grey;
    padding: 20px;
    margin-left: 200px;
    margin-top: 50px;

 }
 
 	.out {
 	margin-right: 20px;
 	}
</style>
<body>
	<div class="out">
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout" />
    </form>
    </div>
	<h1>Welcome <c:out value="${currentUser.firstName}"/>!</h1>
	<div class="container">
	<p>First Name: <c:out value="${currentUser.firstName}"/></p>
	<p>Last Name: <c:out value="${currentUser.lastName}"/></p>
	<p>Email: <c:out value="${currentUser.username}"/></p>
	<p>Sign up date: <fmt:formatDate pattern="MMMM d, yyyy" value="${currentUser.createdAt}"/></p>
	<p>Last sign in: <fmt:formatDate pattern="MMMM d, yyyy" value="${lastLogin}"/></p>
	</div>

</body>
</html>