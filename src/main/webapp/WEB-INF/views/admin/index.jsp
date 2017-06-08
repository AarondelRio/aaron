<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<base href="/formacion/"/>
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	<title>BackOffice</title>
</head>
<body>
<h1>BackOffice</h1>
<a href="">volver</a>
<a href="admin/consultar/-1">crear</a>
<a href="admin/migrate">MIGRAR</a>
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
					<a href="admin/eliminar/${c.id}">eliminar</a>
					<a href="admin/consultar/${c.id}">modificar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function(){
    $('#myTable').DataTable();
});
</script>
</body>
</html>