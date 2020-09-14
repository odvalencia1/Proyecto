function report() {
	$.ajax({
		url : "/evento/dataRptEventosArtistas",
		method : 'GET',
		success : function(response) {
			var toData = [];
			var toLabels = [];
			var toColors = [];

			$.each(response, function(i, item) {
				console.log(item);
				toData.push(item.eventos);
				toLabels.push(item.artista);
				toColors.push(getRandomColor());
			});

			var barChartData = {
				labels : toLabels,
				datasets : [ {
					label : 'N° Eventos',
					backgroundColor : getRandomColor(),
					borderColor : getRandomColor(),
					borderWidth : 1,
					data : toData
				} ]

			};
			
			$(document).ready(function() {
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
							text: 'Número de eventos'
						}
					}
				});

			});

		},
		error : function(err) {
			console.log(err);
		}
	});
	
}



$(document).ready(function(){
	report();			
});