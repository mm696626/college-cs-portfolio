<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>
Subject Information
</title>
</head>
<body> <pre>

<?php

//Code by Matt McCullough

if (isset($_POST['update'])) {

  #updating subject information
      $m = new MongoDB\Driver\Manager("mongodb://joerockhead:875423@localhost:27017/joerockhead");
      $bulk = new MongoDB\Driver\BulkWrite();

      $updateID = $_POST['updateID']; //get ID of subject from hidden field

      $dob = new DateTime( $_POST['dob'] );

      $_id = $bulk->update(['USUBJID' => intval($updateID)], [
                      'STUDYID'   => $_POST['studyid'],
                      'DOMAIN'   => 'DM',
                      'USUBJID'    => intval($_POST['updateID']),
                      'BRTHDTC'  => $dob->format( DateTime::ATOM ),  # ISO8601
                      'SEX'            => $_POST['sex'],
                      'RACE'         => $_POST['race'],
                      'COUNTRY' => $_POST['country'] ]);
      $result = $m->executeBulkWrite( 'joerockhead.DM', $bulk );

      echo "successfully updated!";

}

if (isset($_POST['delete'])) {

  //delete all information relating to subject (it "cascades")

  $m = new MongoDB\Driver\Manager("mongodb://joerockhead:875423@localhost:27017/joerockhead");

  $deleteID = $_POST['deleteID']; //get ID of subject from hidden field

  $bulk = new MongoDB\Driver\BulkWrite();
  $_id = $bulk->delete(['USUBJID' => intval($deleteID)]);
  $result = $m->executeBulkWrite( 'joerockhead.SV', $bulk );

  $bulk = new MongoDB\Driver\BulkWrite();
  $_id = $bulk->delete(['USUBJID' => intval($deleteID)]);
  $result = $m->executeBulkWrite( 'joerockhead.CO', $bulk );

  $bulk = new MongoDB\Driver\BulkWrite();
  $_id = $bulk->delete(['USUBJID' => intval($deleteID)]);
  $result = $m->executeBulkWrite( 'joerockhead.DM', $bulk );

  echo "successfully deleted!";
}

    //get subject data from _id
    $m = new MongoDB\Driver\Manager("mongodb://joerockhead:875423@localhost:27017/joerockhead");
    $id = new \MongoDB\BSON\ObjectId($_GET['id']);
    $query = new MongoDB\Driver\Query( ['_id' => $id]);
    $rows  = $m->executeQuery( "joerockhead.DM", $query );

    //checks to draw the table header and the hyperlinks to comment and visit pages
    $drawHeader = False;
    $viewLinks = False;

    //print data to table
    foreach ($rows as $r) {

        if ($drawHeader == False) {
          echo "    <table class='table table-dark'>
                    <tbody>
                    <tr>
                        <td><b>Study ID</b></td>
                        <td><b>Domain</b></td>
                        <td><b>USUBJID</b></td>
                        <td><b>BRTHDTC</b></td>
                        <td><b>Sex</b></td>
                        <td><b>Race</b></td>
                        <td><b>Country</b></td>
                    </tr>
                ";

            $drawHeader = True;
        }

        echo "<tr>
                <td>$r->STUDYID</td>
                <td>$r->DOMAIN</td>
                <td>$r->USUBJID</td>
                <td>$r->BRTHDTC</td>
                <td>$r->SEX</td>
                <td>$r->RACE</td>
                <td>$r->COUNTRY</td>
             ";
        echo "</tr>";
        echo "</tbody></table>";

        $usubjid = $r->USUBJID;

        if ($viewLinks == False) {
          echo "<a href = '" . "comment982419.php?id=" . $usubjid . "'" . ">" . "View Comments" . "</a><br>";
          echo "<a href = '" . "visit628529.php?id=" . $usubjid . "'" . ">" . "View Visits" . "</a><br>";
          $viewLinks = True;
        }
    }

?>
</pre>

<h1>DM Info Updater</h1><br>

<form action="" method = "post">
<label>Study ID</label><br>
<input type = "text" name ="studyid" id="studyid" placeholder = "1" required/> <br>
<label>Birth Date</label><br>
<input type = "date" name ="dob" id="dob" required/> <br>
<label>Sex</label><br>
<input type = "text" name ="sex" id="sex" placeholder = "M" maxlength="1" required/> <br>
<label>Race</label><br>
<input type = "text" name ="race" id="race" placeholder = "caucasian" required/> <br>
<label>Country</label><br>
<input type = "text" name ="country" id="country" placeholder = "USA" minlength="3" maxlength="3" required/> <br>
<input type = "submit" class="btn btn-success" name ="update" value ="Update Information"/><br>
<input type="hidden" name="updateID" value="<?php echo $usubjid;?>">
</form>


<h1>Delete All Information for this Subject</h1><br>

<form action="" method = "post">
<input type = "submit" class="btn btn-danger" name ="delete" value ="Delete Information"/><br>
<input type="hidden" name="deleteID" value="<?php echo $usubjid;?>">
</form>


</body>
</html>
