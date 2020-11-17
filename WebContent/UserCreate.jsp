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
<title>Create a User</title>
</head>
<body>
<div class="container theme-showcase" role="main">

	<form action="usercreate" method="post">
		<div class="jumbotron">
			<h1>Moody Music App</h1>
		</div>
		<br />
		<div class="alert alert-info" role="alert">
			<h2>
				<span id="successMessage">You can create a MoodyMusic account</span>
			</h2>
		</div>
		<br />
		<h1>Create User</h1>
		<p>
			<label for="username">UserName</label>
			<input id="username" name="username" value="">
		</p>
		<p>
			<label for="phone">Phone</label>
			<input id="phone" name="phone" value="">
		</p>
		<p>
			<label for="email">Email</label>
			<input id="email" name="email" value="">
		</p>
		<p>
			<label for="city">City</label>
			<input id="city" name="city" value="">
		</p>
		<p>
			<label for="state">State</label>
			<input id="state" name="state" value="">
		</p>
		<p>
			<input type="submit" class="btn btn-lg btn-primary"> <br />
			<br />
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
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	</div>
	<!-- Bootstrap -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>