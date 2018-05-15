<?php

$user_login = $_POST["login"];
$user_haslo = $_POST["haslo"];
$host = "mysql.cba.pl";
$user = "tyhu";
$password = "android";
$db = "androidhosting";
$response = array();



$con = mysqli_connect($host,$user,$password,$db);



$sql_query = "SHOW TABLES WHERE NOT Tables_in_androidhosting = 'lista' AND NOT Tables_in_androidhosting = 'Biblioteka_SQL';";
$results = mysqli_query($con,$sql_query);

if(mysqli_num_rows($results) > 0)
{
while($row = mysqli_fetch_array($results))
{
array_push($response,array("plan"=>$row[0]));
}
echo json_encode(array("server_response"=>$response));
}
else
{
echo "brak planow do pobrania";
}
mysqli_close($con);

?>