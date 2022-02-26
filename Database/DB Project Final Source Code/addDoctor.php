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

<h1 class="center">Doctor Adder</h1><br>



<form action="" method = "post" enctype = "multipart/form-data">
<label>ID</label><br>
<input type = "text" name ="id" id="id" placeholder = "1"/> <br>
<label>First Name</label><br>
<input type = "text" name ="fname" id="fname" placeholder = "Patrick"/> <br>
<label>Last Name</label><br>
<input type = "text" name ="lname" id="lname" placeholder = "Star"/> <br>
<label>Department</label><br>
<input type = "text" name ="department" id="department" placeholder = "1"/> <br>
<label>Image</label><br>
<input type = "file" name ="image" id="image" /> <br>
<input type = "submit" name ="upload" value ="Upload to DB"/><br>
</form>


<h1 class="center">Doctor Image Updater</h1><br>


<form action="" method = "post" enctype = "multipart/form-data">
<label>ID to Update</label><br>
<input type = "text" name ="updateid" id="updateid" placeholder = "1"/> <br>
<input type = "file" name ="updateimage" id="updateimage" /> <br>
<input type = "submit" name ="update" value ="Update in DB"/><br>
</form>

<?php
if(isset($_POST['upload'])) {
            include 'connection.php'; // establish connection


            $file = addslashes(file_get_contents($_FILES['image']['tmp_name']));
            $id = $_POST["id"];
            $fname = $_POST["fname"];
            $lname = $_POST["lname"];
            $department = $_POST["department"];

            if ($_FILES['image']['size'] == 0 && $_FILES['image']['error'] == 0)
            {
                $file = NULL; //null for no image
            }

            $sql = "INSERT INTO doctor VALUES ('$id', '$fname', '$lname', '$file', '$department')";

            $result = $conn->query($sql);

            $conn->close();
}

if(isset($_POST['update'])) {
            include 'connection.php'; // establish connection

            $file = addslashes(file_get_contents($_FILES['updateimage']['tmp_name']));
            $id = $_POST["updateid"];

            if ($_FILES['updateimage']['size'] == 0 && $_FILES['updateimage']['error'] == 0)
            {
                $file = NULL; //null for no image
            }


            $sql = "UPDATE doctor SET image = '" . $file . "' WHERE iddoctor = " . $id;

            $result = $conn->query($sql);

            $conn->close();
}

          ?>





</body>
</html>
