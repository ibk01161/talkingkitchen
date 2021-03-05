<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jsp" %>
<body>

<!-- 	<form method="post" name="insert" enctype="multipart/form-data"> -->
	<form method="post" name="recipeForm" enctype="multipart/form-data">

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
   
		<label for="rec_category">카테고리</label>
		<div class="row">  <!-- 열 크기 조절 -->
			<div class="col-xs-2">
				<select class="form-control" id="rec_category" name="recCategory1">
					<option value="" selected disabled>나라별</option>
					<option>한식 요리</option>
					<option>중식 요리</option>
					<option>일식 요리</option>
					<option>동남아/인도 요리</option>
					<option>멕시칸 요리</option>
					<option>양식 요리</option>
					<option>퓨전요리</option>
					<option>이국적인맛</option>
					<option>기타</option>
				</select>
			</div>
			
			<div class="col-xs-2">
				<select class="form-control" name="recCategory2">
					<option value="" selected disabled>상황별</option>
					<option>간식/야식</option>
					<option>술안주</option>
					<option>해장요리</option>
					<option>손님 접대 요리</option>
					<option>나들이 요리</option>
					<option>파티/명절요리</option>
					<option>실생활 요리</option>
					<option>기타</option>
				</select>
			</div>
			
			<div class="col-xs-2">
				<select class="form-control" name="recCategory3">
					<option value="" selected disabled>재료별</option>
					<option>소고기</option>
					<option>돼지고기</option>
					<option>닭고기</option>
					<option>육류</option>
					<option>채소류</option>
					<option>해물류</option>
					<option>달걀/유제품</option>
					<option>가공식품류</option>
					<option>쌀</option>
					<option>밀가루</option>
					<option>건어물류</option>
					<option>버섯류</option>
					<option>과일류</option>
					<option>콩/견과류</option>
					<option>곡류</option>
					<option>기타</option>
				</select>
			</div>
		
			<div class="col-xs-2">
				<select class="form-control" name="recCategory4">
					<option value="" selected disabled>방법별</option>
					<option>볶음</option>
					<option>끓이기</option>
					<option>부침</option>
					<option>조림</option>
					<option>무침</option>
					<option>비빔</option>
					<option>찜</option>
					<option>절임</option>
					<option>튀김</option>
					<option>삶기</option>
					<option>굽기</option>
					<option>데치기</option>
					<option>회</option>
					<option>기타</option>
				</select>
			</div>
		</div>
		<br/>
   
		<p class="help-block">★ 분류를 바르게 설정해주시면, 이용자들이 쉽게 레시피를 검색할 수 있어요.</p>
		<p><br/>
	
		<label for="rec_infor">요리 정보</label>
   
		<div class="form-inline">
			<div class="row">
				<div class="col-xs-4">
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
   
		<div class="form-group">
		<label for="rec_img">파일 업로드</label>   
			<input type="file" id="rec_img" name="recImg" >
			<img class="thumbnail" id="rec_thumbnail" src="${app}/resources/img/pic.gif" width="200" height="200" />   <!-- width="200" height="200" -->
		</div><br/><br/>
    
    	<!-- 재료 -->
		<h1>재료</h1><br/>
<!-- 		<div class='row'> -->
<!-- 			<div class='col-md-4 col-md-offset-2'> -->
<!-- 				<div class='form-group'> -->
<!-- 					<label class='sr-only' for='rec_ing'></label> -->
<!-- 						<input type='text' class='form-control' name='recipeIngrVoList[0].ingrCode' id='ingr_code' placeholder='코드값' /> -->
<!-- 						<input type='text' class='form-control' name='recipeIngrVoList[0].ingrSub' id='ingr_sub' placeholder='재료' /> -->
<!-- 				</div> -->
<!-- 			</div> -->
       
<!-- 			<div class='col-md-4'> -->
<!-- 				<div class='form-group'> -->
<!-- 				<label class='sr-only' for='rec_quantity'></label> -->
<!-- 					<input type='text' class='form-control' name='recipeIngrVoList[0].recIngrQnt' id='rec_ingr_qnt' placeholder='양   ex:200g' /> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
		<div id="rec_ingr"></div>
   
		<p align="center">
		<button type="button" class="btn btn-primary btn-lg" onclick="add_ing()">추가</button>
		</p>
   
   		<!-- 요리 순서 -->
		<h1>요리 순서</h1>
   		
<!-- 		<div class='form-horizontal'> -->
<!-- 			<div class='form-group'> -->
<!-- 			<label for='rec_step' class='col-sm-2 control-label'>Step</label> -->
<!-- 				<div class='col-sm-7'> -->
<!-- 					<input type='text' id='step_no' name='recipeStepVoList[0].stepNo' value='1' /> -->
<!-- 						<textarea class='form-control' rows='6' id='step_content' name='recipeStepVoList[0].stepContent' placeholder='예) 당근을 작게 깍둑썰기 해주세요.'></textarea> -->
<!--    				</div> -->
<!--    			</div> -->
<!--    			<p></p> -->
   		
<!--    			<div class='form-group'> -->
<!--    			<label for='step_time' class='col-sm-2 control-label'>시간</label> -->
<!--    				<div class='col-sm-5'> -->
<!--    					<input type='number' class='form-control' id='step_time' name='recipeStepVoList[0].stepTime' placeholder='각 단계별 소요시간을 분 단위로 입력해주세요.'/> -->
<!--    				</div> -->
<!--    			</div> -->
   		
<!-- 			<div class='col-sm-5'> -->
<!-- 				<input type='file' id='step_img' name='recipeStepVoList[0].stepImg' > -->
<%-- 				<img class='thumbnail' id='step_thumbnail' src='${app}/resources/img/pic_plus.gif' width="200" height="200" /> --%>
<!-- 			</div> -->
<!--    		</div> -->
			<div id="rec_step"></div>
   			<p align="center">
      			<button type="button" class="btn btn-primary btn-lg" onclick="add_step()">추가</button>
   			</p>
   
		<div class="form-group text-center">
			<button type="button" class="btn btn-success btn-lg" id="insert_btn">등록</button>
			<button type="button" class="btn btn-danger btn-lg" id="insert_cancel">취소</button>
		</div>
    
   </form>
   
</body>

<script>

	var ingr_n = 0;
	var step_n = 0;

	add_ing();
	add_step();

	function add_ing() {

		ingr_n += 1;

		var new_ingr = "<div class='row'>";
		new_ingr += "<div class='col-md-4 col-md-offset-2'>";
		new_ingr += "<div class='form-group'>";
		new_ingr += "<label class='sr-only' for='rec_ing'></label>";

		var code = "rec_code"+ ingr_n;
		new_ingr += "<input type='text' class='form-control' name='recipeIngrVoList[" + (ingr_n-1)  + "].ingrCode' id='" +code + "'/>"; //나중에 hidden 으로

		new_ingr += "<input type='text' class='form-control' name='recipeIngrVoList[" + (ingr_n-1)  + "].ingrSub' id='rec_ingr" + ingr_n + "' placeholder='재료' >";   //onclick=openIngredient(this.id,'" + code + "')
		new_ingr += "</div></div>";

		new_ingr += "<div class='col-md-4'>";
		new_ingr += "<div class='form-group'>";
		new_ingr += "<label class='sr-only' for='rec_quantity'></label>";
		new_ingr += "<input type='text' class='form-control' name='recipeIngrVoList[" + (ingr_n-1) + "].recIngrQnt' id='rec_ingr_qnt" + ingr_n + "' placeholder='양   ex:200g'>";
		new_ingr += "</div></div></div>";

		$('#rec_ingr').append(new_ingr);

	}

	function add_step() {

		step_n += 1;

		var new_step = "<div class='form-horizontal'>";
		new_step += "<div class='form-group'>";
		new_step += "<label for='rec_step"+ step_n + "' class='col-sm-2 control-label'>Step"+ step_n + "</label>";
		new_step += "<div class='col-sm-7'>";
		new_step += "<input type='text' name='recipeStepVoList[" + (step_n-1) + "].stepNo' value='" + (step_n) + "' />" //hidden
		new_step += "<textarea class='form-control' rows='6' id='rec_step"+ step_n + "' name='recipeStepVoList[" + (step_n-1) + "].stepContent' placeholder='예) 당근을 작게 깍둑썰기 해주세요.'></textarea>";
		new_step += "</div></div><p></p>";
		new_step += "<div class='form-group'>";
		new_step += "<label for='step_time"+step_n + "' class='col-sm-2 control-label'>시간</label>";
		new_step += "<div class='col-sm-5'>";
		new_step += "<input type='number' class='form-control' id='step_time"+step_n + "' name='recipeStepVoList[" + (step_n-1) + "].stepTime' placeholder='각 단계별 소요시간을 분 단위로 입력해주세요.'/></div>";
		new_step += "<div class='col-sm-5'>";
		new_step += "<input type='file' onchange='stepReadUrl(this, " + step_n + ");' name='recipeStepVoList[" + (step_n-1) + "].stepImg' >";
		new_step += "<img class='step_thumbnail' id='a" + step_n + "' src='${app}/resources/img/pic_plus.gif' width='200' height='200' />";
		new_step += "</div></div>";

		$('#rec_step').append(new_step);

	}

// 	let f = document.insert;
	var recipeFrom = $("form[name='recipeForm']");

	$('#insert_btn').click(function(){
		if (confirm('등록하시겠습니까?')) {
			validate();
		}
	   	
	});

	$('#insert_cancel').click(function(){
		location.href="/recipe/list";
	});

	function validate() {
		
// 		f.method = 'POST';
// 		f.action = 'insert';
// 		f.submit();

		if ($('#rec_title').val() == '') {
			alert('레시피 제목을 입력해주세요');
			$('#rec_title').focus();
			return;
		}

		recipeFrom.method = 'POST';
		recipeFrom.action = 'insert';
		recipeFrom.submit();

	}

	// 이미지 미리보기 (대표사진)
	$('#rec_img').change(function() {
		recReadUrl(this);
	});

	// 이미지 미리보기 (스탭사진)
// 	$('#step_img').change(function() {
// 		stepReadUrl(this);
// 	});

	function recReadUrl(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			
			reader.onload = function(e) {
				$('#rec_thumbnail').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

	function stepReadUrl(input, index) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			
			reader.onload = function(e) {
				$('#a' + index).attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}


</script>


<%@ include file="../commons/footer.jsp" %>