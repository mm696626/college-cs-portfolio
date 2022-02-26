<?php
$host = "3.14.51.97"; // localhost
$username = "group_A_user";
$password = "A1_group_A_2021";
$dbname = "group_A_db";

$conn = new mysqli($host, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {

    die("Connection failed: " . $conn->connect_error);

} else {
    // echo "Connected successfully";
}
?>