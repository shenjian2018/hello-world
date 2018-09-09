<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<h2>登陆界面</h2>

		<form action="/SSO-learn/sso/ssologin.action" method="post">
	      <table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" /></td>
				<td><input type="hidden" name="gotoURL" value="${gotoURL}"/></td>
			</tr>
	      </table>
		</form>
</body>
<script type="text/javascript">

</script>
</html>
