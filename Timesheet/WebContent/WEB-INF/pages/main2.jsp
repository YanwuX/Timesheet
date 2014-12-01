<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.2.3/fullcalendar.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.2.3/fullcalendar.min.css" />
<title>Time sheet system</title>
<style>
.fc_day {
	z-index: -1
}

.hour_input {
	z-index: 1;
}
.selected {
	background-color: red;
}
</style>
<script type="text/javascript">
  $(document).ready(function() {
    $("#input_week").on("click", function() {
      $("#input_monthly").hide();
      $("#input_weekly").show();
      $("#weekly").fullCalendar('destroy');
      $("#monthly").fullCalendar('destroy');
      $("#weekly").fullCalendar({
        header: {
          left: 'prev,next today',
          center: 'title',
          right: ''
        },
        defaultView: 'basicWeek',
        height: 150,
        dayClick: function(date, jsEvent, view) {
          $(".fc-day").removeClass("selected");
          $("#input_field").html("Worked Hour: <input id='input_tag' name='worked hour' type='text' value='8'></div>");
          $("#input_field").prepend("<div>please input hours worked for <div id='detail_date'>"+date.format()+"</div></div>");
          var hour_in_target_date = $("#hour_in_"+date.format()).html();
          if(hour_in_target_date != undefined) {
          	$("#input_tag").val(hour_in_target_date);
          }
          $.ajax({
      			url: "showRecord.html",
      			type: "post",
      			dataType: "xml",
      			data: {date:date.format()},
      			success: function(data) {
      			  var workHour = $(data).find("workHours").text();
      		      var ptoHour = $(data).find("ptoHours").text();
      		      var otHour = $(data).find("otHours").text();
      		      $("#input_field").prepend("<div>worked hour: "+workHour+"</div><div>Used PTO: "+ptoHour+"</div><div>OT hour: "+otHour+"</div>");
      			}
      	  });
          // change the day's background color just for fun
          $(this).addClass("selected");
          $("#input_tag").on("blur", function() {
            var hours = $("#input_tag").val();
            var detail_date = $("#detail_date").text();
            $("td[data-date='"+detail_date+"']").html("Work Hour: <div id='hour_in_"+detail_date+"'>"+hours+"</div>");
          });
        }
      });
      $(".fc-day").html("Work Hour: ");
    });
    $("#input_month").on("click", function() {
      $("#input_weekly").hide();
      $("#input_monthly").show();
      $("#weekly").fullCalendar('destroy');
      $("#monthly").fullCalendar('destroy');
      $("#monthly").fullCalendar({
        header: {
          left: 'prev,next today',
          center: 'title',
          right: ''
        },
        dayClick: function(date, jsEvent, view) {
          $(".fc-day").removeClass("selected");
          $("#input_mon_field").html("Worked Hour: <input id='input_mon_tag' name='worked hour' type='text' value='8'></div>");
          $("#input_mon_field").prepend("<div>please input hours worked for <div id='detail_mon_date'>"+date.format()+"</div></div>");
          var hour_in_target_date = $("#hour_in_mon_"+date.format()).html();
          if(hour_in_target_date != undefined) {
          	$("#input_mon_tag").val(hour_in_target_date);
          }
          $.ajax({
      			url: "showRecord.html",
      			type: "post",
      			dataType: "xml",
      			data: {date:date.format()},
      			success: function(data) {
      			  var workHour = $(data).find("workHours").text();
      		      var ptoHour = $(data).find("ptoHours").text();
      		      var otHour = $(data).find("otHours").text();
      		      $("#input_mon_field").prepend("<div>worked hour: "+workHour+"</div><div>Used PTO: "+ptoHour+"</div><div>OT hour: "+otHour+"</div>");
      			}
      	  });
          // change the day's background color just for fun
          $(this).addClass("selected");
          $("#input_mon_tag").on("blur", function() {
            var hours = $("#input_mon_tag").val();
            var detail_date = $("#detail_mon_date").text();
            $("td.fc-day[data-date='"+detail_date+"']").html("<br/><br/>Work Hour: <div id='hour_in_mon_"+detail_date+"'>"+hours+"</div>");
          });
        }
      });
      $(".fc-day").html("<br/><br/>Work Hour: ");
    });
    $("#submit_mon_form").on("click", function() {
      var myArray = [];
      $(".fc-day").each(function() {
        var txt = $(this).text();
        var date = $(this).attr("data-date");
        var time = $(this).find("#hour_in_mon_"+date).text();
        myArray.push(time);
      });
      alert(myArray);
    });
    $("#submit_form").on("click", function() {
      var myArray = [];
      $(".fc-day").each(function() {
        var txt = $(this).text();
        var date = $(this).attr("data-date");
        var time = $(this).find("#hour_in_"+date).text();
        myArray.push(time);
      });
      alert(myArray);
    });
  });
</script>
</head>
<body>
	<div>
		<div>
			<button id="input_week">input by week</button>
		</div>
		<div>
			<button id="input_month">input by month</button>
		</div>
		<div>see report</div>
	</div>
	<div id="input_weekly" style="display: none">
		<div id="weekly" style="float: left; width: 70%; height: 30%"></div>
		<div id="input_field" style="float:right; width: 30%; height: 30%">
		</div>
		<button id="submit_form">Submit</button>		
	</div>
	<div id="input_monthly" style="display: none">
		<div id="monthly" style="float: left; width: 70%; height: 30%"></div>
		<div id="input_mon_field" style="float:right; width: 30%; height: 30%">
		</div>
		<button id="submit_mon_form">Submit</button>	
	</div>
</body>
</html>