<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jsp" %>
<body>

insert success...

</body>

<script>

	var result = "${msg}";

	if (result == "success") {
		alert('글이 등록되었습니다.');
		} else if (result == "fail") {
			alert('글 등록 실패');
			}

</script>

<%@ include file="../commons/footer.jsp" %>