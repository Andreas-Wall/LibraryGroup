<%@ include file= "header.jsp" %>

<div class="container">

	<h1>User List</h1>
	<br>
	<br>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>#</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Frozen</th>
				
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="patron" items="${allPatrons}">
			
				<td>
					<c:out value="${ patron.patron_id }" />
				</td>
				<td>
					<c:out value="${ patron.first_name }" />
				</td>
				<td>
					<c:out value="${ patron.last_name }" />
				</td>
				<td>
					<c:out value="${ patron.username }" />
				</td>
				<td>
					<c:out value="${ patron.account_frozen }" />
				</td>
				<td>
					<a href="edit?id=<c:out value='${ patron.patron_id }' />">
						<button class="btn btn-primary">Approve</button>
					</a>
				</td>
			
				<tr><td><br></td></tr>
			
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>