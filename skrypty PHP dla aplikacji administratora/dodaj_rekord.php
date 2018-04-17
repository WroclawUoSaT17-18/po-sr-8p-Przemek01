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
$opis =  $_POST["plan_opis"];

$con = mysqli_connect($host,$user,$password,$db);

$sql_query2 = "select nazwa from lista where login like '$user_login' and haslo like '$user_haslo';";
$results = mysqli_query($con,$sql_query2);

$sql_query = "INSERT INTO $nazwa_planu (id,Miesiac,dzien,od,do,opis) VALUES (NULL,'$miesiac','$dzien','$od', '$do','$opis');";


if(mysqli_num_rows($results) > 0)
{
echo "dodano";
mysqli_query($con,$sql_query);
}
else
{
echo "brak dostepu";
}
mysqli_close($con);

?>