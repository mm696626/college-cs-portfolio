<?php

            include 'connection.php'; // establish connection


            $sql = "SELECT doctor.iddoctor, fName, lName, image, department_type, department_location from doctor
                    left join department
                    on doctor.department_id = department.department_id";

            $result = $conn->query($sql);

            if ($result -> num_rows > 0) {
                echo "    <table class='table table-hover'>
                          <tbody>
                          <tr>
			      <td><b>Doctor ID</b></td>
                              <td><b>Name</b></td>
                              <td><b>Department</b></td>
                              <td><b>Department Location</b></td>
                              <td><b>Image</b></td>
                          </tr>
                      ";

                // output data of each row
                while ($row = $result->fetch_assoc()) {
                    echo "<tr>
			                      <td>$row[iddoctor]</td>
                            <td>$row[fName] $row[lName]</td>
                            <td>$row[department_type]</td>
                            <td>$row[department_location]</td>
                         ";
                    echo '<td><img src="data:image;base64,'.base64_encode($row['image']) .'" alt="no image" style="width:100px;height:100px;" ></td>';
                    echo "</tr>";
                }
                echo "</tbody></table>";


            }else {
                echo "<p class='lead'> No results available </p>";
            }
            $conn->close();


?>
