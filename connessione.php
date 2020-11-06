<!DOCTYPE html>
<html>
<head> <title>Tabella contatti in DB agenda</title> </head>
<body>
Verifica connessione e selezione del database <br>
<?php
$host = 'localhost';
$user = 'root';
$password = '';
$nome_database = 'safermarketdb'; 
$myconn = mysql_connect($host, $user, $password) or die('Impossibile connettersi al DB');
mysql_connect($myconn);

print 'Connessione eseguita <br>';

mysql_select_db($nome_database, $myconn) or die ('Impossibile selezionare il db');
$query = 'select * from utenti';

$dati = mysql_query($query) or die ('Impossibile eseguire query');

$numrows = mysql_num_rows($dati);

if($numrows == 0) {
	echo "Database vuoto!";
}
else{
	while ($res = mysql_fetch_array($dati)){
    	print "$res[nome] <br>";
        print "$res[cognome] <br>";
        print "<br>";
    }
}

mysql_free_result($dati);

mysql_close($myconn);

?>
</body>
</html>