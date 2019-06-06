<?php
session_start();
$_SESSION['next']=false;
if(isset($_POST['submit'])){
    $_SESSION['next']=true;
    $num=$_POST['num'];
    $_SESSION['default'] = $_POST['default']; 
    $_SESSION['num'] = $num;    ?>   <form action="" method="POST">   <?php
    for($index=1; $index<=$num; $index++){  ?>
        <label>x</label><?php echo $index-1; ?>:&nbsp;&nbsp;&nbsp;&nbsp;<input name="x<?php echo $index-1; ?>" style="width:10%;" type="number">            <?php
    } echo "<br>";
    for($index=1; $index<=$num; $index++){  ?>
        <label>f(x<?php echo $index-1; ?>):</label><input name="f_x<?php echo $index-1; ?>" style="width:10%;" type="number">            <?php
    }
   ?> <br><input type="submit" name="solve" value="SOLVE"> </form> <?php
}
if($_SESSION['next']==false){
?>
<form action="" method="POST">
    <label for="num">ENTER The Number of Interpolations:</label><br>
    <input type="number" name='num'><br>
    <label for="default">ENTER Default Interpolation Value:</label><br>
    <input type="number" name='default'>
    <br><input type="submit" name="submit" value="NEXT">
</form>
<?php
}
echo "<br>";
if(isset($_POST['solve'])){
    $num = $_SESSION['num'];
    for($a=0; $a<$num; $a++){
        $x[$a] = $_POST["x$a"];
        $f_x[$a] = $_POST["f_x$a"];
    }
    
    $default=$_SESSION['default'];
    $count=0;
    $pn_x =0;
    while($count < count($x)){
        $inner_count1 = 0;
        $l=1;
        $value=1;
        while($inner_count1<count($x)){
            if($count==$inner_count1){
                $inner_count1 +=1;
                if($inner_count1!=count($x)){
                    $l*=($default-$x[$inner_count1])/($x[$count]-$x[$inner_count1]);
                }
            }else{
                $l*=($default-$x[$inner_count1])/($x[$count]-$x[$inner_count1]);
            }
        $inner_count1++;
        }
        $value *= $l*$f_x[$count];
        echo "L$count(x)f(x$count) = ".$value."<br>";
        $pn_x += $value;
        $count++;
    }
echo "Our Pn($default) = ".$pn_x;
}
?>