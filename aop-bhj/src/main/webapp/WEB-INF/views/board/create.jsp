<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>게시판</title>
</head>
<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='createForm']");
			$(".write_button").on("click", function(){
				if(fn_valiChk()){
					return false;
				}
			});
			$(".transaction_button").on("click", function(){
				if(fn_valiChk()){
					return false;
				}
				formObj.attr("action", "/board/createFail");
				formObj.attr("method", "post");
			});
		})
				
		function fn_valiChk(){
			var regForm = $("form[name='createForm'] .form-control").length;
			for(var i = 0; i<regForm; i++){
				if($(".form-control").eq(i).val() == "" || $(".form-control").eq(i).val() == null){
					alert("입력 정보에 공란이 있으면 안됩니다")
					return true;
				}
			}
		}
</script>
<body>
	<div class="container">
		<header>
		<h1>
		    NetFlix 게시판 
		</h1>
		</header>
		<hr style="border: solid 5px grey;">

		<section id="container">
    		<form name="createForm" method="POST" action="/board/create">
     			<div class="form-group">
            			<label for="title" class="col-sm-2 control-label">제목</label>
            			<input type="text" name="b_title" class="form-control" title="제목을 입력하세요." placeholder="제목을 입력하세요">
            	</div>
            	
  				<div class="form-group">
            			<label for="content" class="col-sm-2 control-label">내용</label>
            			<textarea rows="4" cols="15" name="b_detail" class="form-control" title = "내용을 입력하세요" placeholder="내용을 입력하세요"></textarea>
      			</div>
       
   				<div class="form-group">
           			 	<label for="writer" class="col-sm-2 control-label">작성자</label>
           			 	<input type="text" name="b_writer" class="form-control" title = "작성자를 입력하세요" placeholder="작성자를 입력하세요">
        		</div>
        		
    			 <div class="form-group">
            			<label for="password" class="col-sm-2 control-label">비밀번호</label>
            			<input type="text" name="b_passwd" class="form-control" title = "비밀번호를 입력하세요" placeholder="*********">
        		</div>
        		
        		<hr style="border: solid 5px grey;">
   				 <div>
      				<button type="submit" class="write_button btn btn-primary">작성하기</button>
      				<button type="submit" class="transaction_button btn btn-danger">트랜잭션</button>
   				</div>
   		 </form>
 		 	
    </section>
   </div>
</body>
</html>