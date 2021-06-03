
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
	​		<div class="form-group">
				<label for="user-email">Email</label>
				<input type="email" id="user-email" name="user-email" class="form-control"/>
			</div>			
			<div class="form-group">
				<label for="pw">Password</label>
				<input type="password" id="pw" name="pw" class="form-control"/>
			</div>			
			<input type="submit" value="Login" class="btn btn-primary"/>
​		</form>
	</div>

<%@ include file= "footer.jsp" %>