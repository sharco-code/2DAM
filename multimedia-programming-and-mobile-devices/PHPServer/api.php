<?php
require './vendor/autoload.php';
$app = new Slim\App();

function connectDB()
{
    try {
        $usr = "root";
        $pass = "1234";
        $opciones = array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8");
        $conn = new PDO('mysql:host=localhost;dbname=facturacion', $usr, $pass, $opciones);

        
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $conn->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_OBJ);
        return $conn;
    } catch (PDOException $e) {
        echo "ERROR: " . $e->getMessage();
    }
}
$app->get('/facturacion/articulo/todos', function ($request, $response, $args) {
    try {
        $db = connectDB();
        $sql = "select * from articulo";
        $stmt = $db->query($sql);
        
        $data = $stmt->fetchAll(PDO::FETCH_ASSOC);

        return json_encode($data, 200);
    } catch (PDOException $e) {
        return json_encode(["error"=>"error"],400);
    }catch(Exception $e){
        return json_encode(["error"=>$e->getMessage()],400);
    }
});
$app->get('/facturacion/articulo/{id_article}', function ($request, $response, $args) {
    
    $id_article = $request->getAttribute('id_article');
    $sql = "SELECT * FROM articulo WHERE id LIKE ".$id_article;
    
    try{
        $db = connectDB();
        $stmt = $db->query($sql);
        
        
        $data = $stmt->fetchAll(PDO::FETCH_ASSOC);
        

        return json_encode($data, 200);
    }catch(PDOException $e){
        return managerError($e);
    }catch(Exception $e){
        return managerError($e);
    }

    
});

$app->post('/facturacion/articulo/add',function ($request, $response, $args) {
    
    $datos = $request->getParsedBody();
    
    $sql = "INSERT INTO articulo (`descripcion`, `pvp`,`iva`) VALUES ('".$datos['Descripcion']."',".$datos['PVP'].",".$datos['IVA'].")";
    try{
        $db = connectDB();
        $stmt = $db->query($sql);
        
        return json_encode([
            "ID"=>$db->lastInsertId(),
            "Descripcion"=>$datos['Descripcion'],
            "PVP"=>$datos['PVP'],
            "IVA"=>$datos['IVA']],
            200);
        

        
    }catch(PDOException $e){
        return managerError($e);
    }catch(Exception $e){
        return managerError($e);
    }

});

function managerError(Exception $e){
    return json_encode(["Message"=>$e->getMessage(),"Code"=>$e->getCode()],200);

}

$app->delete('/facturacion/articulo/delete/{id_article}', function ($request, $response, $args) {
    
    $id_article = $request->getAttribute('id_article');
    $sql = "DELETE FROM articulo WHERE id LIKE ".$id_article;
    
    try{
        $db = connectDB();
        $stmt = $db->query($sql);
        

        return json_encode(["ID"=>$id_article,
        "Descripcion"=>"",
        "PVP"=>0,
        "IVA"=>0], 200);
    }catch(PDOException $e){
        return managerError($e);
    }catch(Exception $e){
        return managerError($e);
    }

    
});

$app->post('/facturacion/articulo/update',function ($request, $response, $args) {
    
    $datos = $request->getParsedBody();
    
    $sql = "UPDATE articulo SET descripcion = '".$datos['descripcion']."',pvp = ".$datos['PVP'].", iva = ".$datos['IVA']." WHERE id = ".$datos['ID'];
    try{
        $db = connectDB();
        $stmt = $db->query($sql);

        return json_encode([
            "ID"=>$datos['ID'],
            "Descripcion"=>$datos['Descripcion'],
            "PVP"=>$datos['PVP'],
            "IVA"=>$datos['IVA']],
            200);
    }catch(PDOException $e){
        return managerError($e);
    }catch(Exception $e){
        return managerError($e);
    }

});



$app->run();
