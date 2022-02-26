<!DOCTYPE html>
<html>
<title>Hospital DB Project</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {background-image: url('webb.png'); font-family: "Times New Roman", Georgia, Serif;}
h1, h2, h3, h4, h5, h6 {
  font-family: "Playfair Display";
  letter-spacing: 5px;
}
.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  text-align: center;
}

</style>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
$(document).ready(function()
{
   setInterval(function() {$("#doctorData").load("loadDoctors.php");}, 5000);
});
</script>

</head>



<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <!-- Right-sided navbar links. Hide them on small screens -->
    <!-- change href to seperate html files -->
    <div class="w3-right w3-hide-small">
      <a href="index.html" class="w3-bar-item w3-button">Home Page</a>
      <a href="about.html" class="w3-bar-item w3-button">More About Us</a>
      <a href="appointments.php" class="w3-bar-item w3-button">Schedule an Appointment</a>
      <a href="records.php" class="w3-bar-item w3-button">View Patient Records</a>
      <a href="visit.php" class="w3-bar-item w3-button">Schedule a Visit with a Patient</a>
    </div>
  </div>
</div>

  <hr>

</hr>

<img class="center" src="https://cdn.sanity.io/images/0vv8moc6/hcplive/c6a1bdd525a3983c7e0503b6cd7da08fb02b7980-483x288.jpg" alt="Doctor" width="500" height="400">
<h1 class="center">Appointment Scheduler</h1><br>
<h5 class="center">This is where you can schedule an appointment</h5>
<p class="center">Please put a time and your name to schedule you with your doctor</p>
<p class="center"><b>Friendly reminder that our hours are from 8am - 11pm</b></p>



<div id = "doctorData"></div>

<form action="addDoctor.php">
<input type="submit" style="float: right;" value="Add New Doctor" />
</form>

<br>

<p><strong>Submit</strong> an appointment form before coming in:</p>


<label for="patient"><b>Patient Name</b></label>
<form action="scheduleAppointment.php" target="_blank">
      <?php

      include 'connection.php'; // establish connection


       $sql = "SELECT fName, lName from patient ORDER BY fName";
       $result = $conn->query($sql);

      echo "<select name='patient'>";
      while ($row = $result->fetch_assoc()) {
          $fullName = $row[fName] . " " . $row[lName];
          echo "<option value='" . $fullName . "'>" . $fullName . "</option>";
      }
      echo "</select>";

      ?>
      <p><input id = "dt" class="w3-input w3-padding-16 w3-border" type="datetime-local" placeholder="Appointment Date and time" required name="date" value="2021-12-01T20:00"></p>
      <p><button class="w3-button w3-black" type="submit">SUBMIT APPOINTMENT REQUEST</button></p>
    </form>


<script>$("#doctorData").load("loadDoctors.php");</script>

<script>
var now = new Date();
now.setMinutes(now.getMinutes() - now.getTimezoneOffset());
document.getElementById('dt').value = now.toISOString().slice(0,16);
document.getElementById('dt').min = now.toISOString().slice(0,16);
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
