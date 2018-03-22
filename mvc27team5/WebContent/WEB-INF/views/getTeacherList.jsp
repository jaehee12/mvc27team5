<!-- [유국화] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="teacherHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="teacherBody.jsp"></jsp:include>
	<div align="center">
		<h1>Teacher List</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>티처 순서</th>
					<th>티처 이름</th>
					<th>티처 비번</th>
					<th>수정</th>
					<th>삭제</th>
					<th>ADD TEACHER_ADDR</th>				
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "teacher" items = "${list}">
					<tr>
						<td>${teacher.teacherNo}</td>
						<td>${teacher.teacherId}</td>
						<td>****</td>
						<td><a href="${pageContext.request.contextPath}/modifyTeacher.jjdev?teacherNo=${teacher.teacherNo}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/removeTeacher.jjdev?teacherNo=${teacher.teacherNo}">삭제</a></td>
						<td><a href="${pageContext.request.contextPath}/getTeacherAddrList.jjdev?teacherNo=${teacher.teacherNo}">주소추가</a></td>
					</tr>
				</c:forEach>	
			</tbody>	
		</table>
	</div>
</body>
</html>