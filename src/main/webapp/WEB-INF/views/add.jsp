<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<c:if test="${not empty message}">
		<div id="message" style="background-color: green">${message}</div></c:if>
	<spring:url value="/manage/add.do" var="action" />
	<form:form action="${action}" commandName="employee">
		<div>
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td colspan="1"><input type="submit" value="Submit"></td>
					<td colspan="1"><input type="button" value="list" onclick="location.href='<c:url value='/manage/list.do' />'"></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>