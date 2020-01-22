const express = require('express');
const router = express.Router();

const mysqlConnection = require('../databse');

router.get('/ci/',(req,res)=>{
    mysqlConnection.query('SELECT * FROM cliente', (err, rows, fields)=>{
        if(!err){
            res.json(rows);
        }else{
            console.log(err); 
        }
    });
});

router.get('/ci/:ci',(req, res)=>{
    const {ci}= req.params;
    console.log(ci);
    mysqlConnection.query('SELECT * FROM cliente where ci = ?',[ci],(err, rows, fields)=>{
        if(!err){
            res.json(rows[0]);
        }else{
            console.log(err);
        }
    });
});

router.delete('/:ci',(req, res)=>{
    const {ci}= req.params;
    mysqlConnection.query('DELETE FROM cliente WHERE ci = ?',[ci],(err,rows,fields)=>{
        if(!err){
            res.json({status: 'Cliente Eliminado'});
        }else{
            console.log(err);
        }
    });
});

module.exports = router;