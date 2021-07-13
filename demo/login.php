<?php
include('db/db.php');
session_start();
///$conn=mysqli_connect('localhost','root','','grocery');
//Getting Input value

if(isset($_POST['login'])){
  $name=mysqli_real_escape_string($con,$_POST['name']);
  $password=mysqli_real_escape_string($con,$_POST['password']);
  if(empty($name)&&empty($password)){
  $error= 'campo necesario ';
  }else{
 //Checking Login Detail
 $result=mysqli_query($con,"SELECT*FROM users WHERE name='$name' AND password='$password'");
 $row=mysqli_fetch_assoc($result);
 $count=mysqli_num_rows($result);
 if($count==1){
      $_SESSION['user']=array(
   'name'=>$row['name'],
   'password'=>$row['password'],
   'role'=>$row['role']
   );
   $role=$_SESSION['user']['role'];
   //Redirecting User Based on Role
    switch($role){
  case 'user':
  header('location:index.php');
  break;
  ///case 'moderator':
  /////header('location:moderator.php');
  ////break;
  case 'admin':
  header('location:adminPanel.php');
  break;
 }
 }else{
 $error='Your PassWord or UserName is not Found';
 }
}
}
?>
<html>

<head>
    <title>PHP MySQL Role Based Access Control</title>
</head>
<div align="center">
    <h3>PHP MySQL Role Based Access Control</h3>
    <form method="POST" action="">
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>PassWord:</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="login" value="Login" /></td>
            </tr>
        </table>
    </form>
    <?php if(isset($error)){ echo $error; }?>
</div>

</html>