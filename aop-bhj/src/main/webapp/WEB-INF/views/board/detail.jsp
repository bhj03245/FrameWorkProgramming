<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='readForm']");
			
			// 수정 
			$(".update_btn").on("click", function(){
				formObj.attr("action", "/board/update");
				formObj.attr("method", "get");
				formObj.submit();				
			})
			
			// 목록
			$(".list_btn").on("click", function(){		
				formObj.attr("action", "/board/listAll");
				formObj.attr("method", "get");
			})
		})
		
	</script>
	
	<body>
		<div class="container">
			<header>
				<h1> NeFlix 게시판</h1>
			</header>
			<hr style="border: solid 5px grey;">
			
			<div>
				<%@include file="nav.jsp" %>
			</div>
			<hr style="border: solid 5px grey;">
			
			<section id="container">
				<form name="readForm" role="form" method="post">
					<input type="hidden" id="b_no" name="b_no" value="${boardVO.b_no}" />
					<input type="hidden" id="b_passwd" name="b_passwd" class="pass" value="${boardVO.b_passwd}" />		
					
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">제목</label>
				<input type="text" id="b_title" name="b_title" class="form-control" value="${boardVO.b_title}" readonly="readonly"/>
			</div>
					
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">내용</label>
				<textarea id="b_detail" name="b_detail" class="form-control" readonly="readonly"><c:out value="${boardVO.b_detail}"/></textarea>
			</div>
					
			<div class="form-group">
				<label for="writer" class="col-sm-2 control-label">작성자</label>
				<input type="text" id="b_writer" name="b_writer"  class="form-control" value="${boardVO.b_writer}" readonly="readonly"/>
			</div>		
			
			<div class="form-group">
				<label for="regdate" class="col-sm-2 control-label">작성날짜 </label>
				<fmt:formatDate value="${boardVO.b_date}" pattern="yyyy-MM-dd" />					
			</div>
			
			<div>
				<button type="submit" class="update_btn btn btn-info">수정</button>
				<button type="submit" class="list_btn btn btn-primary">목록</button>	
			</div>
			</form>	
			</section>
		</div>
		   
	</body>
</html>