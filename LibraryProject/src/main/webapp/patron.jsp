<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">

	<h1>Book List</h1>
	<br>
	<br>

	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>#</th>

				<th>Title</th>
				<th>Description</th>
				<th>Rented</th>
				<th>Added_to_library</th>

				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>

			<c:forEach var="Book" items="${allBooks}">
			
				<td>
					<c:out value="${ Book.isbn }" />
				</td>
				<td>
					<c:out value="${ Book.title }" />
				</td>
				<td>
					<c:out value="${ Book.descr }" />
				</td>
				<td>
					<c:out value="${ Book.rented }" />
				</td>
				<td>
					<c:out value="${ Book.added_to_library }" />

				</td>
				<td>
					<a href="edit?id=<c:out value='${ product.id }' />">
						<button class="btn btn-primary">Edit</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="delete?id=<c:out value='${ product.id }' />">
						<button class="btn btn-danger">Delete</button>
					</a>
				</td>

				<br>

			
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

</body>
</html>