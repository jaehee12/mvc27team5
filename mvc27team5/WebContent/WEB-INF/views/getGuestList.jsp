<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- prefix 는 uri부분을 치환해줌. 그래서 중복되는 것 일때는 <c:img> 이런식으로 쓰면됨. --%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="guestHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="guestBody.jsp"></jsp:include>
	<div align="center">
		<h1>guestList</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>게스트 순서</th>
					<th>게스트 이름</th>
					<th>게스트 비번</th>
					<th>수정</th>
					<th>삭제</th>
					<th>ADD GUEST_ADDR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "guest" items = "${list}">
					<tr>
						<input type="hidden" class="addressCount" value="${guest.guestCount}">
						<td>${guest.guestNo}</td>
						<td>${guest.guestId}</td>
						<td>****</td>
						<td><a href="${pageContext.request.contextPath}/modifyGuest.jk?guestNo=${guest.guestNo}">수정</a></td>
						<td><a class="changeLink" href="${pageContext.request.contextPath}/removeGuest.jk?guestNo=${guest.guestNo}">삭제</a></td>
						<td><a href="${pageContext.request.contextPath}/getGuestAddrList.jk?guestNo=${guest.guestNo}">주소추가</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav>
			<ul class="pagination">
			<!-- 현재 페이지의 가장 첫번째  -->
			<fmt:formatNumber value="${startPage}" type="number" var="intStartPage"/>
			<!-- 마지막페이지랑 비교해서 오른쪽화살표 안보여주려고! -->
			<fmt:formatNumber value="${lastPage}" type="number" var="intLastPage"/>
			<!-- 현제페이지를 알아야 범위를지정해서 아래 숫자를 호출 할 수 있음 -->
			<fmt:formatNumber value="${currentPage}" type="number" var="intCurrentPage"/>
			<!-- 이전페이지를 구하기위한 계산식인데, 소수점부분이 존재하면 변환해도 남아있기때문에 아예 .0이 된상태로 변환해야함 그래서 이렇게 길어짐. -->
			<fmt:formatNumber value="${(((intCurrentPage-1)/10)-((intCurrentPage-1)/10%1))*10}" type="number" var="previousPage"/>
			<!-- 다음페이지를 구하기위한 계산식인데, 소수점부분이 존재하면 변환해도 남아있기때문에 아예 .0이 된상태로 변환해야함 그래서 이렇게 길어짐. --> 
			<fmt:formatNumber value="${(((intCurrentPage-1)/10 - ((intCurrentPage-1)/10%1))+1)*10+1}" type="number" var="nextPage"/>
				<c:choose>
					<c:when test="${previousPage eq 0}">
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/getGuestList.jk?currentPage=${previousPage}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
					</c:otherwise>
				</c:choose>
				<c:set var="doneLoop" value="false"/> 
				<c:forEach var="i" begin="${intStartPage}" end="${intStartPage+9}" step="1">
					<!-- 이건 딱 존재하는 페이지만큼만 아래 숫자를 출력해주기 위해서 break문을 써야하기때문에, 써줌 --> 
					<c:if test="${not doneLoop}"> 
						<c:choose>
							<c:when test="${i eq lastPage}">
								<li><a href="${pageContext.request.contextPath}/getGuestList.jk?currentPage=${i}">${i}</a></li>
								<!-- 이건 break대용잉! --> 
								<c:set var="doneLoop" value="true"/>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/getGuestList.jk?currentPage=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
				
				<c:choose>
					<!-- 만약에, 다음페이지의값, 즉 오른쪽에 나올 값들 예를들어, 11, 21, 31 등의 값들이 내가 구현하고자하는 페이지수보다 클경우 >>표시를 안해줌! -->
					<c:when test="${intLastPage < nextPage}">
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/getGuestList.jk?currentPage=${nextPage}" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
</body>
</html>