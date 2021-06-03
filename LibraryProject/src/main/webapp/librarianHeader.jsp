<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Librarian Page</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>

<body>

<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="<%= request.getContextPath() %>/">Librarian HomePage</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarNav">
  		
		    <ul class="navbar-nav">
		    
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%= request.getContextPath() %>/list">Add Book</a>
		      	</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%= request.getContextPath() %>/new">Edit Book</a>
		      	</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%= request.getContextPath() %>/list">View Users</a>
		      	</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%= request.getContextPath() %>/new">Update Librarian Info</a>
		      	</li>
		      	
		    </ul>
		    
  		</div>
	</nav>
</header>