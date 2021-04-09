<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
 
 <fmt:setBundle basename="com.i18n.text" />
 <sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11403168" user="sql11403168"  password="zY3ketrn1u" scope="session"/> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="conv.titre" /></title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
		<fmt:message key="conv.h1"/>
	</header>
	<section id="fish">
	<table style="border-collapse: collapse;">
	<thead>
	<tr>
	<td style="border:solid;"><fmt:message key="login.nom"/></td><td style="border:solid;"><fmt:message key="login.prenom"/></td><td style="border:solid;"><fmt:message key="conv.msg"/></td>
	</tr>
	</thead>
	
		<sql:query dataSource="${dataSource}" var="emprunt">
      		SELECT * from emprunt where nom=? and prenom=?;
      		<sql:param value="${etudiant.nom}" />
      		<sql:param value="${etudiant.prenom}" />
    	</sql:query>
    	<c:forEach var="row" items="${emprunt.rows}">  
		<tr>  
		<td style="border:solid;"><c:out value="${row.nom}"/></td>  
		<td style="border:solid;"><c:out value="${row.prenom}"/></td>  
		<td style="border:solid;"><fmt:formatNumber value="${row.montant}" type="currency"/></td>  
		</tr>  
		</c:forEach>
		
	</table>
	</section>
	
	<footer>© 2021 <fmt:message key="login.lang" /></footer>
</body>
</html>