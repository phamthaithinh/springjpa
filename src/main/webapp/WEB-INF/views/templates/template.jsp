<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" /></title>
<style type="text/css">
#header {
	width: 100%;
	clear: both;
	border: solid 2px;
}

#menu {
	width: 18%;
	float: left;
	border: solid 2px;
}

#content {
	width: 80%;
	float: right;
	border: solid 2px;
}

#footer {
	width: 100%;
	clear: both;
	border: solid 2px;
}
</style>
</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="menu">
		<tiles:insertAttribute name="menu" />
	</div>
	<div id="content">
		<tiles:insertAttribute name="content" />
	</div>
	
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>