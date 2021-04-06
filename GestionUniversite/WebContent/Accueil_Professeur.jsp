<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.i18n.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="id.titreP" /></title>
<link rel="stylesheet" href="style2.css">
</head>
<body>
	<header>
	<h2><fmt:message key="id.eleveh1" /> ${professeur.nom} ${professeur.prenom}</h2> 
	</header>
	<section id="fish">
	<h1><fmt:message key="id.prof"/></h1>
	<fmt:message key="id.matiere" /> : ${professeur.matiere}<br>
	<table class="styled-table">
	<thead>
		<tr>
			<td>
				<fmt:message key="id.nomE" />
			</td>
			<td>
				<fmt:message key="id.prenomE" />
			</td>
			<td>
				<fmt:message key="id.noteE" />
			</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="note" items= "${professeur.notes}">
		<tr class="active-row">
			<td class="pre">
				<c:out value="${note.nom}"></c:out>
			</td>
			<td class="deux">
				<c:out value="${note.prenom}"></c:out>
			</td>
			<td class="trois">
				<c:out value="${note.valeur}"></c:out>
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	</section>
	<footer>© 2021 <fmt:message key="login.lang" /></footer>
</body>
</html>