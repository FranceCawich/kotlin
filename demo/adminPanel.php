<?php
require_once 'db/db.php';
require_once './fetch-data.php';

$all_prodcuts = array_reverse(fetchproduct($con));

if (isset($_POST['u_name']) && isset($_POST['u_email'])) {
    $insert_data = insertData($conn, $_POST['u_name'], $_POST['u_email']);
    if ($insert_data === true) {
        header('Location: adminPanel.php');
        exit;
    }
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>admin panel</title>
    <link rel='stylesheet' href='css/style.css' type='text/css' media='all' />
    <link rel="stylesheet" href="css/crud.css">
</head>

<body>

    <div class="topnav">

        <a href="#contact">Contact</a>
        <a href="#about">About</a>
        <a href="logout.php">logout</a>
    </div>


    <div class="container">
        <header class="header">
            <h1 class="title">WELCOME ADMINISTRATO</h1>
            <p>By <a href="">nuestro grupo</a></p>
        </header>
        #

    </div>



    <div class="user-list">
        <?php if (count($all_prodcuts) > 0) : ?>
        <table>
            <tbody>
                <tr>
                    <th>Name</th>
                    <th>code </th>
                    <th>category</th>

                    <th>price</th>
                    <th>brand</th>
                    <th>image</th>

                    <?php foreach ($all_prodcuts as $user) :
                                $id = $user['id'];
                                $name = $user['name'];
                                $code = $user['code'];
                                $category = $user['category'];
                                $price = $user['price'];
                                $brand = $user['brand'];
                              
                               
                               $image = $user['image'];
                            ?>
                <tr>
                    <td><?php echo $name; ?></td>
                    <td><?php echo $code; ?></td>
                    <td><?php echo $category; ?></td>
                    <td><?php echo $price; ?></td>
                    <td><?php echo $brand; ?></td>

                    <td><img src='<?php echo $image; ?>' width="70" height="60" /></td>
                    <td>
                        <a href="edit.php?id=<?php echo $id; ?>" class="edit">Edit</a>&nbsp;|
                        <a href="delete.php?id=<?php echo $id; ?>" class="delete delete-action">Delete</a>
                    </td>
                </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
        <?php else : ?>
        <h2>No records found. Please insert some records.</h2>
        <?php endif; ?>
    </div>
    </div>
    </div>

    <script>
    var delteAction = document.querySelectorAll('.delete-action');
    delteAction.forEach((el) => {
        el.onclick = function(e) {
            e.preventDefault();
            if (confirm('estas seguro?')) {
                window.location.href = e.target.href;
            }
        }
    });
    </script>
    <a class="button" href="insert_data.php">insertar</a>

</body>

</html>