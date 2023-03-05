<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="member_update_action" method="post">
   	회원아이디 : <input type="text" name="mid" value="${vo.mid}" readonly ="readonly"> <br>
   	회원이름 : <input type="text" name="mname" value="${vo.mname}"> <br>
   	비밀번호: <input type="password" name="mpwd" value="${vo.mpwd}"> <br>
   	회원소개 : <textarea rows="3" cols="40" name="mintro">${vo.mintro}</textarea> <br>
   	<input type="submit" value="정 보 수 정">
   	<input type="reset" value="재 작 성">
   	</form>
</body>
</html>