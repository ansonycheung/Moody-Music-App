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

		<form action="findsongs" method="post">
			<div class="jumbotron">
				<h1>Moody Music App</h1>
			</div>
			<br />
			<div class="alert alert-info" role="alert">
				<h2>
					<span id="songMessage">You can search a song by one of the following options</span>
				</h2>
			</div>
			<br />
			<p>
			<h2>
				<label for="title">Song's Title</label>
			</h2>
			<input id="title" name="title" value="${fn:escapeXml(param.title)}">
			</p>
			<p>
			<h2>
				<label for="artistname">Song's Artist Name</label>
			</h2>
			<input id="artistname" name="artistname"
				value="${fn:escapeXml(param.artistname)}">
			</p>
			<p>
				<input type="submit" class="btn btn-lg btn-primary"> <br />
				<br />
			</p>
		</form>

		<div id="usercreate">
			<h3>
				<a href="usercreate">Create an account</a>
			</h3>
		</div>
				<div id="userupdate">
			<h3>
				<a href="userupdate">Update your account</a>
			</h3>
		</div>
				<div id="userdelete">
			<h3>
				<a href="userdelete">Delete an account</a>
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

		<br />
		<div class="alert alert-info" role="alert">
			<h2>
				<span id="songMessage"><b>${messages.song}</b></span>
			</h2>
		</div>
		<br />
		<h1>Matching Songs</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Song Id</th>
					<th>Song Title</th>
					<th>Artist Names</th>
					<th>Artist Key</th>					
					<th>Year</th>
					<th>Popularity</th>			
				</tr>
			</thead>
 			<c:forEach items="${outputmap}" var="entry">
				<tbody>
					<c:forEach items="${entry.value}" var="song">
					<tr>
						<td><c:out value="${song.getSongId()}" /></td>
						<td><c:out value="${song.getTitle()}" /></td>
						<td>
							<c:forEach items="${entry.key}" var="artistslist">
								<c:out value="${artistslist.getArtistName()}" />,
							</c:forEach>
						</td>
						<td><c:out value="${entry.key.get(0).getArtistKey()}" /></td>
						<td><c:out value="${song.getYear()}" /></td>
						<td><c:out value="${song.getPopularity()}" /></td>
					</tr>
					</c:forEach>
				</tbody>
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