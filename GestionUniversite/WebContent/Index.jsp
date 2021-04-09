<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "now" value = "<%=new java.util.Date()%>" />
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.i18n.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="login.titre" /></title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
	<fmt:message key="login.home"/>
	</header>
	<section id="fish">
		<h1><fmt:message key="login.h1" /></h1>
		<form action="index" method="get">
		<fmt:message key="login.nom" />: <input name="nom"><br>
		<fmt:message key="login.prenom" />: <input name="prenom"><br>
		<input type="submit" id="button" value="<fmt:message key="login.submit"/>" name="envoi">
		</form>
	</section>
	<c:set var="i" value="0"></c:set>
	<table>
		<c:forEach begin="0" end="20" varStatus="loop">
		<td id="cadre"><c:out value="${i}"></c:out></td>
		<c:set var="i" value="${i+1}"></c:set>
		</c:forEach>
	</table>
      <c:choose>
         
         <c:when test = "${language=='fr_FR'}">
            Your language is french
         </c:when>
         
         <c:when test = "${language=='en_US'}">
            Your language is english
         </c:when>
         
         <c:otherwise>
            no language sir ...
         </c:otherwise>
      </c:choose>
	<footer>© 2021 <fmt:message key="login.lang" /> <div><fmt:message key="login.time" /> <fmt:formatDate value="${now}" type="time"/></div></footer>
</body>
</html>