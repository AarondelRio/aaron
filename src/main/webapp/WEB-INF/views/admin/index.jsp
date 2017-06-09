<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<base href="/formacion/"/>
	<title>BackOffice</title>
</head>
<body>
<h1>BackOffice</h1>

<a href="admin/consultar/-1"><i class="fa fa-plus" aria-hidden="true"></i>Nuevo</a>
<a href=""><i class="fa fa-arrow-left" aria-hidden="true"></i>Volver</a>
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
				<td>${c.codigo}</td>
				<td>
					<a href="admin/eliminar/${c.id}"><i class="fa fa-times" aria-hidden="true"></i></a>
					<a href="admin/consultar/${c.id}"><i class="fa fa-pencil" aria-hidden="true"></i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="admin/migrate">
	<i class="fa fa-database" aria-hidden="true"></i>
	Migrar
</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="resources/js/datatable.js"></script>
</body>
</html>