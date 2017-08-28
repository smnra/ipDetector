<?php 
date_default_timezone_set('PRC');
$str_date = date('Y-m-d H:i:s',time()); 
$ip = $_SERVER['REMOTE_ADDR'];
$all=$ip."\r\n";
$add = "./data_txt/";
if (!is_dir($add)) 
	{
		mkdir($add  , 0777);
	}
$fp = fopen($add."A.txt", "a"); 
if($fp)
	{
		fwrite($fp,$all);
	}
fclose($fp);   
header("Location: http://xxxxxxxxx/index2.jpg?22");
?>