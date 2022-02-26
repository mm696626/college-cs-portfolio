<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Comment Viewer</title>
</head>
<body> <pre>

<?php

//Code by Matt McCullough

if (isset($_POST['insertComment'])) {

  #----------
  #this function returns the next sequential comment number (COSEQ)
  # for a given subject (USUBJID)
  function getCO ( $m, $usubjid ) {
      $query = new MongoDB\Driver\Query( ['USUBJID' => $usubjid ] );
      $rows  = $m->executeQuery( "joerockhead.CO", $query );
      $count = 0;
      foreach ($rows as $r) {
          ++$count;
      }
      return $count + 1;
  }


    //insert new comment for subject selected
      $m = new MongoDB\Driver\Manager("mongodb://joerockhead:875423@localhost:27017/joerockhead");
      $usubjid = intval($_POST['commentID']);

      $bulk = new MongoDB\Driver\BulkWrite();
      $coseq = getCO( $m, $usubjid );
      $now = new DateTime( date("Y-m-d H:i:s") );
      $_id = $bulk->insert([
                      'STUDYID'  => rand(10000, 99999),
                      'DOMAIN'  => 'CO',
                      'USUBJID'   => $usubjid,
                      'COSEQ'     => $coseq,
                      'COVAL'     => $_POST['comment'],
                      'CODTC'     => $now->format( DateTime::ATOM ) ]);

      $result = $m->executeBulkWrite( 'joerockhead.CO', $bulk );

      echo "successfully made a new comment!";

}


  $m = new MongoDB\Driver\Manager("mongodb://joerockhead:875423@localhost:27017/joerockhead");
  $id = $_GET['id'];
  $query = new MongoDB\Driver\Query(['USUBJID' => intval($id)]);
  $rows  = $m->executeQuery( "joerockhead.CO", $query );

  $drawHeader = False;



  foreach ($rows as $r) {

    if ($drawHeader == False) {
      echo "    <table class='table table-dark'>
                <tbody>
                <tr>
                    <td><b>Study ID</b></td>
                    <td><b>Domain</b></td>
                    <td><b>COSEQ</b></td>
                    <td><b>Comment</b></td>
                    <td><b>Comment Date</b></td>
                </tr>
                ";
      $drawHeader = True;
    }

    echo "<tr>
          <td>$r->STUDYID</td>";
    echo "<td>$r->DOMAIN</td>";
    echo "<td>$r->COSEQ</td>";
    echo "<td>$r->COVAL</td>";
    echo "<td>$r->CODTC</td>";
    echo "</tr>";
  }

  echo "</tbody></table>";

?>
</pre>


<h1>Insert New Comment for this Subject</h1><br>

<form action="" method = "post">
<label>Comment</label><br>
<input type = "text" name ="comment" id="comment" placeholder = "Put comment here....." required/> <br>
<input type="hidden" name="commentID" value="<?php echo $_GET['id']?>">
<input type = "submit" name ="insertComment" value ="Insert New Comment"/><br>
<intp
</form>

</body>
</html>
