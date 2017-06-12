<!doctype html>
<html lang="es">
<head>
	<base href="/formacion/" />
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

	<link href="resources/css/style.css" rel="stylesheet">	
	<meta charset="utf-8">
	<title>Error</title>
</head>
<div class="container">

<nav class="navbar navbar-default">
 		<div class="container-fluid">
  			<div class="navbar-header">
  			<a class="right" href=""><span class="fa fa-arrow-left" aria-hidden="true"></span> Volver</a>
   		</div>
 		</div>
</nav>
		
<div class="alert alert-warning" role="alert">
	<p>El usuario o el Password son incorrectos</p>
</div>		

<form action="login" method="post" class="form-horizontal">
	
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
	
		<label for="usuario">Usuario</label>
		<input type="text" id="usuario" name="usuario" class="form-control">
		
		<label for="clave">Password</label>
		<input type="password" id="clave" name="clave" class="form-control">
		
		<br>
		<input type="submit" value="login">
		</div>
	</div>
</form>
<img src="http://i.imgur.com/j51uHm1.gif">
</div>
</body>
</html>