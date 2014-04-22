<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.error{
color: red;
}
</style>
	<c:if test="${not empty message}">
		<div id="message" style="background-color: green">${message}</div></c:if>
	<spring:url value="/manage/add.do" var="action" />
	<form:form action="${action}" commandName="employee">
	<spring:hasBindErrors name="employee">
		<div class="error">
			<h4>Oops!</h4>
			<ul>
				<c:forEach var="error" items="${errors.allErrors}">
					<li><spring:message code="${error.codes[0]}"
							arguments="${error.arguments}" text="${error.defaultMessage}"></spring:message></li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>
		<div>
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /><form:errors path="firstName" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /><form:errors path="lastName" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="phone" /><form:errors path="phone" cssClass="error"/></td>
				</tr>
				<tr>
					<td><spring:message code="employee.form.email"/> <span style="color: red">*</span></td>
					<td><form:input path="email" /><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td colspan="1"><input type="submit" value="Submit"></td>
					<td colspan="1"><input type="button" value="list" onclick="location.href='<c:url value='/manage/list.do' />'"></td>
				</tr>
			</table>
		</div>
	</form:form>