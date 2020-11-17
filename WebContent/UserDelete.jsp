<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Delete a User</title>
</head>
<body>
<div class="container theme-showcase" role="main">

	<form action="userdelete" method="post">
		<div class="jumbotron">
			<h1>Moody Music App</h1>
		</div>
		<br />
		<div class="alert alert-info" role="alert">
			<h2>
				<span id="successMessage">You can delete a MoodyMusic account</span>
			</h2>
		</div>
		<br />
		
		<h1>${messages.title}</h1>
		<div <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
			<label for="username">UserName</label>
			<input id="username" name="username" value="${fn:escapeXml(param.username)}">
		</div>
		<p>
			<span id="submitButton" <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
			<input type="submit" class="btn btn-lg btn-primary">
			</span>
		</p>
	</form>
	<div id="findsongs">
			<h3>
				<a href="findsongs">Find Songs</a>
			</h3>
		</div>
		<div id="displaysongs">
			<h3>
				<a href="displaysongs">Recommend Songs</a>
			</h3>
		</div>
		<div id="songbyyear">
			<h3>
				<a href="songbyyear">Top 100 Songs Of a Year</a>
			</h3>
		</div>
		<div id="topartists">
			<h3>
				<a href="topartists">Most Popular Artist of a Year</a>
			</h3>
		</div>
	<br/><br/>
	</div>

	<!-- Bootstrap -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>