<!-- [김재희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="studentHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="studentBody.jsp"></jsp:include>
	<div align="center">
		<h1>Student List</h1>
			<table border="1" class="table">
				<thead>
					<tr>
						<th>학생 순서</th>
						<th>학생 이름</th>
						<th>학생 비번</th>
						<th>수정</th><!-- 넘버값을  ?studentNo 로 넘긴다 / StudentDao.updateStudent() -->
						<th>삭제</th><!-- StudentDao.deleteStudent() -->
						<th>학생 주소록 추가</th><!-- StudentAddrDao.insertStudentAddr -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${list}">
						<tr>
							<td>${student.studentNo}</td>
							<td>${student.studentId}</td>
							<td>****</td><!-- 비밀번호 아예가지고 오지 말기 셀렉트에 넣지 말기 -->
							<td><a href="${pageContext.request.contextPath}/modifyStudent.jjdev?studentNo=${student.studentNo}">수정</a></td>
							<td><a href="${pageContext.request.contextPath}/removeStudent.jjdev?studentNo=${student.studentNo}">삭제</a></td>
							<td><a href="${pageContext.request.contextPath}/getStudentAddrList.jjdev?studentNo=${student.studentNo}">주소추가</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${currentPage!=1}">
				<a href="${pageContext.request.contextPath}/getStudentList.jjdev">[처음으로]</a> <!-- 1페이지에선 생략, 1페이지로 고정시켜야함 -->
			</c:if>
			<c:if test="${currentPage>1}">
				<a href="${pageContext.request.contextPath}/getStudentList.jjdev?currentPage=${currentPage-1}">[이전]</a><!-- 현재페이지 -1 -->
			</c:if>
			<c:if test="${currentPage<lastPage}">
				<a href="${pageContext.request.contextPath}/getStudentList.jjdev?currentPage=${currentPage+1}">[다음]</a><!-- 현재페이지 +1 -->
			</c:if>
			<c:if test="${currentPage!=lastPage}">
				<a href="${pageContext.request.contextPath}/getStudentList.jjdev?currentPage=${lastPage}">[마지막으로] </a><!-- lastPage로 고정 -->
			</c:if>
	</div>
</body>
</html>