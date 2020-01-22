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
router.get('/zona/',(req,res)=>{
    mysqlConnection.query('SELECT * FROM zona', (err, rows, fields)=>{
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

router.post('/codigozona/',(req, res)=>{
    const{codigozona, nombrezona} = req.body;
    mysqlConnection.query(`INSERT INTO zona VALUES ('${codigozona}','${nombrezona}')`,(err, rows)=>{
        if(!err){
            res.status(200).json('ok');
        }else{
            console.log(err);
        }
    });
});




router.delete('/cliente/:ci',(req, res)=>{
    const {ci}= req.params;
    mysqlConnection.query('DELETE FROM cliente WHERE ci = ?',[ci],(err,rows,fields)=>{
        if(!err){
            res.json({status: 'Cliente Eliminado'});
        }else{
            console.log(err);
        }
    });
});

router.delete('/zona/:nombrezona',(req, res)=>{
    const {nombrezona}= req.params;
    mysqlConnection.query('DELETE FROM zona WHERE nombrezona = ?',[nombrezona],(err,rows,fields)=>{
        if(!err){
            res.json({status: 'Eliminado'});
        }else{
            console.log(err);
        }
    });
});


router.delete('/zona/:codigozona',(req, res)=>{
    const {codigozona}= req.params;
    mysqlConnection.query('DELETE FROM zona WHERE codigozona = ?',[codigozona],(err,rows,fields)=>{
        if(!err){
            res.json({status: 'Eliminado'});
        }else{
            console.log(err);
        }
    });
});


module.exports = router;