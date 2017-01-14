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
			<nav class="navbar navbar-light float-xs-left" style="padding-left: 0 !important">
			  <ul class="nav navbar-nav">
			    <li class="nav-item">
			      <a class="nav-link" href="elenco.html">elenco Auto</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="#">contatti</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="#">chi siamo</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="#">dove siamo</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">ricerca</a>
			    </li>
			  </ul>
			</nav>
			<div class="collapse float-xs-left" id="collapseExample" style="margin-top: 0.5rem">
			  	<form class="form-inline float-xs-left">
			      <input class="form-control" type="text" placeholder="Nome Auto">
			      <button class="btn btn-sm btn-outline-secondary" type="submit">Cerca</button>
			    </form>			
			</div>
			<a href="login.html" class="float-xs-right btn btn-outline-primary" style="margin-top: 0.5rem">Login Amministrazione</a>
			
	</header>
	<content>
		<div class="container" style="padding-top: 1rem; padding-bottom: 50px;">
			<div class=preventivo>
			<% String nome= (String) request.getAttribute("cognome");
			   int somma=(int) request.getAttribute("somma");%>
			   Gentile <%=nome %> il suo preventivo risulta essere <%=somma %> 
			
			
			</div>
		</div>
	</content>
</body>
</html>