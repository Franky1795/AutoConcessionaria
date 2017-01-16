<!DOCTYPE html>
<html><head>
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
			<%if(session.getAttribute("admin") != null){ %>
			<a href="amministrazione.jsp" class="float-xs-right btn btn-outline-primary" style="margin-top: 0.5rem">Amministrazione</a>
			<%}else{ %>
			<a href="login.jsp" class="float-xs-right btn btn-outline-primary" style="margin-top: 0.5rem">Login Amministrazione</a>
			<%} %>
		</div>
	</header>
	<content>
		<div class="container" style="padding-top: 1rem; padding-bottom: 50px;">
			<%
			if(request.getAttribute("ris") != null){
			boolean ris = (boolean) request.getAttribute("ris");
				if(ris){ %>
			<div class="alert alert-success" role="alert" style="text-align:center; letter-spacing: 1px;">
			  	<strong>Ottimo!</strong> L'operazione è andata a buon fine.
			</div>
				<%
				}
				else{%>
			<div class="alert alert-danger" role="alert" style="text-align:center; letter-spacing: 1px;">
  				<strong></strong>Si è verificato un errore. Riprova.
			</div>
			<%
					}
				}
				else{
			%>
			<div class="preventivo">
					<div class="alert alert-info" role="alert">
 						<strong>Ottimo!</strong> Operazione riuscita. Ecco il suo preventivo.
					</div>
					<%
					String nome = (String) request.getAttribute("nome");
					String cognome = (String) request.getAttribute("cognome");
					String cf = (String) request.getAttribute("cf");
					String email = (String) request.getAttribute("email");
					String auto = (String) request.getAttribute("auto");
					int somma = (int) request.getAttribute("somma");
					%>
					Nome: <%=nome %><br>
					Cognome: <%=cognome %><br>
					Codice Fiscale: <%=cf %><br>
					E-mail: <%=email %><br><br>
					
					Auto: <%=auto %><br><br>
					
					Totale: <%=somma %>&euro;<br>
			
			</div>
			<%} %>
		</div>
	</content>

</body></html>