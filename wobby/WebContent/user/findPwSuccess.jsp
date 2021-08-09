<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<!-- Optional JavaScript -->
	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	<!-- for Icon -->
	<script src="https://kit.fontawesome.com/cfb4151af4.js"	crossorigin="anonymous"></script>
	<script>
	function findPw() {
		if (form.inputPw.value == "" || form.inputPwCheck.value == "") {
			return false;
		}
		form.submit();
	</script>
	<title>��й�ȣ ����</title>
</head>
<body>
    <div class="col-xs-6 col-sm-4 py-5 container">
    	<div class="pb-5">
      		<h2 class="pb-5 text-center form-signin-heading">��й�ȣ ã��</h2>
        	<div class="py-5">
        	<b><span class="text-primary">${userId}</span>��, ���ο� ��й�ȣ�� �������ּ���.</b>
        	<form action="<c:url value='/user/updatePw'/>">
        		<input type="hidden" name="userId" value="${userId}">
	        	<div class="pt-2 form-group">
					<label for="inputPassword">��й�ȣ</label> <input type="password"
						class="form-control" name="inputPw" placeholder="" required>
				</div>
				<div class="form-group">
					<label for="inputPasswordCheck">��й�ȣ Ȯ��</label> <input
						type="password" class="form-control" name="inputPwCheck"
						placeholder="" required>
	        	</div>
	        	<div>
				<!-- ������ ��� exception ��ü�� ����� ���� �޽����� ��� -->
					<div class="col-lg-12">
						<c:if test="${updatePwFailed}">
							<h6 class="text-danger"><c:out value="${exception.getMessage()}"/></h6>
						</c:if>
					</div>	 
				<div> 
	        	<button onClick="updatePw()" class="btn btn-lg btn-primary btn-block">�Ϸ�</button>
	        	</div>
        	</form>
        	</div>
       </div>
    </div>
</body>
</html>