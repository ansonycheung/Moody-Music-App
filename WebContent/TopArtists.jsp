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
<title>Find Songs</title>
</head>
<body>
	<div class="container theme-showcase" role="main">

		<form action="topartists" method="post">
			<div class="jumbotron">
				<h1>Moody Music App</h1>
			</div>
			<br />
			<div class="alert alert-info" role="alert">
				<h2>
					<span id="artistMessage">You can search the top artists by a specific year</span>
				</h2>
			</div>
			<br />
			<p>
			<h2>
				<label for="year">Year</label>
			</h2>
			<input id="year" name="year" value="${fn:escapeXml(param.year)}">
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
		

		<br />
		<div class="alert alert-info" role="alert">
			<h2>
				<span id="artistMessage"><b>${messages.success}</b></span>
			</h2>
		</div>
		<br />
		<h1>Top Artists</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Artist Key</th>
					<th>Artist Name</th>					
					<th>Year</th>
					<th>Popularity</th>			
				</tr>
			</thead>
 			<c:forEach items="${artists}" var="artist" >
                <tbody><tr>
                    <td><c:out value="${artist.getArtistKey()}" /></td>
                    <td><c:out value="${artist.getArtistName()}" /></td>
                    <td><c:out value="${fn:escapeXml(param.year)}" /></td>
                    <td><c:out value="${artist.getPopularity()}" /></td>
                </tr></tbody>
            </c:forEach>
		</table>

	</div>

	<!-- Bootstrap -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>