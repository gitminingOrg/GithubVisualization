<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<!-- Site Properities -->
<title>Fixed Menu Example - Semantic</title>

<link rel="stylesheet" type="text/css"
	href="../static/css/semantic.min.css">

<style type="text/css">
body {
	background-color: #FFFFFF;
}

.ui.menu .item img.logo {
	margin-right: 1.5em;
}

.main.container {
	margin-top: 7em;
}

.wireframe {
	margin-top: 2em;
}

.ui.footer.segment {
	margin: 5em 0em 0em;
	padding: 5em 0em;
}
</style>

</head>
<body>

	<div class="ui fixed inverted menu">
		<div class="ui container">
			<div href="#" class="header item">
				<img class="logo" src="assets/images/logo.png"> Project Name
			</div>
			<a href="#" class="item">Home</a> <a href="#"
				class="ui simple dropdown item"> Dropdown <i
				class="dropdown icon"></i>
				<div class="menu">
					<div class="item">Link Item</div>
					<div class="item">Link Item</div>
					<div class="divider"></div>
					<div class="header">Header Item</div>
					<div class="item">
						<i class="dropdown icon"></i> Sub Menu
						<div class="menu">
							<div class="item">Link Item</div>
							<div class="item">Link Item</div>
						</div>
					</div>
					<div class="item">Link Item</div>
				</div>
			</a>
		</div>
	</div>

	<div class="ui main text container">
		<h1 class="ui header">Semantic UI Fixed Template</h1>
		<p>This is a basic fixed menu template using fixed size
			containers.</p>
		<p>A text container is used for the main container, which is
			useful for single column layouts</p>
		<img class="wireframe"
			src="assets/images/wireframe/media-paragraph.png"> <img
			class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
	</div>

	<div class="ui inverted vertical footer segment">
		<div class="ui center aligned container">
			<div class="ui stackable inverted divided grid">
				<div class="three wide column">
					<h4 class="ui inverted header">Group 1</h4>
					<div class="ui inverted link list">
						<a href="#" class="item">Link One</a> <a href="#" class="item">Link
							Two</a> <a href="#" class="item">Link Three</a> <a href="#"
							class="item">Link Four</a>
					</div>
				</div>
				<div class="three wide column">
					<h4 class="ui inverted header">Group 2</h4>
					<div class="ui inverted link list">
						<a href="#" class="item">Link One</a> <a href="#" class="item">Link
							Two</a> <a href="#" class="item">Link Three</a> <a href="#"
							class="item">Link Four</a>
					</div>
				</div>
				<div class="three wide column">
					<h4 class="ui inverted header">Group 3</h4>
					<div class="ui inverted link list">
						<a href="#" class="item">Link One</a> <a href="#" class="item">Link
							Two</a> <a href="#" class="item">Link Three</a> <a href="#"
							class="item">Link Four</a>
					</div>
				</div>
				<div class="seven wide column">
					<h4 class="ui inverted header">Footer Header</h4>
					<p>Extra space for a call to action inside the footer that
						could help re-engage users.</p>
				</div>
			</div>
			<div class="ui inverted section divider"></div>
			<img src="assets/images/logo.png" class="ui centered mini image">
			<div class="ui horizontal inverted small divided link list">
				<a class="item" href="#">Site Map</a> <a class="item" href="#">Contact
					Us</a> <a class="item" href="#">Terms and Conditions</a> <a
					class="item" href="#">Privacy Policy</a>
			</div>
		</div>
	</div>
</body>

</html>
