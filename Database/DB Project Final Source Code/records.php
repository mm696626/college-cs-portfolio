<!DOCTYPE html>
<html>
<title>Hospital DB Project</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<head>

  <script>
  function showPatient(str) {
    if (str == "") {
      document.getElementById("patientBlank").innerHTML = "";
      return;
    } else {
      var xmlhttp = new XMLHttpRequest();
      xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("patientBlank").innerHTML = this.responseText;
        }
      };
      xmlhttp.open("GET","loadRecords.php?q="+str,true);
      xmlhttp.send();
    }
  }
  </script>
</head>



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

  <h1 class="center">Patient Records</h1><br>
  <h5 class="center">This is where you can view records</h5>
  <p class="center">Please select a patient ID from the list below</p>

  <hr>

  <label for = "pid" > <b>Patient ID</b> </label>

  <form>

      <?php

      include 'connection.php'; // establish connection


       $sql = "SELECT idpatient from patient ORDER BY idpatient";
       $result = $conn->query($sql);

      echo "<select name='pid' onchange='showPatient(this.value)'>";
      while ($row = $result->fetch_assoc()) {
          echo "<option value='" . $row[idpatient] . "'>" . $row[idpatient] . "</option>";
      }
      echo "</select>";
      ?>

  </form>

  <br>
  <br>
  <div id="patientBlank"><b>Patient info will be listed here...</b></div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
