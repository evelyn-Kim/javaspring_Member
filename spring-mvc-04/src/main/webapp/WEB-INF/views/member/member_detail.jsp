<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
</head>
<body>
	<h1>회원정보 상세보기</h1>
	회원id : ${vo.mid} <br>
	회원이름 : ${vo.mname} <br>
	회원소개 : ${vo.mintro} <br>
	<h3><a href=".\">홈</a></h3>
	<h3><a href="member_list">회원 목록</a></h3>
	<h3><a href="member_update_form?mid=${vo.mid}">회원 정보 수정</a></h3>
	<h3><a href="member_delete_form?mid=${vo.mid}">회원 정보 삭제</a></h3>
</body>
</html>