<!DOCTYPE html>
<html lang="it">
<head>
	<%@ page import="java.util.*, bean.Auto" %>
	<% ArrayList <Auto> a = (ArrayList<Auto>) request.getAttribute("auto"); %>
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
			<div class="card">
				<h3 class="card-header">Inserimento auto</h3>
				<div class="card-block">
					<form style="margin-top: 10px;" action="servizi" method="POST">
						<div class="form-group">
						    <label style="float: left;">Nome auto</label>
						    <input type="text" class="form-control" name="nomeAuto" placeholder="Es. Fra123">
						</div>
						<div class="form-group">
						    <label>Descrizione</label>
						    <textarea class="form-control" name="descrizione" placeholder="Inserisci una descrizione"></textarea>
						</div>
						<div class="form-group">
						    <label>Costo</label>
						    <input type="number" class="form-control" name="descrizione" placeholder="Es. 3000">
						</div>
						<label style="display: block;">Seleziona una foto</label>
						<label class="custom-file">
						    <input type="file" id="file" class="custom-file-input">
						    <span class="custom-file-control"></span>
						</label>
						<ul>
							<li>
								<p style="margin-top: 10px">Accessorio 1</p>
								<label class="custom-control custom-radio">
									<input checked name="acc1" type="radio" class="custom-control-input">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Non possiede</span>
								</label>
								<label class="custom-control custom-radio">
									<input name="acc1" type="radio" class="custom-control-input">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Base</span>
								</label>
								<label class="custom-control custom-radio">
									<input name="acc1" type="radio" class="custom-control-input">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Aggiuntivo</span>
								</label>
							</li>
							<li>
								<p style="margin-top: 10px">Accessorio 2</p>
								<label class="custom-control custom-radio">
									<input checked name="acc2" type="radio" class="custom-control-input">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Non possiede</span>
								</label>
								<label class="custom-control custom-radio">
									<input name="acc2" type="radio" class="custom-control-input">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Base</span>
								</label>
								<label class="custom-control custom-radio">
									<input name="acc2" type="radio" class="custom-control-input">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Aggiuntivo</span>
								</label>
							</li>
						</ul>

					</form>
				</div>
			</div>
			<div class="card">
				<h3 class="card-header">Cancellazione auto</h3>
				<div class="card-block">
					<div class="form-group">
					    <label for="exampleSelect1">Seleziona l'auto da rimuovere</label>
					    <select class="form-control" id="exampleSelect1">
					    		<option>-</option>
								<%
								for(Auto auto : a){
								%>
									<option value="<%=auto.getCodice()%>"><%=auto.getNome() %></option>
									
								<%	
								}
								%>


					    </select>
					  </div>
				</div>
			</div>
		</div>
	</content>
</body>
</html>