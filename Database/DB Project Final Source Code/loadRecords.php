<?php
    $msg="";

        $pid = intval($_GET['q']);


            include 'connection.php';

            $sql = "SELECT * from patient
            inner join patientRecord on patient.patientRecord_idpatientrecord = patientRecord.idpatientrecord
            where patient.idpatient = $pid";

            $result = $conn->query($sql);


            if ($result -> num_rows > 0) {
                echo " <table class='table table-hover'>
                          <tbody>
                          <tr>
                              <td>Patient ID</td>
                              <td>First Name</td>
                              <td>Last Name</td>
                              <td>Address</td>
                              <td>Insurance</td>
                              <td>Phone Number</td>
                              <td>Date of Birth</td>
                              <td>Blood Type</td>
                          </tr>
                      ";

                // output data of each row
                while ($row = $result->fetch_assoc()) {
                    echo "<tr>
                            <td>$row[idpatient] </td>
                            <td>$row[fName] </td>
                            <td>$row[lName] </td>
                            <td>$row[address]</td>
                            <td>$row[insurance]</td>
                            <td>$row[phoneNumber] </td>
                            <td>$row[DOB] </td>
                            <td>$row[bloodType] </td>
                          </tr>
                         ";
                }
                echo "</tbody></table>";

            }
            else {
                echo "<p class='lead'> No results available </p>";
            }
            $conn->close();






?>
