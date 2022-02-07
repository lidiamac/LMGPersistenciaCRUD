<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuário</title>
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


<div class="container">

<h1 class="mb-4 text-center">Lista de usuários</h1>

<a href="adicionar.jsp"><button type="submit" class="btn btn-outline-secondary mb-5">Adicionar usuário</button></a>

<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nome</th>
      <th scope="col">Email</th>
      <th scope="col">País</th>
      <th scope="col" class="text-center">Ações</th>
    </tr>
  </thead>
  

  <c:forEach items="${usuario}" var="user" varStatus="i">
	    <tr>  
	      <th scope="row">${user.id}</th>
	      <td>${user.nome}</td>
	      <td>${user.email}</td>
	      <td>${user.pais}</td>
	      <td class="text-center">
	      	<a href="?id=${i.index}&opcao=1">Alterar</a>
	      	<a href="?id=${i.index}&opcao=0">Remover</a>
	      </td>
	    </tr>
    </c:forEach>  

</table>
</div>

</body>
</html>