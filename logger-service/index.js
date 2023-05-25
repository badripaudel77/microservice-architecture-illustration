// get express
const express = require('express');
const PORT = 3000;

const expressApp = express();
expressApp.use(express.json());

// get the route
const loggerRoutes = require('./routes/LoggerRoutes');

// url for route
// eg : http://localhost:3000/api/v1/logger/log/23
expressApp.use('/api/v1/logger/', loggerRoutes);

expressApp.listen(PORT, (error) => {
    if(error) {
        console.log("OOPS!, error occurred while starting up the application.");
    }
    else {
        console.log(`WOW!, app is up & running at PORT : ${PORT}`);
    }
});



