<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>显示所有用户数据</title>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#getUsers").click(function() {
					$.ajax({
						type: "post",
						url: "/mySpringMVC/findUser",
						dataType: "json",
						success: function(resultData) {
							console.log(resultData);
							$("#myTable").html("");
							var content = "";
							$.each(resultData, function(i, data) {
								content = "<tr>" +
									"<td>" + (i + 1) + "</td>" +
									"<td>" + data.username + "</td>" +
									"<td>" + data.age + "</td>" +
									"<td>" + data.birthday + "</td>" + "</tr>";
								$("#myTable").append(content);
							});
						},
						error: function() {
							alert("hhh");
						}
					});
				});
			})
		</script>
	</head>

	<body>
		<button id="getUsers">显示所有用户数据</button>
		<br>
		<br>
		<div id="showUser">
			<table border="1" style="width: 700px;">
				<thead>
					<tr>
						<th>序号</th>
						<th>用户名</th>
						<th>年龄</th>
						<th>出生日期</th>
					</tr>
				</thead>

				<tbody id="myTable">
					<tr>
						<th>序号</th>
						<th>用户名</th>
						<th>年龄</th>
						<th>出生日期</th>
					</tr>
				</tbody>
			</table>
		</div>
	</body>

</html>