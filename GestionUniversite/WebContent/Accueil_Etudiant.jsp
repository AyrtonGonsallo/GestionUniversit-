<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="valeur" value="${etudiant.longueur}" />
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.i18n.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="id.titreE" /></title>
<link rel="stylesheet" href="style2.css">
</head>
<body>
	<header>
	<h2><fmt:message key="id.eleveh1" /> ${etudiant.nom} ${etudiant.prenom}</h2> 
	</header>
	<section id="fish">
	<h1><fmt:message key="id.eleve" /></h1>
	<fmt:message key="id.filiere" /> : ${etudiant.filiere}<br>
	<fmt:message key="id.nbr" /> : ${valeur}<br>
	<table class="styled-table">
	<thead>
		<tr>
			<td>
				<fmt:message key="id.matiere" />
			</td>
			<td>
				<fmt:message key="id.noteE" />
			</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="note" items= "${etudiant.notes}">
		<tr class="active-row">
			<td>
				<c:out value="${note.matiere}"></c:out>
			</td>
			<td>
				<c:out value="${note.valeur}"></c:out>
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	</section>
	<footer>© 2021<fmt:message key="login.lang" /></footer>
</body>
</html>