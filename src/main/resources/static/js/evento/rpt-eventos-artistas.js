var ctx = document.getElementById('chart-area').getContext('2d');

function report(){
	$.ajax({
		url: "/evento/dataRptEventosArtistas",
		method: 'GET',
		success : function(response){
			console.log("Data: ");
			console.log(response);
			
			var data ={	};
			var labels = response.map((item)=>item.artista);
			
			
			var datasets = [1,2];
			var labels = ['Colonial', 'Garles'];
			
			var barChartData = {
					labels: labels,
					datasets: datasets

			};
			
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
						text: 'Estudiantes matriculados por usuarios'
					},
					scales:{
						yAxes: [{
							ticks: {
								beginAtZero:true
							}
						}]
					}
					
				}
			});
			
			
		}
	});
}


$(document).ready(function(){
	report();			
});