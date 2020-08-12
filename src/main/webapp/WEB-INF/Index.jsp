<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css" >
</head>
<body>

<h1 class="earnedGold"> Your Gold here:<%= session.getAttribute("pouch") %> </h1>
 	<h1><a href="/destroy_session">Start Again</a></h1>

	<div class="container">	
		<div class="farm box-radius box-shadow" > 
		<h1> Farm </h1>	   
			<form action="/process_money"  method="POST">
				<input type="hidden" name= "place" value="farm" />
				<button class="button is-primary" type="submit">Submit</button>
			</form>
		</div>
		<div class="farm"> 
			<h1> Cave </h1>
			<form action="/process_money"  method="POST">
				<input type="hidden" name= "place" value="cave" />
				<button class="button is-primary" type="submit">Submit</button>
			</form>
		</div>
		
		<div class="farm"> 
			<h1> House </h1>
			<form action="/process_money" method="POST">
				<input type="hidden" name= "place" value="house" />
				<button class="button is-primary" type="submit">Submit</button>
			</form>
		</div>
		
		<div class="farm">  
		<h1> Casino </h1>
		<form action="/process_money"  method="POST">
			<input type="hidden" name= "place" value="casino" />
			<button class="button is-primary" type="submit">Submit</button>
		</form>
		
		</div>
		
	</div>
	<h1 class=""> Activities:</h1> 
	<div class="text"> 
		<c:forEach items="${log }" var="act">
				<p class="${ color }">
					<c:out value="${act }" />
				</p>
			</c:forEach>

		</div>
		

</body>
</html>