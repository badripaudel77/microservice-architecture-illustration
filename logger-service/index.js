// get express
const express = require('express');
const { PORT } = require('./constants');

const expressApp = express();
expressApp.use(express.json());

// get the route
const loggerRoutes = require('./routes/LoggerRoutes');

const  registerWithEureka  = require('./client');

// url for route
// eg : http://localhost:3000/api/v1/logger/log/23
// via microservice load balancing : http://LOGGER-SERVICE/api/v1/events/{EVENT-ID}
expressApp.use('/api/v1/logger/', loggerRoutes);

expressApp.listen(PORT, (error) => {
    if(error) {
        console.log("OOPS!, error occurred while starting up the application.");
    }
    else {
        console.log(`WOW!, app is up & running at PORT : ${PORT}`);
    }
});

// register with eureka
registerWithEureka();



