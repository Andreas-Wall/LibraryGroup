<%@ include file= "header.jsp" %>


<div class="container">

	<h1>Sign up for an account</h1>
	
	<div class="card-body">


		<form action="addUser" method="post">

	
		<%-- hidden input we can use to pass in a value we want --%>
		<c:if test="${patron != null}">
			<input type="hidden" name="id" value="<c:out value='${patron.id}' />" />
		</c:if>
				
		<!-- item field -->
		<fieldset class="form-group">
					
			<label>First Name</label>
			<input type="text" value="<c:out value='${ patron.first_name }'/>" 
				class="form-control" name="first_name" required>
					
		</fieldset>
		
		<fieldset class="form-group">
					
			<label>Last Name</label>
			<input type="text" value="<c:out value='${ patron.last_name }'/>" 
				class="form-control" name="last_name" required>
					
		</fieldset>
				
				
		<fieldset class="form-group">
					
			<label>Username</label>
			<input type="text" value="<c:out value='${ patron.username }'/>" 
				class="form-control" name="username" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Password</label>
			<input type="password" value="<c:out value='${ patron.password }'/>" 
				class="form-control" name="password" required>
					
		</fieldset>

		<button type="submit" class="btn btn-success">Sign Up</button>

		</form>


		</div>
	
	

</div>

<%@ include file= "footer.jsp" %>