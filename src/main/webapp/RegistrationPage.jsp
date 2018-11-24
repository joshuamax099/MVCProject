<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		<table>
			<tr>
				<td>Enter Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Enter Age:</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>Enter User Name:</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="text" name="cpass"></td>
			</tr>
			<tr>
				<td>Enter Aadhaar Details:</td>
				<td><input type="text" name="acard"></td>
			</tr>
			<tr>
				<td>Enter Pan Card Details:</td>
				<td><input type="text" name="pcard"></td>
			</tr>
			<tr>
				<td>Enter Branch Details:</td>
				<td><input type="text" name="bdetail"></td>
			</tr>
			<tr>
				<td>Enter Account Type:</td>
				<td><select name="acctype">
						<option value="savings">Savings Account</option>
						<option value="current">Current Account</option>
						<option value="both">Savings and Current Account</option>
				</select></td>
			</tr>
			<tr>
				<td>Enter Address:</td>
				<td><input type="text" name="adetail"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>