<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>

<body style="background:thistle;">


<c:if test = "${ patron != null }" > 
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  		<a class="navbar-brand" href="<%= request.getContextPath() %>/">User HomePage</a>
	  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    		<span class="navbar-toggler-icon"></span>
	  		</button>
	  		<div class="collapse navbar-collapse" id="navbarNav">
	  		
			    <ul class="navbar-nav">
			    
			      	<li class="nav-item">
			        	<a class="nav-link" href="<%= request.getContextPath() %>/bookCheckout">Checkout</a>
			      	</li>
			      	<li class="nav-item">
			        	<a class="nav-link" href="<%= request.getContextPath() %>/returnBooks">Return</a>
			      	</li>
			      	<li class="nav-item">
			        	<a class="nav-link" href="<%= request.getContextPath() %>/checkedOut">Checked Out Books</a>
			      	</li>
			      	<li class="nav-item">
			        	<a class="nav-link" href="<%= request.getContextPath() %>/listBooks">List of Books</a>
			      	</li>
			      	<li class="nav-item">
			        	<a class="nav-link" href="<%= request.getContextPath() %>/editUserInfo">Edit User Info</a>
			      	</li>

			      	
			    </ul>
			    
	  		</div>
		</nav>
	</header>
</c:if>

<c:if test = "${ librarian == null }" >

	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  		<a class="navbar-brand" href="<%= request.getContextPath() %>/">Librarian HomePage</a>
	  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    		<span class="navbar-toggler-icon"></span>
	  		</button>
	  		<div class="collapse navbar-collapse" id="navbarNav">
	  		
			    <ul class="navbar-nav">
			    
			      	<li class="nav-item">
			        	<a class="nav-link" href="<%= request.getContextPath() %>/addBook">Add Book</a>
			      	</li>
			      	<li class="nav-item">
			        	<a class="nav-link" href="<%= request.getContextPath() %>/listBooks">Edit Book</a>
			      	</li>
			      	<li class="nav-item">
			        	<a class="nav-link" href="<%= request.getContextPath() %>/listUsers">View Users</a>
			      	</li>
			      	<li class="nav-item">
			        	<a class="nav-link" href="<%= request.getContextPath() %>/editLibrarianInfo">Update Librarian Info</a>
			      	</li>
			    </ul>
			    
	  		</div>
		</nav>
	</header>
	
</c:if>
<c:if test = "${ patron == null && librarian == null }">
	<p>Please Sign up or Log in</p>
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="nav-link" href="<%= request.getContextPath() %>/login">Login</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<%= request.getContextPath() %>/signup.jsp">Sign Up</a>
		</li>
	</ul>
</c:if>