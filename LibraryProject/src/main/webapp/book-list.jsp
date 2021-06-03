<%@ include file= "userHeader.jsp" %>

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

<%@ include file= "footer.jsp" %>