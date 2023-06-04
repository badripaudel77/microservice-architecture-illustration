const Eureka = require('eureka-js-client').Eureka;

const { PORT } = require('./constants');

const client = new Eureka({
// application instance information
    instance: {
        app: 'LOGGER-SERVICE',
        instanceId: 'LOGGER-SERVICE',
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        port: {
            '$': PORT,
            '@enabled': 'true',
        },
        vipAddress: 'LOGGER-SERVICE',
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn',
        },
        registerWithEureka: true,
        fetchRegistry: true
    },
    //: The configuration properties for the Eureka server
    eureka: {
        // eureka server host / port
        host: 'localhost',
        port: 8761,
        servicePath: '/eureka/apps', //http://localhost:8761/eureka/apps
    },
});

// client.logger.level('debug');
// Register with Eureka server
const registerWithEureka = () => {
    client.start((error) => {
        if (error) {
            console.log('Error registering with Eureka server:', error);
        } else {
            console.log('Registered with Eureka server');
        }
    });
};

module.exports = registerWithEureka;
