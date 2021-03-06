<!DOCTYPE html>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="./css/bootstrap.css" >
	<link type="text/css" rel="stylesheet" href="./css/style.css" >
	<link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Auto Concessionaria</title>
</head>
<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="./javascript/bootstrap.js"></script>
	<script src="./javascript/bootstrap.min.js"></script>
	<header class="header">
		<div class="container">
			<nav class="navbar navbar-light float-xs-left" style="padding-left: 0">
			  <ul class="nav navbar-nav">
			  	<li class="nav-item">
			      <a class="nav-link" href="index.html">Home page</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="auto?action=readall">elenco Auto</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">ricerca</a>
			    </li>
			  </ul>
			</nav>
			<div class="collapse float-xs-left" id="collapseExample" style="margin-top: 0.5rem">
			  	<form class="form-inline float-xs-left">
			      <input class="form-control" type="text" placeholder="Nome Auto">
			      <button class="btn btn-sm align-middle btn-outline-secondary" type="submit">Cerca</button>
			    </form>			
			</div>
			<a href="login.jsp" class="float-xs-right btn btn-outline-primary" style="margin-top: 0.5rem">Login Amministrazione</a>
		</div>
	</header>
	<content>
		<div class="container" style="padding-top: 1rem; padding-bottom: 50px;">
			<%
			if(request.getAttribute("errore") != null){
			%>
				<div class="alert alert-danger" role="alert" style="text-align:center; letter-spacing: 1px;">
				  	<strong>Attenzione!</strong> I dati inseriti sono errati. 
				</div>
				<%
				}%>
			<div class="card">
				<h3 class="card-header">Login</h3>
				<div class="card-block">
					<form style="margin-top: 10px;" action="amministrazione" method="POST">
						<div class="form-group">
						    <label style="float: left;">Username</label>
						    <input type="text" class="form-control" name="username" placeholder="Es. Fra123">
						</div>
						<div class="form-group">
						    <label>Password</label>
						    <input type="password" class="form-control" name="password" placeholder="Inserisci la password">
						</div>
						<input type="hidden" name="action" value="login">
						<button type="submit" class="btn btn-primary">Login</button>
					</form>
				</div>
			</div>
		</div>
	</content>
</body>
</html>