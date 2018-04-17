<?php

$user_login = $_POST["login"];
$user_haslo = $_POST["haslo"];
$host = "mysql.cba.pl";
$user = "tyhu";
$password = "android";
$db = "androidhosting";

$nazwa_planu =  $_POST["plan_add"];

$con = mysqli_connect($host,$user,$password,$db);

$sql_query2 = "select nazwa from lista where login like '$user_login' and haslo like '$user_haslo';";
$results = mysqli_query($con,$sql_query2);


$sql_query = " CREATE TABLE $nazwa_planu (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 Miesiac TEXT,
 dzien TEXT,
 od TEXT,
 do TEXT,
opis TEXT);";



if(mysqli_num_rows($results) > 0)
{
echo "dodano $nazwa_planu";
mysqli_query($con,$sql_query);
}
else
{
echo "brak dostepu";
}
mysqli_close($con);

?>