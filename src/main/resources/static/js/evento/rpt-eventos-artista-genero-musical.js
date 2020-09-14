function report(){
	
	$.ajax({
		url : "/evento/dataRptEventoArtistaGeneroMusical",
		method : 'GET',
		success : function(response){
				
			var toData = [];
			var toLabels = [];
			var toName=[];
			var color = Chart.helpers.color;
			var datos ={};
			
			
			$.each(response, function(i, item){
				$.each(item, function(j, item2){
				console.log(item2);
				toData.push(item2.artistas);
				toLabels.push(item2.genero);
				toName.push(item2.evento);
				});
				datos[i]={toData,toLabels,toName};
				toData=[];
				toLabels=[];
				toName=[];
			});
			
											
			var barChartData = {
				labels: datos[0].toName,
				datasets: []

			};
			
			$.each(datos, function(i, item){
				barChartData.labels.push
				  barChartData.datasets.push(
				    {
				      label: datos[i].toLabels[0],
				      backgroundColor: color(getRandomColor()).alpha(0.5).rgbString(),
				      data: datos[i].toData
				    }
				  )
			});
			
			$(document).ready( function() {
				console.log(response);
				var ctx = document.getElementById('canvas').getContext('2d');
				window.myBar = new Chart(ctx, {
					type: 'bar',
					data: barChartData,
					options: {
						responsive: true,
						legend: {
							position: 'top',
						},
						title: {
							display: true,
							text: 'Número de artistas por eventos, agrupados por genero musical'
						}
					}
				});

			});
			
		},
					
		error : function(err){
			console.log(err);
		}		
	});	
}


$(document).ready(function(){
	
	report();		

	
});
