<?php
include('db/db.php');
if(isset($_POST['welcome'])){

  $u_name = $_POST['u_name'];
  $u_category = $_POST['u_category'];
  $u_price = $_POST['u_price'];
  $u_brand = $_POST['u_brand'];
  $filename = $_POST($_FILES['uploadfile']['name']);
  $tmpname = $_POST($_FILES['uploadfile']['tmp_name']);
  $u_code= $_POST['u_code'];
  

  $folder = 'product-images/';

  move_uploaded_file($tmpname , $folder.$filename );
    $sql = "INSERT INTO products(name,category,price,brand,image,code) VALUES (' $u_name ','  $u_category','$u_price','u_brand','$filename',')";
    $query = mysqli_query($conn,$sql);




  
}



?>