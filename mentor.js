$("#filer-change").click(function(){
    var graph = $("#select-graph").val();
	console.log(graph);
    var grade = $("#grade").val();
    
    if (graph.includes("continuation")) {
        mentor_contin();
    } else {
        mentor_reason();
    }
});

var mentor_contin = function () {
    console.log("mentor-contin");
    google.charts.load('current', {packages: ['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {

        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Mentor-comment');
        data.addColumn('number', 'Count');
        data.addRows([
            ['Yes', 75],
            ['No', 30],
			['Maybe', 45]
        ]);

        var options = {
            title: 'Mentor Continuation Count',
            hAxis: {
                title: 'Decision'
            },
            vAxis: {
                title: 'Count'
            }
        };

        var chart = new google.visualization.ColumnChart(
            document.getElementById('mentorstudent-count'));

        chart.draw(data, options);
    }
}


var mentor_reason = function () {
    console.log("Mentor called");
    google.charts.load('current', {packages: ['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {

        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Mentor reason for continuation');
        data.addColumn('number', 'Count');
        data.addRows([
            ['Alumni', 35],
            ['Interest', 60],
			['Partnership', 54]
        ]);

        var options = {
            title: 'Mentor Interest for Continuation Count',
            hAxis: {
                title: 'Mentor reason for continuation'
            },
            vAxis: {
                title: 'Count'
            }
        };

        var chart = new google.visualization.ColumnChart(
            document.getElementById('mentorstudent-count'));

        chart.draw(data, options);
    }
}
