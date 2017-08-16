<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<title>Login/Register</title>
<style>

	h1 {
	margin-top: 40px;
	text-align: center;
	
	}
	.container {
	text-align: center;
	padding: 20px;
	
	}
	
	.contain {
	text-align: center;
	padding: 20px;
	padding-left: 10px;
	}
</style>
</head>
<body>
	<c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if>
    <h1>Login</h1>
    <div class="contain">
    <c:if test="${errorMessage != null}">
        <c:out value="${errorMessage}"></c:out>
    </c:if>
    <form method="POST" action="/login">
        <p>
            <label for="username">Email</label>
            <input type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login"/>
    </form>
    </div>
    <h1>Register!</h1>
    <div class="container">
    <p><form:errors path="user.*"/></p>
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="username">Email:</form:label>
            <form:input path="username"/>
        </p>
        <p>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Confirm Password:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register"/>
    </form:form>
   </div>
</body>
