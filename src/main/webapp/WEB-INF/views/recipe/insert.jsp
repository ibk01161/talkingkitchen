<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jsp" %>
<body>

recipe insert....

<form method="post" name="insert">

	<div class="form-group">
		<label for="rec_title">레시피 제목</label>
      		<input type="text" class="form-control" id="rec_title" name="recTitle" placeholder="예) 소고기 미역국 끓이기">
   </div>
   <p><br/><br/>
   <div class="form-group">
      <label for="rec_intro">요리 소개</label>
      <textarea class="form-control" rows="3" id="rec_intro" name="recIntro" placeholder="이 레시피의 탄생배경을 적어주세요"></textarea>
   </div>
   <p><br/><br/>
   
   <div class="form-inline">
   <div class="row">
      <div class="col-xs-4">
      <!-- <p>인원</p> -->
         <select class="form-control" id="rec_infor" name="recPortion">
            <option value="" selected disabled>인원</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
         </select>
      </div>
      <div class="col-xs-4">
      <!-- <p>시간(분)</p> -->
         <select class="form-control" id="rec_infor" name="recTime">
            <option value="" selected disabled>시간(분)</option>
            <option>5</option>
            <option>10</option>
            <option>20</option>
            <option>30</option>
            <option>40</option>
            <option>50</option>
            <option>60</option>
            <option>90</option>
            <option>120</option>
            <option>180</option>
         </select>
      </div>
      <div class="col-xs-4">
      <!-- <p>난이도</p> -->
         <select class="form-control" id="rec_infor" name="recLevel">
            <option value="" selected disabled>난이도</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
         </select>
      </div>
   </div>
   </div>
   <p><br/><br/>
   </p>
   
   <div class="form-group text-center">
      <input type="button" class="btn btn-success btn-lg" id="insert_btn" value="등록">
      <input type="button" value="취소"class="btn btn-danger btn-lg" id="insert_cancel"/>
   </div>
   
   </form>
   
</body>

<script>

	let f = document.insert;

	$('#insert_btn').click(function(){
	   	validate();
	});

	function validate(){
		
		f.method = 'POST';
		f.action = 'insert';
		f.submit();  

	}

</script>


<%@ include file="../commons/footer.jsp" %>