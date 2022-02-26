<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Study Page</title>
</head>
<body>
<pre>

<?php

//Code by Matt McCullough
//connect to DB and grab all subjects
$m = new MongoDB\Driver\Manager("mongodb://joerockhead:875423@localhost:27017/joerockhead");

$query = new MongoDB\Driver\Query([]);
$rows  = $m->executeQuery( "joerockhead.DM", $query );

foreach ($rows as $r) {
    echo "<a href = '" . "subject852814.php?id=" . $r->_id . "'" . ">" . "Subject ID " . $r->USUBJID . "</a><br>";
}

?>
</pre>

<a href="add394255.php">Add New Subject</a>
<br>
<a href="study261866.php">Reload Subjects</a>

</body>
</html>
