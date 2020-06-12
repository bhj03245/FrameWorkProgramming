<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>NetFlix 리뷰 게시판</title>
	<link rel="stylesheet" href="resources/main.css" type="text/css"></link>
</head>

<style>
.border {
  border: 10px solid grey;
}
</style>

<div align="center">
<img src="resources/NetFlix.jpg" id="img" alt="">
</div>

<body>
<div align="center" class="border">
	<p> <a>익명으로 자유롭게  </a></p>
	<p> <a>넷플릭스 상영작에대한  </a></p>
	<p> <a>토론을 할 수 있는 게시판입니다. </a></p>
	<p><a href="/board/listAll"  target="_self">리뷰 게시판 들어가기</a> </p>
</div>
</body>
</html>
