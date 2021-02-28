<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jsp" %>
<body>
<c:set value="${recipeDetailList}" var="recipeVo" />
<div class="jbContent">
    <article class="container">
    
    <button type="button" class="btn btn-primary" id="list_btn">목록으로</button>
    
    	<div class="page-header">
			<h1 align="center">${recipeVo.recTitle}</h1>
		</div>
		
		<div class="rec_img" align="center">
			<img src="${app}/displayFile?fileName=${recipeVo.attachVo.attachPath}/${recipeVo.attachVo.attachName}" class="img-thumbnail" style="width:500px; height:350px"/>
		</div>
		<br>
		<p>
		<p class="help-block" style="font-size: 20pt; text-align: center;">${recipeVo.recIntro}</p><p><br></p>
		
		<div class="row">
			<div class="col-xs-6 col-sm-4" style="text-align: center;">
				<span class="glyphicon glyphicon-user" aria-hidden="true" ></span>
					<h4>${recipeVo.recPortion}인분</h4>
			</div>
			<div class="col-xs-6 col-sm-4" style="text-align: center;">
				<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
					<h4>${recipeVo.recTime}분</h4>
			</div>
			<div class="col-xs-6 col-sm-4" style="text-align: center;">
				<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
					<h4>${recipeVo.recLevel}단계</h4>
			</div>
		</div><br><p>
		
		<label style="font-size: 25pt;">재료</label>
		<hr style="border: none; border: 0.5px dashed #BDBDBD;">
		
		<div class="row">
		<c:forEach items="${recipeDetailList.recipeIngrVoList}" var="ingrVo">
		
			<div class="col-md-6">
				<p class="help-block">${ingrVo.ingrCode}</p>
			</div>
			<div class="col-md-6">
				<p class="help-block">${ingrVo.recIngrQnt}</p>	
			</div>
			
		</c:forEach>
		</div><br>
		
		<hr style="border: none; border: 0.5px dashed #BDBDBD;">
		<label style="font-size: 25pt;">조리 순서</label>
		
		<c:forEach items="${recipeDetailList.recipeStepVoList}" var="stepVo">
		
		<p style="font-size: 15pt;">${stepVo.stepNo}단계</p>
		<hr style="border: none; border: 1px dashed #BDBDBD;">
		
		<div class="row">
			<div class="col-md-3">
				<img src="${app}/displayFile?fileName=${stepVo.attachVo.attachPath}/${stepVo.attachVo.attachName}" class="img-thumbnail" style="width:200px; height:200px">
			</div>
			<div class="col-md-9">
				<h4>${stepVo.stepContent}</h4>
			</div>
		</div>
		
		<hr style="border: none; border: 1px dashed #BDBDBD;"><p></p>
		
		</c:forEach>
		
	</article>
</div>
	
</body>

<script>

	// 리스트 화면으로 돌아가기
	$('#list_btn').click(function(){
	   location.href = '/recipe/list';
	});

</script>

<%@ include file="../commons/footer.jsp" %>