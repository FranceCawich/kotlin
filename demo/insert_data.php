<?php

if(isset($_POST['welcome'])){
  $conn = mysqli_connect("localhost","root","","grocery");
  $u_name = $_POST['u_name'];
  $u_category = $_POST['u_category'];
  $u_price = $_POST['u_price'];
  $u_brand = $_POST['u_brand'];
  $filename = $_FILES['uploadfile']['name'];
  $tmpname = $_FILES['uploadfile']['tmp_name'];
  $u_code= $_POST['u_code'];
  

  $folder = 'product-images/';

  move_uploaded_file($tmpname , $folder.$filename );
    $sql = "INSERT INTO products(name,category,price,brand,image,code) VALUES (' $u_name ','  $u_category','$u_price','u_brand','$filename','u_code')";
    if (mysqli_query($conn, $sql)) {
      echo "New record created successfully !";
     } else {
      echo "Error: " . $sql . "
  " . mysqli_error($conn);
     }
     mysqli_close($conn);
  }




  




?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
</head>

<body>
    <form method="POST" action="" enctype="multipart/form-data">
        <label for=" userName"> Name</label>
        <input type="text" name="u_name" id="userName" placeholder="" autocomplete="off" required />
        <label for="userName"> category</label>
        <input type="text" name="u_category" id="category" placeholder="" autocomplete="off" required />
        <label for="userName"> price</label>
        <input type="text" name="u_price" id="price" placeholder="" autocomplete="off" required />
        <label for="userName"> brand</label>
        <input type="text" name="u_brand" id="brand" placeholder="" autocomplete="off" required />

        <label for="userName"> image</label>
        <input type="file" name="uploadfile" />

        <label for="userName"> code</label>
        <input type="text" name="u_code" id="userName" placeholder="" autocomplete="off" required />

        <input type="submit" value="upload" name=" welcome" />
    </form>


    <a class="button" href="adminPanel.php">regresar</a>

</body>

</html>