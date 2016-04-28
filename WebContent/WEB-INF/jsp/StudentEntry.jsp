<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

function  call (str)
{
	
	document.f1.action=str;
	document.f1.submit();
	
	}

</script>
<body>
<form:form  commandName="student"   name="f1" >

<input type="text"  name="stuname" >
<input type="text"  name="subject" >
<input type="text"  name="marks" >
<input type="submit"   onclick="call('studententry');"  value="save" >


<input type="submit"   onclick="call('showuser');"  value="show" >
<c:forEach var="student" items="${students }" >
<c:out value="${student.rollno }"></c:out>
<c:out value="${student.stuname }"></c:out>
 </c:forEach>
</form:form>
</body>
</html>