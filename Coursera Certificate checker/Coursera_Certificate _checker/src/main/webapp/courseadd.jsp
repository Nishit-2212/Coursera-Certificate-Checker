<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="AdminController" method="post">
		<table>
			<tr>
				<td>course Name :</td>
				<td><input type="text" name="course"></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="action" value="addcourse"></td>
			</tr>
		</table>
	</form>

</body>
</html>