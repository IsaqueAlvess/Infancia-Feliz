<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="index.css" media="screen" />
<title>HomePage</title>
</head>

<body link = "black" vlink = "black">
<br>
<div class="scrollmenu">
  <font color = "black">...............................................................</font>
  <a href = "cadastroDoador.jsp">Cadastrar Doador</a>
  <a href = "cadastroInstituicao.jsp">Cadastrar Instituição</a>
  <a href = "loginDoador.jsp">Login Doador</a>
  <a href = "loginCreche.jsp">Login Creche</a>
  <font color = "black">...............................................................</font>
</div>
<br>

<p align = "center"/><img src = "img/infanciaFeliz_marca.png" align = "middle" height = "300" width = "650"> 
<br>
<font color="#00FF00">${mensagem}</font>
<font color="#00FF00">${sucesso}</font>
<br><br><br>
<p align = "justify"/><font face = "verdana" size = "3">Nosso objetivo é facilitar as doações para creches 
carentes de Brasília.</font>

<p align = "justify"/><font face = "verdana" size = "3">Então se você é doador cadastre-se em 
<a href = "cadastroDoador.jsp"><i>Cadastrar Doador</i></a> e veja creches que precisam do que
você tem para doar.
</font>

<p align = "justify"/><font face = "verdana" size = "3">Se você é responsável por uma creche, cadastre-a em 
<a href = "cadastroInstituicao.jsp"><i>Cadastrar Instituição</i></a> e registre o que sua
instituição está necessitando.
</font>

</body>
</html>