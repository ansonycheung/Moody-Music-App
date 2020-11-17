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
<title>Recommend Songs</title>
</head>
<body>
<div class="container theme-showcase" role="main">

	<form action="displaysongs" method="post">
		<div class="jumbotron">
			<h1>Moody Music App</h1>
		</div>
		<br />
		<div class="alert alert-info" role="alert">
			<h2>
				<span id="songMessage">You can get the top 100 songs of all time and recommend songs for todays' weather</span>
			</h2>
		</div>
		<br />
		<p>
			<h2><label for="username">Enter your user name</label></h2>
			<input id="username" name="username" value="${fn:escapeXml(param.username)}">
		</p>
		<p>
			<label for="alltime">Top 100 Songs of All Time</label>
			<input type="submit" class="btn btn-lg btn-primary" id="alltime" name="alltime" value="confirmSearch">
		</p>
		<p>
			<label for="generate">Recommend Songs for today's weather</label>
			<input type="submit" class="btn btn-lg btn-primary" id="generate" name="generate" value="confirmGenerate">
		</p>
	</form>
	
		<div id="findsongs">
			<h3>
				<a href="findsongs">Find Songs</a>
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

		<br />
		<div class="alert alert-info" role="alert">
			<h2>
				<span id="songMessage"><b>${messages.song}</b></span>
			</h2>
		</div>
		<br />
		<h1>Results</h1>
      	<table class="table table-striped">
           <thead><tr>
               <th>Title</th>
               <th>ArtistName</th>
               <th>Year Released</th>
           </tr></thead>
           <c:forEach items="${songs}" var="song" varStatus="status">
               <tbody><tr>
                   <td><c:out value="${song.getTitle()}"/></td>
                   <td>${names[status.index]}</td>
                   <td><c:out value="${song.getYear()}"/></td>
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