<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title> Add New Subject </title>
</head>
<body> <pre>

<?php

//Code by Matt McCullough

if(isset($_POST['insert'])) {

  $m = new MongoDB\Driver\Manager("mongodb://joerockhead:875423@localhost:27017/joerockhead");

  #----------
      #this function returns the next sequential subject id (USUBJID)
      function getDM ( $m ) {
          $query = new MongoDB\Driver\Query( [] );
          $rows  = $m->executeQuery( "joerockhead.DM", $query );
          $count = 0;
          foreach ($rows as $r) {
              ++$count;
          }
          return $count + 1;
      }
      #----------

  //inserting the new subject you add
      $bulk = new MongoDB\Driver\BulkWrite();
      $usubjid = getDM( $m );
      $dob = new DateTime( $_POST['dob'] );
      $_id = $bulk->insert([
                      'STUDYID'   => $_POST['studyid'],
                      'DOMAIN'   => 'DM',
                      'USUBJID'    => $usubjid,
                      'BRTHDTC'  => $dob->format( DateTime::ATOM ),  # ISO8601
                      'SEX'            => $_POST['sex'],
                      'RACE'         => $_POST['race'],
                      'COUNTRY' => $_POST['country'] ]);

      $result = $m->executeBulkWrite( 'joerockhead.DM', $bulk );

      echo "successfully inserted!";

}

?>
</pre>

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
<input type = "submit" class="btn btn-success" name ="insert" value ="Insert into DB"/><br>
</form>


</body>
</html>
