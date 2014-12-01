<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporting</title>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
		$("#seeHoursInfo").on("click", function() {
			$("#seeHoursInfo").hide();
			$("#hideHoursInfo").show();
			$("#hoursInfo").hide();
			$.ajax({
				url: "hoursInfo.html",
				type: "post",
				dataType: "xml",
				success: showHours,
				error: function() {
					alert("failed!");
				}
			});
		});
		$("#hideHoursInfo").on("click", function() {
			$("#hoursInfo").hide();
			$("#hideHoursInfo").hide();
			$("#seeHoursInfo").show();
		});
		$("#dateButton").on("click", function() {
			$("#recordInfo").hide();
			$.ajax({
				url: "showRecord.html",
				type: "post",
				dataType: "xml",
				data: {date: $("#selectDate").val()},
				success: showRecord,
				error: function() {
					alert("failed!");
				}
			});
		});
		$("#periodButton").on("click", function() {
			$("#timesheetInfo").hide();
			$.ajax({
				url: "showTimesheet.html",
				type: "post",
				dataType: "xml",
				data: {startDate: $("#startDate").val(),
					   endDate: $("#endDate").val()},
				success: showTimesheet,
				error: function() {
					alert("failed!");
				}
			});
		});
	});
	function showHours(data) {
		$("#remainpto").text($(data).find("remainpto").text());
		$("#usedpto").text($(data).find("usedpto").text());
		$("#earnedot").text($(data).find("ot").text());
		$("#hoursInfo").show();
	}
	function showRecord(data) {
		$("#recordNoRecord").html("");
		$("#recordEntries").empty();
		if ($(data).length==0) {
			$("#recordNoRecord").html("No record for this date.");
		}
		else {
			var date = $(data).find("workDate").text();
			$("#recordEntries").append("<td>"+date+"</td");
			var workHours = $(data).find("workHours").text();
			$("#recordEntries").append("<td>"+workHours+"</td");
			var ptoHours = $(data).find("ptoHours").text();
			$("#recordEntries").append("<td>"+ptoHours+"</td");
			var otHours = $(data).find("otHours").text();
			$("#recordEntries").append("<td>"+otHours+"</td");	
			$("#recordInfo").show();
		}
	}
	function showTimesheet(data) {
		$("#timesheetNoRecord").html("");
		$("#timesheetInfo").empty();
		var val=$("input.option:radio[name='showOption']:checked").val();
		if ($(data).length==0) {
			$("#timesheetNoRecord").html("No record for this period.");
		}
		else if (val=="showAll") {
			$("#timesheetInfo").append("<tr><th>Date</th>"+"<th>Worked Hours</th>"+
			"<th>Used PTO Hours</th><th>OT Earned</th></tr>");
			$(data).find("record").each(function() {
				var row = "<tr>";
				var date = $(this).find("workDate").text();
				row = row + "<td>" + date + "</td>";
				var workHours = $(this).find("workHours").text();
				row = row + "<td>" + workHours + "</td>";
				var ptoHours = $(this).find("ptoHours").text();
				row = row + "<td>" + ptoHours + "</td>";
				var otHours = $(this).find("otHours").text();
				row = row + "<td>" + otHours + "</td>";
				row = row + "</tr>";
				$("#timesheetInfo").append(row);
			});	
			$("#timesheetInfo").show();
		}
		else if (val=="showPto") {
			$("#timesheetInfo").append("<tr><th>Date</th><th>Used PTO Hours</th>");
			$(data).find("record").each(function() {
				var ptoHours = $(this).find("ptoHours").text();
				if (ptoHours!=0) {
					var row = "<tr>";
					var date = $(this).find("workDate").text();
					row = row + "<td>" + date + "</td>";
					row = row + "<td>" + ptoHours + "</td>";
					$("#timesheetInfo").append(row);
				}
			});
			$("#timesheetInfo").show();
		}
		else if (val=="showOt") {
			$("#timesheetInfo").append("<tr><th>Date</th><th>OT Earned</th>");
			$(data).find("record").each(function() {
				var otHours = $(this).find("otHours").text();
				if (otHours!=0) {
					var row = "<tr>";
					var date = $(this).find("workDate").text();
					row = row + "<td>" + date + "</td>";
					row = row + "<td>" + otHours + "</td>";
					$("#timesheetInfo").append(row);
				}
			});
			$("#timesheetInfo").show();
		}
		else if (val=="showPaid") {
			$("#timesheetInfo").append("<tr><th>Date</th><th>Paid Hours</th>");
			$(data).find("record").each(function() {
				var row = "<tr>";
				var date = $(this).find("workDate").text();
				row = row + "<td>" + date + "</td>";
				var workHours = Number($(this).find("workHours").text());
				var ptoHours = Number($(this).find("ptoHours").text());
				var paidHours = workHours + ptoHours;
				row = row + "<td>" + paidHours + "</td>";
				$("#timesheetInfo").append(row);
			});
			$("#timesheetInfo").show();
		}
	}
</script>
<style>
	table,th,td {
		border: 1px solid black;
		border-collapse: collapse;
	}
	th, td {
    	padding: 5px;
    	text-align: left;
	}
	table#timesheetInfo tr:nth-child(even) {
    	background-color: #eee;
	}
	table#timesheetInfo tr:nth-child(odd) {
   		background-color:#fff;
	}
	table#timesheetInfo th	{
    	background-color: black;
    	color: white;
	}
</style>
</head>
<body>
<a href="main.html">Go back to input page</a>
<br/>
<br/>
<a href="<c:url value='/j_spring_security_logout'/>">Logout</a>
<br/>
<br/>
<button type="button" id="seeHoursInfo">Show PTO and OT</button>
<button type="button" id="hideHoursInfo" style="display:none">Hide PTO and OT</button>
<table id="hoursInfo" style="display:none">
	<tr>
		<td>Remaining PTO</td>
		<td id="remainpto"></td>
	</tr>
	<tr>
		<td>Used PTO</td>
		<td id="usedpto"></td>
	</tr>
	<tr>
		<td>Earned OT</td>
		<td id="earnedot"></td>
	</tr>
</table>

<div>
<p>Timesheet for a specific date:</p>
<p>Select date: <input id="selectDate" type="date" name="date"/>
<button type="button" id="dateButton">Submit</button>
</p>
<p id="recordNoRecord"></p>
<table id="recordInfo" style="display:none">
	<tr>
		<th id="workDate">Date</th>
		<th id="workHours">Worked Hours</th>
		<th id="ptoUsage">Used PTO Hours</th>
		<th id="ot">OT Earned</th>
	</tr>
	<tr id="recordEntries">
	</tr>
</table>

<p>Timesheet for a period of time:</p>
<p>Start date: <input id="startDate" type="date" name="startDate"/>
End date: <input id="endDate" type="date" name="endDate"/>
</p>
<p>
<input class="option" type="radio" name="showOption" value="showAll" checked/>Show All
<input class="option" type="radio" name="showOption" value="showPto"/>Show PTO Used
<input class="option" type="radio" name="showOption" value="showOt"/>Show OT Earned
<input class="option" type="radio" name="showOption" value="showPaid"/>Show Paid Hours
</p>
<p>
<button type="button" id="periodButton">Submit</button>
</p>
<p id="timesheetNoRecord"></p>
<table id="timesheetInfo" style="display:none">
</table>
</div>
</body>
</html>