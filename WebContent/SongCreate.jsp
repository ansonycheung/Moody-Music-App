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
<title>Create a Song</title>
</head>
<body>
	<div class="container theme-showcase" role="main">

		<div class="jumbotron">
			<h1>Create Songs</h1>
		</div>
		<form action="songcreate" method="post">
			<p>
			<h2>
				<label for="songid">Song Id</label>
			</h2>
			<input id="songid" name="songid" value="">
			</p>
			<p>
			<h2>
				<label for="acousticness">Acousticness (0 - 1)</label>
			</h2>
			<input id="acousticness" name="acousticness" value="">
			</p>
			<p>
			<h2>
				<label for="danceability">Danceability (0 - 1)</label>
			</h2>
			<input id="danceability" name="danceability" value="">
			</p>
			<p>
			<h2>
				<label for="duration">Duration</label>
			</h2>
			<input id="duration" name="duration" value="">
			</p>
			<p>
			<h2>
				<label for="energy">Energy (0 - 1)</label>
			</h2>
			<input id="energy" name="energy" value="">
			</p>
			<p>
			<h2>
				<label for="explicit">Explicit (1: true, 0: false)</label>
			</h2>
			<input id="explicit" name="explicit" value="">
			</p>
			<p>
			<h2>
				<label for="instrumentalness">Instrumentalness</label>
			</h2>
			<input id="instrumentalness" name="instrumentalness" value="">
			</p>
			<p>
			<h2>
				<label for="songKey">Song Key</label>
			</h2>
			<input id="songKey" name="songKey" value="">
			</p>
			<p>
			<h2>
				<label for="liveness">Liveness (0 - 1)</label>
			</h2>
			<input id="liveness" name="liveness" value="">
			</p>
			<p>
			<h2>
				<label for="loudness">Loudness</label>
			</h2>
			<input id="loudness" name="loudness" value="">
			</p>
			<p>
			<h2>
				<label for="mode">Mode (1: true, 0: false)</label>
			</h2>
			<input id="mode" name="mode" value="">
			</p>
			<p>
			<h2>
				<label for="title">Title</label>
			</h2>
			<input id="title" name="title" value="">
			</p>
			<p>
			<h2>
				<label for="popularity">Popularity</label>
			</h2>
			<input id="popularity" name="popularity" value="">
			</p>
			<p>
			<h2>
				<label for="speechiness">Speechiness (0 - 1)</label>
			</h2>
			<input id="speechiness" name="speechiness" value="">
			</p>
			<p>
			<h2>
				<label for="tempo">Tempo</label>
			</h2>
			<input id="tempo" name="tempo" value="">
			</p>
			<p>
			<h2>
				<label for="valence">Valence (0 - 1)</label>
			</h2>
			<input id="valence" name="valence" value="">
			</p>
			<p>
			<h2>
				<label for="year">Year</label>
			</h2>
			<input id="year" name="year" value="">
			</p>
			<p>
				<input type="submit" class="btn btn-lg btn-primary">
			</p>
		</form>
		<br />
		<br />
		<p>
		<div class="alert alert-success" role="alert">
			<span id="successMessage"><b>${messages.success}</b></span>
		</div>
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