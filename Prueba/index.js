const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const request = require('request');
const async = require('async');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.get('/student/id', (request, response) =>{
    response.json([{'Number': '18',
                    'student': 'Mateo'},
                    {'Number': '1',
                    'student': 'Daniel'}]);
})

app.listen('8010', ()=>{
    console.log('Listening on port 8010');
})