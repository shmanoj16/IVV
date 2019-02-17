<?php

const DB_MYSQL = 0;
const DB_POSTGRESQL = 1;
const DB_SQLITE3 = 2;

// ======== Start of user-configurable variables =======================
// --- set this to use YOUR database type: ------
$dbType = DB_MYSQL;

// if your database is DB_SQLITE3, you need to set the path to your database file:
$pathToSQLite = 'sqlite\gpstracker.sqlite';

// ======== End of user-configurable variables =======================

$dbuser = 'u173800516_mouni';
$dbpass = 'ivv123';

$params = array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION, 
                PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC);

switch ($dbType) {
    case DB_MYSQL:
        $pdo = new PDO('mysql:host=mysql.hostinger.in;dbname=u173800516_ivv;charset=utf8', $dbuser, $dbpass, $params);
        $sqlFunctionCallMethod = 'CALL ';
        break;
    case DB_POSTGRESQL:
        $pdo = new PDO('pgsql:host=localhost;dbname=gpstracker', $dbuser, $dbpass, $params);
        $sqlFunctionCallMethod = 'select ';
        break;
    case DB_SQLITE3:
        $pdo = new PDO('sqlite:'.$pathToSQLite, $dbuser, $dbpass, $params);
        $sqlFunctionCallMethod = 'select ';
        break;
}
?>