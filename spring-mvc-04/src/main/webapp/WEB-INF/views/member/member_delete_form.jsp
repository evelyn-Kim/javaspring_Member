<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 삭제</title>
</head>
<body>
	<h1>회원 정보 삭제</h1>
	<form action="member_delete_action" method="post">
   	회원아이디 : <input type="text" name="mid" value="${vo.mid}" readonly ="readonly"> <br>
   	비밀번호: <input type="password" name="mpwd"> <br>
   	<input type="submit" value="회 원 삭 제">
   	<input type="reset" value="재 작 성">
   	</form>
</body>
</html>