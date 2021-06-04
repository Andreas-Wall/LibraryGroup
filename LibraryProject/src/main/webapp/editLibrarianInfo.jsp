<%@ include file= "header.jsp" %>
​
<div class="container">
​
	<h1>Librarian Update Form</h1>
	
	<div class="card-body">
​
		<%-- will select the form we use, update or insert --%>
		<c:if test="${ librarian != null }">
			<form action="update" method="post">
		</c:if>
​
		<c:if test="${ librarian == null }">
			<form action="insert" method="post">
		</c:if>
				
				
		<%-- hidden input we can use to pass in a value we want --%>
		<c:if test="${librarian != null}">
			<input type="hidden" name="id" value="<c:out value='${librarian.librarian_id}' />" />
		</c:if>
				
		<!-- item field -->
		<fieldset class="form-group">
					
			<label>Username</label>
			<input type="text" value="<c:out value='${ librarian.username }'/>" 
				class="form-control" name="item" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Password</label>
			<input type="password" value="<c:out value='${ librarian.password }'/>" 
				class="form-control" name="qty" required>
					
		</fieldset>
				
				
​
		<button type="submit" class="btn btn-success">Save</button>
​
		</form>
​
​
		</div>
	
	
​
</div>
​
<%@ include file= "footer.jsp" %>
















