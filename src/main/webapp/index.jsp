<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insertData" method="post">
		<table>
			<tr>
				<td>Enter Name</td>
				<td><input type="text" name="name" placeholder="Enter Name">
				<span><%
					if(request.getAttribute("name") == null){}
					else{
						out.print("Please Enter Proper Name");
					}
				%></span>
				</td>
			</tr>
			<tr>
				<td>Enter lastName</td>
				<td><input type="text" name="lastName" placeholder="Enter lastName">
					<span>
					<%
						if(request.getAttribute("lastName") == null){}
						else{
							out.print("Please Enter Proper LastName");
						}
					%>
				</span>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
	<a href="view">View Student</a>
</body>
</html>