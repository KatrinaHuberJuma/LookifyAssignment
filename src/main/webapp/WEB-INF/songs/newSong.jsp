<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">

<form:form action="/songs" method="post" modelAttribute="song">
<p>
	<form:label path="title">Title</form:label>
	<form:errors path="title"/>
	<form:input path="title"/>
</p>
<p>
	<form:label path="artist">Artist</form:label>
	<form:errors path="artist"/>
	<form:input path="artist"/>
</p>
<p>
	<form:label path="rating">Rating</form:label>
	<form:errors path="rating"/>
	<form:input path="rating"/>
</p>
<input type="submit" value="Submit"/>
</form:form>

</div>


</body>
</html>


<!-- org.springframework.beans.factory.UnsatisfiedDependencyException: 
Error creating bean with name 'songController': Unsatisfied dependency expressed through 
field 'songService'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: 
Error creating bean with name 'songService': Unsatisfied dependency expressed through field 'songRepo'; 
nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 
'songRepository': Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: 
Failed to create query for method public abstract java.util.List com.kat.lookify.repositories.SongRepository.findTop5ByRating()! 
No parameter available for part rating SIMPLE_PROPERTY (1): [Is, Equals] NEVER.
	 -->