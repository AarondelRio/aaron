<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<base href="/formacion/"/>
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="resources/css/style.css" rel="stylesheet">	
	<title>BackOffice</title>
</head>
<body>
<nav class="navbar navbar-default">
 		<div class="container-fluid">
  			<div class="navbar-header">
  				<a href="admin/consultar/-1"><i class="fa fa-plus add" aria-hidden="true"></i> Nuevo</a>
     			<a href="admin/migrate"><span class="fa fa-database" aria-hidden="true"></span> Migrar</a>
			<a class="right" href=""><span class="fa fa-arrow-left" aria-hidden="true"></span> Volver</a>
   		</div>
 		</div>
</nav>

	
<div class="container">
	<table id="myTable">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Codigo</th>
				<th>Operaciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="c">
				<tr>
					<td>${c.id}</td>
					<td>${c.nombre}</td>
					<td><span class="badge">${c.codigo}</span></td>
					<td>
						<a  href="admin/eliminar/${c.id}"><i class="fa fa-times delete" aria-hidden="true"></i></a>
						<a href="admin/consultar/${c.id}"><i class="fa fa-pencil" aria-hidden="true"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="resources/js/datatable.js"></script>
</body>
</html>