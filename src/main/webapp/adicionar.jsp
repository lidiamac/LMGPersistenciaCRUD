<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Usuário</title>
<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-secondary bg-gradient mb-5">
  <div class="container-fluid">
    <a class="navbar-brand text-light" href="#">Raia Drogasil</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active text-light" aria-current="page" href="#">Usuário</a>
        </li>
      </ul>
    </div>
  </div>
</nav>


<div class="container w-50">
	<div class="border border-1 m-5 rounded-3">
	<h1 class="mb-4 text-start mt-5 ms-5">Adicionar usuário</h1>
	<input type="hidden" value="${id}" name="id">
	
	<form class="p-5" method="post" action="ServletPersistencia">
  <div class="mb-3">
    <label for="nome" class="form-label">Nome</label>
    <input type="text" class="form-control" value="${nome}" id="nome" name="nome" aria-describedby="emailHelp">
    
  </div>
  <div class="mb-3">
    <label for="email" class="form-label">Email</label>
    <input type="email" class="form-control" value="${email}" id="email" name="email" aria-describedby="emailHelp">
   
  </div>
  <div class="mb-3">
    <label for="pais" class="form-label">País</label>
    <input type="text" class="form-control" value="${pais}" id="pais" name="pais" aria-describedby="emailHelp">
  </div>
  <a href="index.jsp"><button type="submit" class="btn btn-secondary mb-5">Salvar</button></a>
</form>
	</div>
</div>
</body>
</html>