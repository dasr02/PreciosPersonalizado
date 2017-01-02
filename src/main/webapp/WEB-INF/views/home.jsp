<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<spring:url value="/resources/bootstrap/css/bootstrap.css.map" var="bootstrap" />
			<spring:url value="/resources/bootstrap/css/bootstrap.css" var="bootstrap1" />
			<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrap2" />
			<spring:url value="/resources/bootstrap/css/bootstrap.min.css.map" var="bootstrap3" />
			<spring:url value="/resources/bootstrap/fonts/glyphicons-halflings-regular.eot" var="bootstrap4" />
			<spring:url value="/resources/bootstrap/fonts/glyphicons-halflings-regular.svg" var="bootstrap5" />
			<spring:url value="/resources/bootstrap/fonts/glyphicons-halflings-regular.ttf" var="bootstrap6" />
			<spring:url value="/resources/bootstrap/fonts/glyphicons-halflings-regular.woff" var="bootstrap7" />
			<spring:url value="/resources/bootstrap/fonts/glyphicons-halflings-regular.woff2" var="bootstrap8" />
			<spring:url value="/resources/bootstrap/js/bootstrap.js" var="bootstrap9" />
			<spring:url value="/resources/bootstrap/js/bootstrap.min.js" var="bootstrap10" />
			<spring:url value="/resources/bootstrap/js/npm.js" var="bootstrap11" />
			<spring:url value="/resources/js/main.js" var="crunchifyJS" />
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
			<link href="${bootstrap}" rel="stylesheet" />
			<link href="${bootstrap1}" rel="stylesheet" />
			<link href="${bootstrap2}" rel="stylesheet" />
			<link href="${bootstrap3}" rel="stylesheet" />
			<script src="${bootstrap9}"></script>
			<script src="${bootstrap10}"></script>
			<script src="${bootstrap11}"></script>
			<script src="${crunchifyJS}"></script>
        <title>Contact Manager Home</title>
    </head>
    <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Alfredito de Tarifa</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">Cargar Archivo</a></li>
            <li><a href="#contact">Genera Archivo</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <br>   
    <br>
    <br>   
    <br>   
    <br>   
    <br> 
    	<div class="table-responsive"> 
       <table style="width:50%" align="center" class = "table table-striped">
		  <c:forEach var="contact" items="${listContact}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${contact.flgActivo}</td>
                    <td>${contact.idUsuarioCreador}</td>
                    <td>${contact.idUsuarioModificador}</td>
                    <td>${contact.pkGmysSlwUsuario}</td>
                    <td>
                        <a href="/editContact?id=${contact.pkGmysSlwUsuario}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deleteContact?id=${contact.pkGmysSlwUsuario}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
		</table>
		</div>
    
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
