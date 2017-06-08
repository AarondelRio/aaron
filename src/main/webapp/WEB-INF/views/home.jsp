<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<base href="/formacion/" />
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="admin">Backoffice</a>

<form class="navbar-form navbar-left">
       <div class="input-group">
       <label for="buscadorCurso" class="input-group-addon">Buscar<span class="glyphicon glyphicon-search"></span></label>
         <input type="text" id="autocomplete" class="form-control" size= 55 placeholder="Busque aqui su curso">
         
       </div>
</form>

<c:forEach items="${cursos}" var="c">
	<ul>
		<li>ID ${c.id} NOMBRE ${c.nombre} CODIGO ${c.codigo}</li>
		
	</ul>
</c:forEach>
		
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="resources/js/autocomplete.js"></script>
</body>
</html>
