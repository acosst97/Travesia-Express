


window.onload = function() {

var chart = new CanvasJS.Chart("chartContainer", {
    theme: "light2", // "light1", "light2", "dark1", "dark2"
    exportEnabled: true,
    animationEnabled: true,
    title: {
        text: "ventas realizadas  "
    },
    data: [{
        type: "pie",
        startAngle: 25,
        toolTipContent: "<b>{label}</b>: {y}%",
        showInLegend: "true",
        legendText: "{label}",
        indexLabelFontSize: 16,
        indexLabel: "{label} - {y}%",
        dataPoints: [
            { y: 51.08, label: "enero" },
            { y: 27.34, label: "febrero" },
            { y: 10.62, label: "marzo" },
            { y: 5.02, label: "abril" },
            { y: 4.07, label: "mayo" },
            { y: 1.22, label: "junio" },
            { y: 0.44, label: "julio" }
        ]
    }]
  });
  chart.render();

}

