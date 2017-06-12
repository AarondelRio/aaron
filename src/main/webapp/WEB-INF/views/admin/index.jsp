<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<base href="/formacion/"/>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	
	<link href="resources/css/style.css" rel="stylesheet">	
	<title>BackOffice</title>
</head>
<body>

<div class="container">

<nav class="navbar navbar-default">
 		<div class="container-fluid">
  			<div class="navbar-header">
  				<a href="admin/consultar/-1"><i class="fa fa-plus add" aria-hidden="true"></i> Nuevo</a>
     			<a data-toggle="modal" href="#modal-migrate"><span class="fa fa-database" aria-hidden="true"></span> Migrar</a>
			<a class="right" href="logout"><span class="fa fa-sign-out" aria-hidden="true"></span> Logout</a>
   		</div>
 		</div>
</nav>

	<c:if test = "${msg!=null}">
		<div class="alert alert-${msg.type}" role="alert">
				${msg.msg}
		</div>
	</c:if>
	
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
						<a href="admin/eliminar/${c.id}"><span class="fa fa-times delete" aria-hidden="true"></span></a>
						<a href="admin/consultar/${c.id}"><span class="fa fa-pencil" aria-hidden="true"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- Modal Migrar -->
	<div id="modal-migrate" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Excel a SQL</h4>
				</div>
				<div class="modal-body">
					<p>Seguro que desea migrar el archivo?</p> 
					<p>Asegurese de que se encuentra en <b>C:\</b> con el nombre <b>cursos.csv</b></p>		
					<p>Este proceso puede tardar varios segundos, por favor espere..</p>		
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal" onclick="location.href='admin/migrate'">Migrar</button>
					<button type="button" class="btn btn-info" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>
	
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/js/datatable.js"></script>
</body>
</html>