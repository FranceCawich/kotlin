<?php
// FETCH ALL USERS
function fetchProduct($conn){
    $query = mysqli_query($conn,"SELECT * FROM `products`");
    return mysqli_fetch_all($query,MYSQLI_ASSOC);
};

// FETCH SINGLE USER BY ID
function fetchProducts($conn, $id){
    $id = mysqli_real_escape_string($conn,$id);
    $query = mysqli_query($conn,"SELECT * FROM `products` WHERE `id`='$id'");
    $data = mysqli_fetch_assoc($query);
    if(!count($data)){
        header('Location: index.php');
        exit;
    }
    return $data;
}