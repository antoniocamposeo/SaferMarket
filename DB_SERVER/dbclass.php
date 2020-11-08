<?php

class DB_functions{
	
	function __construct(){
	}
	
	public function storeUser($nome, $cognome, $email, $password, $indirizzo, $conn){
		$encrypted_password = sha1($password);
		
		$mysql_qry = "INSERT INTO utenti VALUES('$nome','$cognome','$email','$encrypted_password','$indirizzo')";
		
		$result = mysqli_query($conn, $mysql_qry);
		//result è 1 se la query è andata a buon fine, altrimenti è null
		if($result == 1){
			return $result;
		}
		else{
			return "0";
		}
	}
	
	public function login($email, $password, $conn){
		//$encrypted_password = sha1($password);
		$encrypted_password = $password;
		$mysql_qry = "select * from utenti where email = '$email' and password = '$encrypted_password'";
		$result = mysqli_query($conn, $mysql_qry);
		if(mysqli_num_rows($result) > 0){ 
		return "1";
		}
		else{
			return "0";
		}
	}
	
	public function entra($beacon_code,$conn){
		$mysql_qry = "update supermarket set numpersone = (numpersone + 1) where codBeacon = '$beacon_code'";
		$result = mysqli_query($conn, $mysql_qry);
		return $result;
	}
	
	public function esci($beacon_code,$conn){
		$mysql_qry = "update supermarket set numpersone = (numpersone - 1) where codBeacon = '$beacon_code'";
		$result = mysqli_query($conn, $mysql_qry);
		return $result;
	}
	
	public function getSuperMarket($conn){
		$mysql_qry = "select id, nome, via, civico, cap, numpersone from supermarket order by numpersone asc";
		$result = mysqli_query($conn, $mysql_qry);
		if(mysqli_num_rows($result) > 0){ 
		$string = "";
		for ($x = 0; $x < mysqli_num_rows($result); $x++){
			$resrow = mysqli_fetch_row($result);
			$id = $resrow[0];
			$nome = $resrow[1];
			$via = $resrow[2];
			$civico = $resrow[3];
			$cap = $resrow[4];
			$numpersone = $resrow[5];
			$string = $string.$id."/".$nome."/".$via."/".$civico."/".$cap."/".$numpersone.";";
		}
			return $result;
		}
		else{
			return "Error!";
		}
	}
	
	public function superProdotto($nome, $conn){
		$mysql_qry = "select id, nome, via, civico, cap, numpersone from supermarket where id IN (select idSupermarket from prodotto where nome = 'nome') order by numpersone asc";
		$result = mysqli_query($conn, $mysql_qry);
		if(mysqli_num_rows($result) > 0){ 
		$string = "";
		for ($x = 0; $x < mysqli_num_rows($result); $x++){
			$resrow = mysqli_fetch_row($result);
			$id = $resrow[0];
			$nome = $resrow[1];
			$via = $resrow[2];
			$civico = $resrow[3];
			$cap = $resrow[4];
			$numpersone = $resrow[5];
			$string = $string.$id."/".$nome."/".$via."/".$civico."/".$cap."/".$numpersone.";";
		}
			return $result;
		}
		else{
			return "Error!";
		}
	}
}

?>