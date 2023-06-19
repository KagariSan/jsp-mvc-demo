<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="controller"
	class="com.itplus.test1.controller.EmployeeController" scope="session"></jsp:useBean>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
	integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<c:if test="true">

		<div class="container">
		<div class="panel" id="panel1">
			<h2>Danh Sách Nhân Viên</h2>
			<input type="button" class="btn btn-primary float-end" value="Thêm"
				onclick="showDetail()">
			<table class="table table-bordered">
				<thead class="table-secondary">
					<tr>
						<th scope="col">Mã nhân viên</th>
						<th scope="col">Tên nhân viên</th>
						<th scope="col">Ngày sinh</th>
						<th scope="col">Chức vụ</th>
						<th scope="col">Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${controller.employeeModel.getListEmployee()}" var="employee">
							
							<td>${employee.empCode}</td>
							<td>${employee.name}</td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${employee.birthDay}"/></td>
							<td>${employee.position}</td>
							
						</c:forEach>
						<td>
							<form action="" method="post">
								<input type="button" name="id" value="id" hidden> <input
									type=button" class="btn btn-primary" name="delete" value="Xóa" onclick="showDialog()">
								<input type="button" class="btn btn-primary " name="edit"
									value="Sửa" onclick="showDetail()">
							</form>
						</td>
					</tr>

				</tbody>
			</table>

			<div class="modal" tabindex="-1" id = "dialog" style= "display:none">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">Xóa</h5>
							<button type="button" class="btn-close" 
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<p>Bạn có muốn xóa không</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								>Có</button>
							<button type="button" class="btn btn-primary" onclick="hideItem()">Không
								 </button>
						</div>
					</div>
				</div>
			</div>
		</div>


	</c:if>
</body>
</html>