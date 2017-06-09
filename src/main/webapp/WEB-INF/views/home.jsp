<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<base href="/formacion/" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="resources/css/style.css" rel="stylesheet">	
	<title>Home</title>
</head>
<body>
<nav class="navbar navbar-default">
 		<div class="container-fluid">
  			<div class="navbar-header">
			  <a class="right"href="admin" ><span class="fa fa-lock" aria-hidden="true"></span> Login</a>
		</div>
 		</div>
</nav>

<div class="container">
	<div class="row">
			<div class="col-md-6 col-md-offset-3">
			<div class="input-group">
			<input type="text" id="autocomplete" class="form-control" size= 55 placeholder="Busque aqui su curso">
			<span class="input-group-addon">
						<i class="fa fa-search" aria-hidden="true"></i>
			</span>	
			</div>
		</div>
	</div>

<ul class="list-group">
	<c:forEach items="${cursos}" var="c">
  		<li class="list-group-item">${c.nombre}<span class="badge">${c.codigo}</span></li>
  	</c:forEach>
</ul>
	
	
    
	
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="resources/js/autocomplete.js"></script>
</body>
</html>
