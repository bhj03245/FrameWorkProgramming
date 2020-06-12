<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>글 목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container">
	<h1>NetFlix 게시판</h1>
	<hr style="border: solid 5px grey;">
	
	<div>
	<%@include file="nav.jsp" %>
	</div>
	<hr style="border: solid 5px grey;">
	
	<section id="container">
    <table class="table table-hover" border="1px" width="80%" align="center">
        <thead>
	        <tr>
	            <th style="width:10%" >글 번호</th>
	            <th style="width:30%">제목</th>
	            <th style="width:30%">작성자</th>
	            <th style="width:30%">날짜</th>
	        </tr>
        </thead>

    <c:forEach items="${boardList}" var="boardVO">
        <tr>
            <td>${boardVO.b_no}</td>
            <td><a href="/board/detail?b_no=${boardVO.b_no}">${boardVO.b_title}</a></td>
            <td>${boardVO.b_writer }</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${boardVO.b_date}" /> </td>
        </tr>
    </c:forEach>
    </table>
</section>
</div>
</body>
</html>