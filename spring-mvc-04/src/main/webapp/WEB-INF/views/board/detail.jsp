<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기(detail.jsp)</title>
</head>
<body>
	<h1>게시물 상세보기</h1>
   	게시물 번호: ${vo.no} <br>
   	게시물 제목: ${vo.title} <br>
   	게시물 저자: ${vo.writer} <br>
   	게시물 작성일: ${vo.regdate} <br>
   	게시물 내용: <pre>${vo.content}</pre>
   	
   	<h3><a href="../">게시판 홈</a></h3>
   	<h3><a href="update?no=${vo.no}">게시물 수정폼</a></h3>
   	<h3><a href="delete?no=${vo.no}">게시물 삭제폼</a></h3>
	<h3><a href="list">게시판 목록</a></h3>
</body>
</html>