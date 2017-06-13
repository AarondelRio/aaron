<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<base href="/formacion/" />
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

	<link href="resources/css/style.css" rel="stylesheet">	
	<title>Detalle</title>	
</head>
<body>

<div class="container">

<nav class="navbar navbar-default">
 	<div class="container-fluid">
  		<div class="navbar-header">
     		<a class="right" href="admin"><span class="fa fa-arrow-left" aria-hidden="true"></span> Volver</a>
   		</div>
 	</div>
</nav>

	<c:if test = "${curso.id!=-1}">
		<form:form action="admin/modificar" modelAttribute="curso" class="form-horizontal" method="post">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<form:hidden path="id"/><br>					
					<form:label path="nombre">Nombre&nbsp&nbsp</form:label><form:errors path="nombre" cssStyle="color:red;"/>					
					<form:input class="form-control" path="nombre"/>
					

					<form:label path="codigo">Codigo&nbsp&nbsp</form:label><form:errors path="codigo" cssStyle="color:red;"/>					
					<form:input class="form-control" path="codigo"/>
					
					

					<form:button class="btn btn-default" type="submit"><span class="fa fa-check" aria-hidden="true"></span></form:button>
				</div>
			</div>
		</form:form>
	</c:if>
	
	<c:if test = "${curso.id==-1}">
		<form:form action="admin/crear" modelAttribute="curso" class="form-horizontal" method="post">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<form:hidden path="id"/><br>				
					<form:label path="nombre">Nombre&nbsp&nbsp</form:label><form:errors path="nombre" cssStyle="color:red;"/>
					<form:input class="form-control" path="nombre"/>
					
					
					<form:label path="codigo">Codigo&nbsp&nbsp</form:label><form:errors path="codigo" cssStyle="color:red;"/>
					<form:input class="form-control" path="codigo"/>
					

					<form:button class="btn btn-default" type="submit"><span class="fa fa-check" aria-hidden="true"></span></form:button>
				</div>
			</div>
		</form:form>
	</c:if>
	
</div>
</body>
</html>