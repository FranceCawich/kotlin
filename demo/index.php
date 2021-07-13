<?php

session_start();
include('db/db.php');






$status="";
if (isset($_POST['code']) && $_POST['code']!=""){
$code = $_POST['code'];
$result = mysqli_query($con,"SELECT * FROM `products` WHERE `code`='$code'");
$row = mysqli_fetch_assoc($result);
$name = $row['name'];
$code = $row['code'];
$price = $row['price'];
$image = $row['image'];

$cartArray = array(
	$code=>array(
	'name'=>$name,
	'code'=>$code,
	'price'=>$price,
	'quantity'= 1>,
	'image'=>$image)
);

if(empty($_SESSION["shopping_cart"])) {
	$_SESSION["shopping_cart"] = $cartArray;
	$status = "<div class='box'>Product is added to your cart!</div>";
}else{
	$array_keys = array_keys($_SESSION["shopping_cart"]);
	if(in_array($code,$array_keys)) {
		$status = "<div class='box' style='color:red;'>
		Product is already added to your cart!</div>";	
	} else {
	$_SESSION["shopping_cart"] = array_merge($_SESSION["shopping_cart"],$cartArray);
	$status = "<div class='box'>Product is added to your cart!</div>";
	}

	}
}
?>
<html>

<head>
    <title>MI TIENDA DE FRUTAS</title>
    <link rel='stylesheet' href='css/style.css' type='text/css' media='all' />
</head>

<body>

    <div class="topnav">
        <a class="active" href="cart.php">carrito</a>
        <a href="#news">News</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
        <a href="login.php">Login</a>
    </div>




    <div style="width:700px; margin:50 auto;">

        <h2>BIENVENDIO A MI TIENDA DE FRUTS Y VERDUAS</h2>

        <?php
if(!empty($_SESSION["shopping_cart"])) {
$cart_count = count(array_keys($_SESSION["shopping_cart"]));
?>
        <div class="cart_div">
            <a href="cart.php"><img src="cart-icon.png" /> Cart<span><?php echo $cart_count; ?></span></a>
        </div>
        <?php
}

$result = mysqli_query($con,"SELECT * FROM `products`");
while($row = mysqli_fetch_assoc($result)){
		echo "<div class='product_wrapper'>
			  <form method='post' action=''>
			  <input type='hidden' name='code' value=".$row['code']." />
			  <div class='image'><img src='".$row['image']."' /></div>
			  <div class='name'>".$row['name']."</div>
		   	  <div class='price'>$".$row['price']."</div>
			  <button type='submit' class='buy'>Buy Now</button>
			  </form>
		   	  </div>";
        }
mysqli_close($con);
?>

        <div style="clear:both;"></div>

        <div class="message_box" style="margin:10px 0px;">
            <?php echo $status; ?>
        </div>

        <br /><br />

    </div>
</body>

</html>