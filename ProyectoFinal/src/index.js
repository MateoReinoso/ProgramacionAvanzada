const express = require('express');
const app = express();
const bodyParser = require('body-parser');

//Settings

app.set('port', process.env.PORT || 3001);

//middlewares 
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended:false
}));

//routes
app.use(require('./routes/apirest'));



//Start the server
app.listen(app.get('port'), () =>{
    console.log('Server on port ',app.get('port'));
});
