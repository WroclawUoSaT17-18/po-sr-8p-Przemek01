<?php

$user_login = $_POST["login"];
$user_haslo = $_POST["haslo"];
$host = "mysql.cba.pl";
$user = "tyhu";
$password = "android";
$db = "androidhosting";

$nazwa_planu =  $_POST["plan_delete"];

$con = mysqli_connect($host,$user,$password,$db);

$sql_query2 = "select nazwa from lista where login like '$user_login' and haslo like '$user_haslo';";
$results = mysqli_query($con,$sql_query2);


$sql_query = "DROP TABLE $nazwa_planu;";


if(mysqli_num_rows($results) > 0)
{
echo "usunieto $nazwa_planu";
mysqli_query($con,$sql_query);
}
else
{
echo "brak dostepu";
}
mysqli_close($con);

?>