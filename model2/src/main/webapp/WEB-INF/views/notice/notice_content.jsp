<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV-공지사항</title>
<link href="http://localhost:8899/model2/resources/css/cgv.css" rel="stylesheet">
</head>
<body>
	<!-- header start -->
	<iframe src="http://localhost:8899/model2/header"  scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	
	<div class="content">
		<section class="login">
			<h1>공지사항</h1>
			<table class="notice_content">
				<tr>					
					<th>제목</th>
					<td>[공지]전체 시스템 점검 예정입니다.</td>					
				</tr>
				<tr>					
					<th>내용</th>
					<td>[공지]전체 시스템 점검 예정입니다.<br><br><br></td>					
				</tr>
				<tr>					
					<th>조회수</th>
					<td>100</td>					
				</tr>
				<tr>					
					<th>작성일자</th>
					<td>2021/12/02</td>					
				</tr>
				<tr>					
					<td colspan="2">
					<!-- notice 폴더내에 있을때는 기존 notice_list.html에서 수정한다. -->
						<a href="notice"> 
							<button type="button" class="btn_style3">리스트</button>
						</a>
						<!-- 절대주소로 주어야 한다. -->
						<a href="http://localhost:8899/model2/main">
							<button type="button" class="btn_style3">홈으로</button>
						</a>
					</td>		
				</tr>
				
			</table>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/model2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
	
</body>
</html>







