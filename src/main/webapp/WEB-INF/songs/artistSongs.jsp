<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">

<h1>Top Songs</h1>
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Rating</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${artistSongs}" var="song">
        <tr>
            <td><c:out value="${song.title}"/></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/songs">All Songs</a>


</div>

</body>
</html>


