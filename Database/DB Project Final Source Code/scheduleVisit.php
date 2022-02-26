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

  <br>
  <br>
  <br>
  
<?php



            //delete all old visits
            include 'connection.php'; // establish connection
            $sql = "DELETE FROM visitor WHERE visitDate < (NOW() - INTERVAL 1 DAY)";
            $result = $conn->query($sql);
            $conn->close();



            include 'connection.php'; // establish connection


            $patientName = $_GET["patient"];

            //split name string
            $temp = explode(" ", $patientName);

            $patientFirstName =  $temp[0]; // first name of patient
            $patientLastName = $temp[1]; // last name of patient


            //get patient id

            $sql = "SELECT idpatient FROM patient WHERE fName = " . "'" . $patientFirstName . "'" . " AND " . "lName = " . "'" . $patientLastName . "'" . " LIMIT 1";


            $result = $conn->query($sql);


            $patientID = 0;

            if ($result -> num_rows > 0) {


                while ($row = $result->fetch_assoc()) {
                    $patientID = $row[idpatient];
                }

            }else {
                echo "<p class='lead'> No results available </p>";
            }
            $conn->close();




            //actually do visitor stuff now

            //visitor data
            $firstName = $_GET["fName"];
            $lastName = $_GET["lName"];
            $date = $_GET["date"];

            $date = str_replace("T", " ", $date);

            include 'connection.php'; // establish connection

            $sql = "CALL checkVisitor(" . $patientID . ", '" . $firstName . "' , '" . $lastName . "' , '" . $date . "')";

            $result = $conn->query($sql);


            if ($result) {
                echo "<p class='lead'> Successfully made a visit appointment! See you then! :)</p>";

            }else {
              echo "<p class='lead'> Sorry, your visit couldn't be made! Please try again! </p>";
              echo($conn -> error);
            }


            $conn->close();
?>

</body>
</html>
