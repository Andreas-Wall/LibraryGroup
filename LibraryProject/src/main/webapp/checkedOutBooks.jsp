<%@ include file= "header.jsp" %>

<div class="container">

	<h1>List of Checked Out Books</h1>
	<br>
	<br>

	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>ISBN Number</th>
				<th>Title</th>
				<th>Description</th>
				<th>Rented</th>
				<th>Added_to_library</th>
			</tr>
		</thead>
		
		<tbody>

			<c:forEach var="book" items="${ checkOutBooks }">
			
				<td>
					<c:out value="${ book.isbn }" />
				</td>
				<td>
					<c:out value="${ book.title }" />
				</td>
				<td>
					<c:out value="${ book.descr }" />
				</td>
				<td>
					<c:out value="${ book.rented }" />
				</td>
				<td>
					<c:out value="${ book.added_to_library }" />
				</td>

				<br>

			
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>