<!DOCTYPE html>
<html>
<title>Hospital DB Project</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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

  <br>
  <h1 class="center">Visit Scheduler</h1><br>
  <h5 class="center">This is where you can schedule a visit with a patient</h5>
  <p class="center">Please select a patient to visit</p>
  <p class="center"><b>Friendly reminder that our hours are from 8am - 11pm</b></p>


  <hr>


<label for="patient"><b>Patient Name</b></label>



<form action="scheduleVisit.php" target="_blank">
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
      <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Put Visitor First Name here..." required name="fName"></p>
      <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Put Visitor Last Name here..." required name="lName"></p>
      <p><input id = "dt" class="w3-input w3-padding-16 w3-border" type="datetime-local" placeholder="Appointment Date and time" required name="date" value="2021-12-01T20:00"></p>
      <p><button class="w3-button w3-black" type="submit">SUBMIT VISIT REQUEST</button></p>
    </form>

    <script>
    var now = new Date();
    now.setMinutes(now.getMinutes() - now.getTimezoneOffset());
    document.getElementById('dt').value = now.toISOString().slice(0,16);
    document.getElementById('dt').min = now.toISOString().slice(0,16);
    </script>



</body>
</html>
