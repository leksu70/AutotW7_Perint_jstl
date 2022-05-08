<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="scripts/main.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Insert title here</title>
</head>
<body>
<form id="tiedot" action="muutaauto" method="post">
	<table>
		<thead>	
			<tr>
				<th colspan="5" class="oikealle"><a href="listaaautot.jsp">Takaisin listaukseen</a></th>
			</tr>		
			<tr>
				<th>RekNo</th>
				<th>Merkki</th>
				<th>Malli</th>
				<th>Vuosi</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" name="rekno" id="rekno" value="${auto.rekno}"></td>
				<td><input type="text" name="merkki" id="merkki" value="${auto.merkki}"></td>
				<td><input type="text" name="malli" id="malli" value="${auto.malli}"></td>
				<td><input type="text" name="vuosi" id="vuosi" value="${auto.vuosi}"></td> 
				<td><input type="button" id="tallenna" value="Hyväksy" onclick="tarkasta()"></td>
			</tr>
		</tbody>
	</table>
	<input type="hidden" name="vanharekno" id="vanharekno" value="${auto.rekno}">	
</form>
<span id="ilmo"></span>
</body>
<script>
function tarkasta(){
	var d = new Date();
	if(document.getElementById("rekno").value.length<3){
		document.getElementById("ilmo").innerHTML="Rekisterinumero ei kelpaa!";
		return;
	}else if(document.getElementById("merkki").value.length<2){
		document.getElementById("ilmo").innerHTML="Merkki ei kelpaa!";
		return;
	}else if(document.getElementById("malli").value.length<1){
		document.getElementById("ilmo").innerHTML="Malli ei kelpaa!";
		return;
	}else if(document.getElementById("vuosi").value*1!=document.getElementById("vuosi").value){
		document.getElementById("ilmo").innerHTML="Vuosi ei ole luku!";
		return;
	}else if(document.getElementById("vuosi").value<1900 || document.getElementById("vuosi").value>d.getFullYear()+1){
		document.getElementById("ilmo").innerHTML="Vuosi ei kelpaa!";
		return;
	}
	document.getElementById("rekno").value=siivoa(document.getElementById("rekno").value);
	document.getElementById("merkki").value=siivoa(document.getElementById("merkki").value);
	document.getElementById("malli").value=siivoa(document.getElementById("malli").value);
	document.getElementById("vuosi").value=siivoa(document.getElementById("vuosi").value);
	document.forms["tiedot"].submit();
}

function siivoa(teksti){
	teksti=teksti.replace("<","");
	teksti=teksti.replace(";","");
	teksti=teksti.replace("'","''");
	return teksti;
}
</script>
</html>