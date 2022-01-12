<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Users</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - User Entry</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!--  add our html table here -->
			<input type="button" value="Add User"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
			<table>
				<tr>
					<th>Name</th>
					<th>User Type</th>
					<th>Age</th>
					<th>Interests</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="user" items="${users}">
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/user/showFormForUpdate">
						<c:param name="userId" value="${user.id}" />
					</c:url>
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${user.id}" />
					</c:url>
					<tr>
						<td>${user.name}</td>
						<td>${user.userType}</td>
						<td>${user.age}</td>
						<td>${user.interests}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							|
							<!-- display the delete link --> <a 
							onclick="if(!(confirm('R U sure you wanna delete that?'))) return false;"
							href="${deleteLink}">Delete</a>

						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









