<%@ include file= "header.jsp" %>

<div class="container">

	<h1>User List:</h1>
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
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="patron" items="${getAllPatrons}">
			
				<td>
					<c:out value="${ patron.patron_ID }" />
				</td>
				<td>
					<c:out value="${ patron.first_name }" />
				</td>
				<td>
					<c:out value="${ user.last_name }" />
				</td>
				<td>
					<c:out value="${ patron.username }" />
				</td>
				<td>
					<c:out value="${ user.account_frozen }" />
				</td>
				<td>
					<a href="edit?id=<c:out value='${ user.id }' />">
						<button class="btn btn-primary">Approve</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="delete?id=<c:out value='${ user.id }' />">
						<button class="btn btn-danger">Decline</button>
					</a>
				</td>
			
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>