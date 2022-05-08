<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Autojen listaus</title>
</head>
<body>
<form action="haeautot" method="get">
	<table id="listaus">
		<thead>	
			<tr>
				<th class="oikealle" colspan="5"><a href="lisaaauto.jsp">Lisää uusi auto</a></th>
			</tr>	
			<tr>
				<th class="oikealle">Hakusana:</th>
				<th colspan="3"><input type="text" name="hakusana" id="hakusana" value="${param['hakusana']}"></th>
				<th><input type="submit" value="hae" id="hakunappi"></th>
			</tr>			
			<tr>
				<th>Rekisterinumero</th>
				<th>Merkki</th>
				<th>Malli</th>
				<th>Vuosi</th>
				<th></th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${autot}" var="listItem">
				<tr>
			        <td>${listItem.rekno}</td>
			        <td>${listItem.merkki}</td>
			        <td>${listItem.malli}</td>
			        <td>${listItem.vuosi}</td>
			        <td>
			        	<a href="muutaauto?rekno=${listItem.rekno}" class="muuta">muuta</a>
			        	<a onclick="varmista('${listItem.rekno}')" class="poista">poista</a>			        	
			        </td>
		        </tr>
		    </c:forEach>		
		</tbody>
	</table>
</form>
<script>
function varmista(rekno){
	if(confirm("Haluatko varmasti poistaa auton "+ rekno + "?")){
		document.location="poistaauto?rekno="+rekno;
	}
}	
</script>
</body>
</html>