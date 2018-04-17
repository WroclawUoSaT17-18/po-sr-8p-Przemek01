<?php

$user_login = $_POST["login"];
$user_haslo = $_POST["haslo"];
$host = "mysql.cba.pl";
$user = "tyhu";
$password = "android";
$db = "androidhosting";

$nazwa_planu =  $_POST["plan_add"];
$miesiac =  $_POST["plan_miesiac"];
$dzien =  $_POST["plan_dzien"];
$od =  $_POST["plan_od"];
$do =  $_POST["plan_do"];


$con = mysqli_connect($host,$user,$password,$db);


$sql_query2 = "select nazwa from lista where login like '$user_login' and haslo like '$user_haslo';";

$sql_query = "DELETE FROM $nazwa_planu WHERE Miesiac='$miesiac' AND dzien='$dzien' AND od='$od' AND do='$do'";

$results = mysqli_query($con,$sql_query2);

if(mysqli_num_rows($results) > 0)
{
mysqli_query($con,$sql_query);
echo "usunieto";
}
else
{
echo "brak dostepu";
}
mysqli_close($con);

?>