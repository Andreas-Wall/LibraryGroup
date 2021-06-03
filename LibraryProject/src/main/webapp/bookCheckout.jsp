<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Book Checkout:</h1>
	<br>
	<br>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Rented Status</th>
				<th>Date Added</th>
				<th>ISBN</th>
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="book" items="${getAllBooks}">
			
				<td>
					<c:out value="${ book.checkout_ID }" />
				</td>
				<td>
					<c:out value="${ book.patron_id }" />
				</td>
				<td>
					<c:out value="${ book.isbn }" />
				</td>
				<td>
					<c:out value="${ book.checkout_date }" />
				</td>
				<td>
					<c:out value="${ book.due_date }" />
				</td>
				<td>
					<a href="edit?id=<c:out value='${ book.checkout_ID }' />">
						<button class="btn btn-primary">Checkout</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>