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
      $("#input_weekly").show();
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
          $("#input_field").html("<div>Worked Hour: <input id='input_tag' name='worked hour' type='text' value='8'></div>");
          $("#input_field").prepend("<div>please input hours worked for <div id='detail_date'>"+date.format()+"</div></div>");
          var hour_in_target_date = $("#hour_in_"+date.format()).html();
          if(hour_in_target_date != undefined) {
          	$("#input_tag").val(hour_in_target_date);
          }
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
      $("#submit_form").on("click", function() {
        $(".fc-day").each(function() {
          var txt = $(this).text();
          var date = $(this).attr("data-date");
          var time = $(this).find("#hour_in_"+date).text();
          alert(time);
        });
      });
    });
  });
</script>
</head>
<body>
	<div>
		<div>
			<button id="input_week">input by week</button>
		</div>
		<div>input by month</div>
		<div>see report</div>
	</div>
	<div id="input_weekly" style="display: none">
		<div id="weekly" style="float: left; width: 70%; height: 30%"></div>
		<div id="input_field" style="position: absolute; bottom:40%; right:0%; width: 30%; height: 30%">
		</div>
		<button id="submit_form" style="position: absolute; bottom:30%">Submit</button>		
	</div>
</body>
</html>