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

<c:forEach items="${cursos}" var="c">
			<ul>
				<li>ID ${c.id} NOMBRE ${c.nombre} CODIGO ${c.codigo}</li>
				
			</ul>
		</c:forEach>
</body>
</html>
