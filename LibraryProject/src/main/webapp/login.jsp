
<%@ include file= "header.jsp" %>


<div class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-4">Login Page</h1>
				<p class="lead">Welcome! Please login below. Make sure to fill
					in all fields.</p>
			</div>
		</div>				
​		<form action="LibraryServlet" method="GET">
			<fieldset>
			<legend>User Type</legend>
				<input type="radio" id="patron" name="user-type" value="patron"> Patron<br>
				<input type="radio" id="librarian" name="user-type" value="librarian"> Librarian<br>
			</fieldset>
			<br>
	​		<div class="form-group">
				<label for="username">Username</label>
				<input type="text" id="username" name="username" class="form-control"/>
			</div>
			<br>		
			<div class="form-group">
				<label for="pw">Password</label>
				<input type="password" id="pw" name="pw" class="form-control"/>
			</div>
			<br>		
			<input type="submit" value="Login" class="btn btn-primary"/>
​		</form>
	</div>

<%@ include file= "footer.jsp" %>