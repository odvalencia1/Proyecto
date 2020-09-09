function searchByNombre(){
	var criteria = $("#txtNombre").val();
	$.ajax({
		url : "/artista/search/" + criteria+"/",
		method : 'GET',
		success : function(response){
			$("#artistaid").empty();			
			var count = 1;			
			if(count > 0){								
				$("#artistaid").addClass('visible').removeClass('invisible');
				$.each( response, function(index, artista ) {					
					$("#artistaid").append("<option value='"+ artista.idArtista +"'>" + artista.nombreArtistico +  "</option>");					
				});
			}
			else{
				$("#artistaid").addClass('invisible').removeClass('visible');
				console.log("No hay artistas para ese nombre: " + criteria);				
			}			
		},
		error : function(err){
			
			console.error(err);

			console.error(err.responseText);
		}		
	});
}

function create(){		
	$.ajax({
		url : "/invitado/create",
		method : 'GET',
		success : function(response){
			console.log(response);
			$("#contentFrmInvitado").empty();
			$("#contentFrmInvitado").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}
function list(){	
	$.ajax({
		url : "/evento/artis/",
		method : 'GET',
		success : function(response){
			console.log(response);
			$("#listInvitados").empty();
			$("#listInvitados").html(response);
		},
		error : function(err){
			console.log(err.toString());
		}		
	});	
}

function save(){	
	var dataForm = objectifyForm($("#frmInvitado").serializeArray());	
	var requestBody = JSON.stringify(dataForm);
	console.log(requestBody);			
	$.ajax({
		url : developURL + "evento/add",
		method : 'POST',
		contentType : "application/json",
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},		
		data : requestBody,
		success : function(response){
			console.log(response);
			
			list();
		},
		error : function(err){
			console.log(err);
		}		
	});
	
}



$(document).ready(function(){
	
	list();
	
	$("#btnAdd").click(function(){
		create();		
	});
	
	$("#btnSubmit").click(function(){
		save();		
	});
		
});