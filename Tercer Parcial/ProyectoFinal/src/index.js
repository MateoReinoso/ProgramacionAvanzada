const express = require('express');
const app = express();

//Settings

app.set('port', process.env.PORT || 3001);

//middlewares 
app.use(express.json());


//routes
app.use(require('./routes/apirest'));



//Start the server
app.listen(app.get('port'), () =>{
    console.log('Server on port ',app.get('port'));
});
