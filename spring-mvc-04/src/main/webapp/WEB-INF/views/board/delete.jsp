<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 삭제(delete.jsp)</title>
</head>
<body>
	<h1>게시물 삭제</h1>
	
	<form action="delete" method="post">
	게시물 번호: ${vo.no} <br>
	게시물 작성일: ${vo.regdate} <br>
	<input type="hidden" name="no" value="${vo.no}">
	게시물 제목: ${vo.title} <br>
   	<input type="hidden" name="title" value="${vo.title}">
   	게시물 저자: ${vo.writer} <br>
   	<input type="hidden" name="writer" value="${vo.writer}">
   	게시물 내용:  <br>
   	<textarea rows="3" cols="50" name="content">${vo.content}</textarea> <br>
   	게시물 암호: <input type="password" name="passwd" > <br>
   	<input type="submit" value="글 삭 제">
   	<input type="reset" value="재 작 성">
   	</form>
   	
   	<h3><a href="./">게시판 홈</a></h3>
	<h3><a href="list">게시판 목록</a></h3>
</body>
</html>