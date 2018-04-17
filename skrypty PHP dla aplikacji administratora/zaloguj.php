<?php

$user_login = $_POST["login"];
$user_haslo = $_POST["haslo"];
$host = "mysql.cba.pl";
$user = "tyhu";
$password = "android";
$db = "androidhosting";


$con = mysqli_connect($host,$user,$password,$db);

$sql_query = "select nazwa from lista where login like '$user_login' and haslo like '$user_haslo';";
$results = mysqli_query($con,$sql_query);

if(mysqli_num_rows($results) > 0)
{
echo "zalogowano";
}
else
{
echo "niepoprawne haslo lub login";
}
mysqli_close($con);

?>