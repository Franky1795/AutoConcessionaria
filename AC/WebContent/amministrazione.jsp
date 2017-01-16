<!DOCTYPE html>
<html lang="it">
<head>
	<%@ page import="java.util.*, bean.*" %>
	<% ArrayList <Auto> a = (ArrayList<Auto>) session.getAttribute("auto"); %>
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
		</div>
	</header>
	<content>
		<div class="container" style="padding-top: 1rem; padding-bottom: 50px;">
			<div class="card">
				<h3 class="card-header">Inserimento auto</h3>
				<div class="card-block">
					<form style="margin-top: 10px;" action="amministrazione" method="POST">
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
						    <input type="number" class="form-control" name="prezzo" placeholder="Es. 3000">
						</div>
						<label style="display: block;">Seleziona una foto</label>
						<label class="custom-file">
						    <input type="file" id="file" class="custom-file-input" name="immagine">
						    <span class="custom-file-control"></span>
						</label>
						<ul>
							<% 
							ArrayList<Accessorio> accessori = (ArrayList<Accessorio>) session.getAttribute("accessori");
							int i = 0;
							for(Accessorio acc : accessori){
							%>
							<li>
								<p style="margin-top: 10px"><%=acc.getNome() %></p>
								<label class="custom-control custom-radio">
									<input checked name="acc<%=i %>" type="radio" class="custom-control-input" value="0">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Non possiede</span>
								</label>
								<label class="custom-control custom-radio">
									<input name="acc<%=i %>" type="radio" class="custom-control-input" value="1">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Base</span>
								</label>
								<label class="custom-control custom-radio">
									<input name="acc<%=i %>" type="radio" class="custom-control-input" value="2">
									<span class="custom-control-indicator"></span>
									<span class="custom-control-description">Aggiuntivo</span>
								</label>
							</li>
							<%
							i++;
							} %>
						</ul>
						<input type="hidden" name="numAccessori" value="<%=i %>">
						<input type="hidden" name="action" value="write">
						<button type="submit" class="btn btn-primary">Inserisci</button>
					</form>
				</div>
			</div>
			<div class="card">
				<h3 class="card-header">Cancellazione auto</h3>
				<div class="card-block">
					<div class="form-group">
					    <label for="exampleSelect1">Seleziona l'auto da rimuovere</label>
					    <form action="amministrazione" method="post">
						    <select class="form-control" id="exampleSelect1" name="autoCancellare">
						    		<option value="-1">-</option>
									<%
									for(Auto auto : a){
									%>
										<option value="<%=auto.getCodice()%>"><%=auto.getNome() %></option>
										
									<%	
									}
									%>
						    </select>
						    <input type="hidden" name="action" value="delete">
							<button type="submit" class="btn btn-primary">Elimina</button>
					    </form>
					  </div>
				</div>
			</div>
		</div>
	</content>
</body>
</html>