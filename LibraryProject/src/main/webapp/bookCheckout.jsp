<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Book Checkout</h1>
	<br>
	<br>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>ISBN Number</th>
				<th>Title</th>
				<th>Description</th>
				<th>Rented</th>
				<th>Added to Library</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="book" items="${ getAllBooks }">
			
				<td>
					<c:out value="${ book.isbn }" />
				</td>
				<td>
					<c:out value="${ book.title }" />
				</td>
				<td>
					<c:out value="${ book.description }" />
				</td>
				<td>
					<c:out value="${ book.rented }" />
				</td>
				<td>
					<c:out value="${ book.added_to_library }" />
				</td>
				<td>
					<a href="edit?id=<c:out value='${ book.checkout_id }' />">
						<button class="btn btn-primary">Checkout</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>