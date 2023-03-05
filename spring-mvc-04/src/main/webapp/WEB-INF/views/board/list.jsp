<%@page import="java.util.List" %>
<%@page import="com.hwkim.mvc04.vo.MemberVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록(list.jsp)</title>
</head>
<body>
	<h1>회원 목록</h1>
	<h3>회원수 : ${boardList.size()}</h3>
	<table>
		<tr>
			<th>번호</th>
			<th>제 목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${boardList}" var="b">
		<tr>
			<td>${b.no}</td>
			<td><a href="detail?no=${b.no}">${b.title}</a></td>
			<td>${b.writer}</td>
			<td>${b.regdate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>