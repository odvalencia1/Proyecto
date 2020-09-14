function report() {
	$.ajax({
		url : "/evento/dataRptEventoMes",
		method : 'GET',
		success : function(response) {
			console.log(response);

			var toData = [];
			var toLabels = [];
			var toColors = [];

			$.each(response, function(i, item) {
				console.log(item);
				toData.push(item.eventos);
				toLabels.push(item.mes);
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
			
			$(document).ready( function() {
				console.log("r");
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
							text: 'Número de eventos por mes'
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

$(document).ready(function() {
	report();
});