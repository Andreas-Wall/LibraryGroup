<%@ include file= "userHeader.jsp" %>
<%@ include file= "librarianHeader.jsp" %>

<div class="container">

	<h1>Sign up for an account</h1>
	
	<div class="card-body">

		<%-- will select the form we use, update or insert --%>
		<c:if test="${ library != null }">
			<form action="update" method="post">
		</c:if>

		<c:if test="${ library == null }">
			<form action="insert" method="post">
		</c:if>
				
				
		<%-- hidden input we can use to pass in a value we want --%>
		<c:if test="${library != null}">
			<input type="hidden" name="id" value="<c:out value='${product.id}' />" />
		</c:if>
				
		<!-- item field -->
		<fieldset class="form-group">
					
			<label>Item</label>
			<input type="text" value="<c:out value='${ product.item }'/>" 
				class="form-control" name="item" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Quantity</label>
			<input type="number" value="<c:out value='${ product.qty }'/>" 
				class="form-control" name="qty" required>
					
		</fieldset>
				
		<fieldset class="form-group">
					
			<label>Description</label>
			<input type="text" value="<c:out value='${ product.description }'/>" 
				class="form-control" name="description" required>
					
		</fieldset>
				

		<button type="submit" class="btn btn-success">Save</button>

		</form>


		</div>
	
	

</div>

<%@ include file= "footer.jsp" %>