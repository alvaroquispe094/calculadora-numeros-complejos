$(document).ready(function(){
	$("#btnCalcular").on('click', function(){
		console.log("entro en el bind");
		
		$.ajax({
			type: "GET",
			url: '/calcular',
			async: false,
			data: {sgn1: $("#sgn1").val(),
				sgn2: $("#sgn2").val(),
				sgn3: $("#sgn3").val(),
				sgn4: $("#sgn4").val(),
				n1: $("#n1").val(),
				n2: $("#n2").val(),
				n3: $("#n3").val(),
				n4: $("#n4").val(),
				op: $("#op").val()},
			
			success: function(data){
				
				$("#resultado").show();
				$("#resultado p").html(data);
				
			},
			 error: function(XMLHttpRequest, textStatus, errorThrown) { 
	             alert("Status: " + textStatus); alert("Error: " + errorThrown); 
	         } 
		});
		
	});
});	