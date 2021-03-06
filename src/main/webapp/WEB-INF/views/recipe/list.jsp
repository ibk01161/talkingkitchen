<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jsp" %>
<body>
<div class="jbContent">
   <article class="container">
        <div class="page-header">
          <h1><a href="${app}/recipe/list">레시피</a></h1>
          <button type="button" class="btn btn-primary" id="rec_insert">레시피 등록</button>
        </div>
        
        <div class="row">
        
        <c:forEach items="${list}" var="list">
        
        	<div class="col-sm-6 col-md-4">
        		<div class="thumbnail">
        			<a href="list/${list.recNo}">
        			<img src='${app}/displayFile?fileName=${list.attachVo.attachPath}/${list.attachVo.attachName}' style='width:350px; height:250px'/></a>
        			<hr style='border: none; border: 1px dashed #BDBDBD;'>
        			
        			<div class='caption'>
        			<a href="list/${list.recNo}">
        			<h3 id='rec_title'>${list.recTitle}</h3>
        			<p class='help-block' id='rec_intro'>${list.recIntro}</p></a>
        			<hr style='border: none; border: 1px dashed #BDBDBD;'>
        		
        			<div class='row'>
        				<div class='col-md-4'>
        					<p>${list.recRating}</p>
        				</div>
        				<div class='col-md-8'>
        					<p>작성자</p>
        				</div>
        			</div>
	        		
    			   	<div class='row'>
						<div class='col-md-4'>
							<p>${list.recReadCnt}</p>
						</div>
						<div class='col-md-8'>
							<p><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
						</div>
					</div>
			
				</div>
			</div>
		</div>
		
		</c:forEach>
	</div>
	
	</article>
</div>
	
</body>

<script>

	var result = "${msg}";

	if (result == "success") {
		alert('글이 등록되었습니다.');
	} else if (result == "fail") {
		alert('글 등록 실패');
	}

	// 등록하기버튼
	$('#rec_insert').click(function(){
	   location.href = '/recipe/insert';
	});

</script>

<%@ include file="../commons/footer.jsp" %>