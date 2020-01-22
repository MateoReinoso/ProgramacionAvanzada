const mysql = require('mysql');
 const mysqlConnection = mysql.createConnection({
     host:'b95t48xjthykn7rt4lva-mysql.services.clever-cloud.com',
     user: 'uwdteqq1rfpbz8nj',
     password: 'Q4JhrZboTtwG1m0ADo7e',
     database: 'b95t48xjthykn7rt4lva',

 });

 mysqlConnection.connect(function(err){
     if(err){
         console.log(err);
         return;
     }else{
         console.log('DB is connected');
     }
 });

 module.exports = mysqlConnection;