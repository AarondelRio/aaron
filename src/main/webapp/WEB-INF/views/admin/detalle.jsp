<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Detalle</title>
	<base href="/formacion/" />
</head>
<body>
<h1>Detalle</h1>

<a href="admin">volver</a>
<c:if test = "${curso.id!=-1}">
	<form:form action="admin/modificar" modelAttribute="curso">
	
		<form:hidden path="id"/><br>
						
		<form:label path="nombre">Nombre</form:label>
		<form:input path="nombre"/>
		<form:label path="codigo">codigo</form:label>
		<form:input path="codigo"/>
		

		<form:button type="submit">Modificar</form:button>
		
	</form:form>
</c:if>

<c:if test = "${curso.id==-1}">
	<form:form action="admin/crear" modelAttribute="curso">
	
		<form:hidden path="id"/><br>
						
		<form:label path="nombre">Nombre</form:label>
		<form:input path="nombre"/>
		<form:label path="codigo">codigo</form:label>
		<form:input path="codigo"/>
		
		
		<form:button type="submit">Crear</form:button>
	
	</form:form>
</c:if>
</body>
</html>