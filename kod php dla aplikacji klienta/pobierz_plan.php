<?php
$host = "mysql.cba.pl";
$user = "tyhu";
$password = "android";
$db = "androidhosting";


$tabela = $_POST["nazwa"];

$con = mysqli_connect($host,$user,$password,$db);
$response = array();


$sql = "select * from $tabela;";

$results = mysqli_query($con,$sql);

if(mysqli_num_rows($results) > 0)
{
while($row = mysqli_fetch_array($results))
{
array_push($response,array("miesiac"=>$row[1],"dzien"=>$row[2],"od"=>$row[3],"do"=>$row[4],"opis"=>$row[5]));
}
echo json_encode(array("server_response"=>$response));
}
else
{
echo "pusty plan";
}
mysqli_close($con);

?>