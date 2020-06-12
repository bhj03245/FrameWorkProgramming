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
			var formObj = $("form[name='updateForm']");
			
			$(".cancel_btn").on("click", function(){
				event.preventDefault();
				location.href = "/board/listAll";
			})
			
			$(".update_btn").on("click", function(){
				if(fn_valiChk()){
					return false;
				}		
				formObj.attr("action", "/board/update");
				formObj.attr("method", "post");
				formObj.submit();
			})
			
			// 삭제
			$(".delete_btn").on("click", function(){
				var deleteYN = confirm("삭제하시겠습니까?");
				if(deleteYN == true){
				formObj.attr("action", "/board/delete");
				formObj.attr("method", "post");
				formObj.submit();
				}

				else if(deleteYN == false){
				formObj.attr("action", "/board/listAll");
				}				
			})
		})
			
		function fn_valiChk(){
			var updateForm = $("form[name='updateForm'] .form-control").length;
			for(var i = 0; i<updateForm; i++){
				if($(".form-control").eq(i).val() == "" || $(".form-control").eq(i).val() == null){
					alert("입력 정보에 공란이 있으면 안됩니다.");
					return true;
				}
			}
		}
		
	</script>
	<body>
		<div class="container">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr style="border: solid 5px grey;">
			 
			<div>
				<%@include file="nav.jsp" %>
			</div>
			<hr style="border: solid 5px grey;">
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="/board/update">
					<input type="hidden" name="b_no" value="${boardVO.b_no}" readonly="readonly"/>
					
					<div class="form-group">
						<label for="title" class="col-sm-2 control-label">제목</label>
						<input type="text" id="b_title" name="b_title" value="${boardVO.b_title}" class="form-control" title="제목을 입력하세요." placeholder="제목을 입력하세요"/>
					</div>
					
					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">내용</label>
						<textarea rows="4" cols="15" id="b_detail" name="b_detail" class="form-control" title="내용을 입력하세요" placeholder="내용을 입력하세요"><c:out value="${boardVO.b_detail}" /></textarea>
					</div>
					
					<div class="form-group">
						<label for="writer" class="col-sm-2 control-label">작성자</label>
						<input type="text" id="b_writer" name="b_writer" class="form-control" value="${boardVO.b_writer}" readonly="readonly" />
					</div>
						
					<div class="form-group">
						<label for="passwd" class="col-sm-2 control-label">비밀번호</label>
						<input type="text" id="b_passwd" name="b_passwd" class="form-control" title="작성자 확인을 위한 비밀번호 입력" placeholder="**********"/>
					</div>
					
					<div class="form-group">
						<label for="regdate" class="col-sm-2 control-label">작성날짜</label>
						<fmt:formatDate value="${boardVO.b_date}" pattern="yyyy-MM-dd"/>					
					</div>	
		
					<div>
						<button type="submit" class="update_btn btn btn-primary">저장</button>
						<button type="submit" class="delete_btn btn btn-danger">삭제</button>
						<button type="submit" class="cancel_btn btn btn-warning">취소</button>
					</div>
				</form>
			</section>
		</div>
	</body>
</html>