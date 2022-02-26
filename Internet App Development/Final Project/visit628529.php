<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Visit Viewer</title>
</head>
<body> <pre>

<?php

//Code by Matt McCullough

if (isset($_POST['insertVisit'])) {

  #----------
  #this function returns the next sequential visit number (VISITNUM)
  # for a given subject (USUBJID)
  function getSV ( $m, $usubjid ) {
      $query = new MongoDB\Driver\Query( ['USUBJID' => $usubjid ] );
      $rows  = $m->executeQuery( "joerockhead.SV", $query );
      $count = 0;
      foreach ($rows as $r) {
          ++$count;
      }
      return $count + 1;
  }
  #----------


      $m = new MongoDB\Driver\Manager("mongodb://joerockhead:875423@localhost:27017/joerockhead");
      $usubjid = intval($_POST['visitID']);

      //inserting new visit for the subject selected
      $bulk = new MongoDB\Driver\BulkWrite();
      $visitnum = getSV( $m, $usubjid );
      $now     = new DateTime( date("Y-m-d H:i:s") );
      $svendtc = new DateTime( date("Y-m-d H:i:s") );
      $svendtc->modify( '+1 hour' );
      $_id = $bulk->insert([
                      'STUDYID'    => rand(10000, 99999),
                      'DOMAIN'   => 'SV',
                      'USUBJID'    => $usubjid,
                      'VISITNUM' => $visitnum,
                      'VISIT'          => $_POST['visit'],
                      'SVSTDTC'   => $now->format( DateTime::ATOM ),
                      'SVENDTC'  => $svendtc->format( DateTime::ATOM ) ]);

      $result = $m->executeBulkWrite( 'joerockhead.SV', $bulk );

      echo "successfully made a new visit!";

}

  $m = new MongoDB\Driver\Manager("mongodb://joerockhead:875423@localhost:27017/joerockhead");
  $id = $_GET['id'];
  $query = new MongoDB\Driver\Query(['USUBJID' => intval($id)]);
  $rows  = $m->executeQuery( "joerockhead.SV", $query );

  $drawHeader = False;


  foreach ($rows as $r) {

    if ($drawHeader == False) {
      echo "    <table class='table table-dark'>
                <tbody>
                <tr>
                    <td><b>Study ID</b></td>
                    <td><b>Domain</b></td>
                    <td><b>Visit Number</b></td>
                    <td><b>Visit Reason</b></td>
                    <td><b>Visit Date</b></td>
                    <td><b>Visit End Date</b></td>
                </tr>
                ";
       $drawHeader = True;
    }
    echo "<tr>
          <td>$r->STUDYID</td>";
    echo "<td>$r->DOMAIN</td>";
    echo "<td>$r->VISITNUM</td>";
    echo "<td>$r->VISIT</td>";
    echo "<td>$r->SVSTDTC</td>";
    echo "<td>$r->SVENDTC</td>";
    echo "</tr>";
  }

  echo "</tbody></table>";
?>
</pre>

<h1>Insert New Visit for this Subject</h1><br>

<form action="" method = "post">
<label>Visit</label><br>
<input type = "text" name ="visit" id="visit" placeholder = "Put visit information here....." required/> <br>
<input type="hidden" name="visitID" value="<?php echo $_GET['id']?>">
<input type = "submit" name ="insertVisit" value ="Insert New Visit"/><br>
<intp
</form>

</body>
</html>
