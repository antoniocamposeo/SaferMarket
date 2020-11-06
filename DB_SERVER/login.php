<?php
require "conn.php";
//$user_email = $_POST["user_name"];
//$user_pass = $_POST["password"];
$user_email = "antus.longo@gmail.com";
$user_pass = "anto";
$mysql_qry = "select * from utenti where email = '$user_email' and password = '$user_pass'";

$result = mysqli_query($conn, $mysql_qry);

if(mysqli_num_rows($result) > 0){
    echo "Login success!";
}
else{
    echo "Login not success!";
}
?>