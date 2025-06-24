<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<form action = "${pageContext.request.contextPath}/remove" method ="get">
			<table>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="password" value="${guestbookVO.password}">
					</td>
					<td>
						<button type="submit">삭제</button>
					</td>
				</tr>
			</table>
			<input type = "text" name = "no" value = "${param.no}">
			
		</form>
		
		<br><br>
		<a href="${pageContext.request.contextPath}/list">메인으로 돌아가기</a>
	</body>

</html>