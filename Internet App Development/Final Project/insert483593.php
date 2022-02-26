<head> <title> Insert Data </title> </head>
<body> <pre>

<?php

//Code by Matt McCullough

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


    $m = new MongoDB\Driver\Manager(
			"mongodb://joerockhead:875423@localhost:27017/joerockhead" );

    $sexArray = array("M", "F");
    $raceArray = array("caucasian", "asian", "african", "hispanic");
    $countryArray = array("USA", "JPN", "DOM", "ESP", "FRA", "IND", "PRI", "EGY");


    //insert subjects
    for ($i = 0; $i < 12; $i++) {


      #example of inserting a new subject
      $bulk = new MongoDB\Driver\BulkWrite();
      $usubjid = getDM( $m );
      $now = new DateTime( date("Y-m-d H:i:s") );
      $_id = $bulk->insert([
                      'STUDYID'   => rand(10000, 99999),
                      'DOMAIN'   => 'DM',
                      'USUBJID'    => $usubjid,
                      'BRTHDTC'  => $now->format( DateTime::ATOM ),  # ISO8601
                      'SEX'            => $sexArray[rand(0,count($sexArray)-1)],
                      'RACE'         => $raceArray[rand(0,count($raceArray)-1)],
                      'COUNTRY' => $countryArray[rand(0,count($countryArray)-1)] ]);

      $result = $m->executeBulkWrite( 'joerockhead.DM', $bulk );
    }


    $commentArray = array("Good Job!", "See me in a week to follow up", "Exercise more", "Eat healthy", "Hope you feel better soon!");

    //insert comments
    for ($i = 0; $i < 18; $i++) {
          $usubjid = rand(1,12); //subject ids 1 to 12
          $bulk = new MongoDB\Driver\BulkWrite();
          $coseq = getCO( $m, $usubjid );
          $now = new DateTime( date("Y-m-d H:i:s") );
          $_id = $bulk->insert([
                          'STUDYID'  => rand(10000, 99999),
                          'DOMAIN'  => 'CO',
                          'USUBJID'   => $usubjid,
                          'COSEQ'     => $coseq,
                          'COVAL'     => $commentArray[rand(0,count($commentArray)-1)],
                          'CODTC'     => $now->format( DateTime::ATOM ) ]);

          $result = $m->executeBulkWrite( 'joerockhead.CO', $bulk );
    }

    $visitArray = array("Visit for MRI", "Visit for CAT scan", "Visit for checkup", "Visit for cold", "Visit for migraine");

    //insert visits
    for ($i = 0; $i < 20; $i++) {
      $usubjid = rand(1,12); //subject ids 1 to 12
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
                      'VISIT'          => $visitArray[rand(0,count($visitArray)-1)],
                      'SVSTDTC'   => $now->format( DateTime::ATOM ),
                      'SVENDTC'  => $svendtc->format( DateTime::ATOM ) ]);

      $result = $m->executeBulkWrite( 'joerockhead.SV', $bulk );

    }

        echo "Done Inserting Data";
    ?>

    </pre> </body>
    </html>
