<!DOCTYPE html>
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
	<%@ page import="java.util.*, bean.Auto, bean.Accessorio "%>
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
				Auto auto = (Auto) request.getAttribute("auto");
			%>
			<div class="auto">
			
				<img src="./images/car.jpg" class="fotoAuto">
				<div class="testata">
					<h2 class="float-xs-left"><%=auto.getNome() %></h2>
					<button type="button" class="float-xs-right btn btn-success align-middle pulsanteAcquista">Acquista</button>
				</div>
				
				<p class="descrizioneAuto"><%=auto.getDescrizione()%></p>

			</div>
			<div class="accessori">
				<h3 style="border-bottom: 1px solid #0275d8">Accessori</h3>
				<% ArrayList<Accessorio> acc = auto.getListaAccessorio(); %>
				<ul>
					<%
						for(Accessorio a : acc){
							
							if(a.isBase()){
					%>
							<li><%=a.getNome()%></li>
					<%}	
					} %>
				</ul>
			</div>
			<form action="servizi" method="post">
				<div class="optional">
					<h3 style="border-bottom: 1px solid #0275d8">Optional</h3>
					<%
						for(Accessorio a : acc){
						
							if(!a.isBase()){
					%>
					<label class="custom-control custom-checkbox">
					  <input type="checkbox" name="aggiuntivi" class="custom-control-input" value="<%=a.getCosto()%>">
					  <span class="custom-control-indicator"></span>
					  <span class="custom-control-description"><%=a.getNome()%></span>
					</label>
					<%}
					} %>
				</div>
				<div class="preventivo">
					<h5>Seleziona gli optional e compila il form per richiedere il preventivo</h5>
					
						<div class="form-group">
							<label>Nome</label>
							<input type="text" class="form-control" name="nome" placeholder="Es. Francesco">
						</div>
					  	<div class="form-group">
					  		<label>Cognome</label>
					  	  	<input type="text" class="form-control" name="cognome" placeholder="Es. Rossi">
					 	 </div>
					 	<div class="form-group">
					  	  	<label>Codice Fiscale</label>
					  	  	<input maxlength="16" type="text" class="form-control" name="cf" placeholder="Inserisci codice fiscale">
					  	</div>
					  	<div class="form-group">
					  	  	<label>E-mail</label>
					  	  	<input  type="email" class="form-control" name="email" placeholder="Es. rossi@email.it">
					  	</div>
					  	<input type="hidden" name="nomeAuto" value= "<%=auto.getNome()%>" />
					  	<input type="hidden" name="prezzoAuto" value= "<%=auto.getPrezzo() %>" />
					  	<input type="hidden" name="action" value="preventivo">
					  	<button type="submit" class="btn btn-primary">Invia</button>
					    
				</div>
			</form>
			<div class="servizi">
				<div id="accordion" role="tablist" aria-multiselectable="true">
				    
				    <h5 class="mb-0">
				      <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				        	<div class="pulsanteAccordion">Noleggia Auto</div>
				      </a>
				    </h5> 
				    <div id="collapseOne" class="collapse" role="tabpanel" aria-labelledby="headingOne" aria-expanded="false">
				    	<form style="margin-top: 10px;" action="servizi" method="POST">
				    		<div class="form-group">
				    		    <label style="float: left;">Nome</label>
				    		    <input type="text" class="form-control" name="nome" placeholder="Es. Francesco">
				    		  </div>
				    		  <div class="form-group">
				    		    <label>Cognome</label>
				    		    <input type="text" class="form-control" name="cognome" placeholder="Es. Rossi">
				    		  </div>
				    		  <div class="form-group">
							    <label>Codice Fiscale</label>
							    <input maxlength="16" type="text" class="form-control" name="cf" placeholder="Inserisci codice fiscale">
							  </div>
				    		  <div class="form-group">
			    		  		<label>Data Inizio</label>
			    		  	    <input class="form-control" type="date" name="dataInizio" placeholder="gg/mm/aaaa" id="example-date-input">
			    		  	  </div>
			    		  	  <div class="form-group">
			    		  		<label>Data Fine</label>
			    		  	    <input class="form-control" type="date" name="dataFine" placeholder="gg/mm/aaaa" id="example-date-input">
			    		  	  </div>
							  <div class="form-group">
				    		    <label>E-mail</label>
				    		    <input type="email" class="form-control" name="email" placeholder="Es. rossi@mail.it">
				    		  </div>
				    		  <input type="hidden" name="action" value="noleggio">
							  <input type="hidden" name="codiceAuto" value="<%=auto.getCodice()%>">
				    		  <button type="submit" class="btn btn-primary">Invia</button>
				    	</form>
				    </div>
					
					<h5 class="mb-0">
				      <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseOne">
				        	<div class="pulsanteAccordion">Prenota TestDrive</div>
				      </a>
				    </h5>
				    <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingOne" aria-expanded="false">
				    	<form style="margin-top: 10px;" action="servizi" method="POST">
				    		<div class="form-group">
				    		    <label style="float: left;">Nome</label>
				    		    <input type="text" class="form-control" name="nome" placeholder="Es. Francesco">
				    		    
			    		  	</div>
			    		  	<div class="form-group">
			    		    	<label>Cognome</label>
			    		    	<input type="text" class="form-control" name="cognome" placeholder="Es. Rossi">
			    		  	</div>
			    		  	<div class="form-group">
			    		  		<label>Data</label>
			    		  	    <input class="form-control" type="date" name="data" value="12-10-1995" placeholder="gg/mm/aaaa" id="example-date-input">
			    		  	</div>
			    		  	<div class="form-group">
							   <label>Codice Fiscale</label>
							   <input maxlength="16" type="text" class="form-control" name="cf" placeholder="Inserisci codice fiscale">
							</div>
							<div class="form-group">
				    		    <label>E-mail</label>
				    		    <input type="email" class="form-control" name="email" placeholder="Es. rossi@mail.it">
				    		</div>
							<input type="hidden" name="action" value="testdrive">
							<input type="hidden" name="codiceAuto" value="<%=auto.getCodice() %>">
			    		  	<button type="submit" class="btn btn-primary">Invia</button>
				    	</form>
				    </div>

				    <h5 class="mb-0">
				      <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="true" aria-controls="collapseOne">
				        	<div class="pulsanteAccordion">Iscriviti alla Newsletter</div>
				      </a>
				    </h5>
				    <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingOne" aria-expanded="false">
				    	<form style="margin-top: 10px;" action="servizi" method="POST">
				    		<div class="form-group">
				    		    <label style="float: left;">Nome</label>
				    		    <input type="text" class="form-control" name="nome" placeholder="Es. Francesco">
				    		</div>
				    		<div class="form-group">
				    		    <label>Cognome</label>
				    		    <input type="text" class="form-control" name="cognome" placeholder="Es. Rossi">
				    		</div>
				    		<div class="form-group">
				    		    <label>E-mail</label>
				    		    <input type="email" class="form-control" name="email" placeholder="Es. rossi@mail.it">
				    		</div>
				    		<input type="hidden" name="action" value="newsletter">
							<input type="hidden" name="codiceAuto" value="0">
				    		<button type="submit" class="btn btn-primary">Iscriviti</button>
				    	</form>
				    </div>
				  
				</div>

			</div>
		</div>
	</content>
</body>
</html>