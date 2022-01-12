<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save User</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-user-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - User Entry</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save User</h3>
	
		<form:form action="saveUser" modelAttribute="user" method="POST">
		
			<table>
				<tbody>
					<tr>
						<td><label>name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>Age:</label></td>
						<td><form:input path="age" /></td>
					</tr>

					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/user/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










