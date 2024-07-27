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
				<td>semester Name :</td>
				<td><input type="text" name="semester"></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="action" value="addsemester"></td>
			</tr>
		</table>
	</form>

</body>
</html>