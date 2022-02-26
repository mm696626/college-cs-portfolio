<head> <title> Delete Everything </title> </head>
<body> <pre>

<?php

//Code by Matt McCullough

    $m = new MongoDB\Driver\Manager(
			"mongodb://joerockhead:875423@localhost:27017/joerockhead" );

    #delete all from comment collection
    $bulk = new MongoDB\Driver\BulkWrite();
    $_id = $bulk->delete([]);
    $result = $m->executeBulkWrite( 'joerockhead.CO', $bulk );


    #delete all from subject visit collection
    $bulk = new MongoDB\Driver\BulkWrite();
    $_id = $bulk->delete([]);
    $result = $m->executeBulkWrite( 'joerockhead.SV', $bulk );

    #example of inserting a new subject
    $bulk = new MongoDB\Driver\BulkWrite();
    $_id = $bulk->delete([]);
    $result = $m->executeBulkWrite( 'joerockhead.DM', $bulk );

    echo "Successfully Deleted Everything";
    ?>

    </pre> </body>
    </html>
