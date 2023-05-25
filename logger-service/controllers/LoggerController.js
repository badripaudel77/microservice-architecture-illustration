// Logs the simple message and returns the message , throws error if no id is passed.
const logTheMessage = async (request, response, next) => {
    const eventId = request.params?.eventId;
    if(!eventId) {
        throw new Error("Requesting without valid event ID");
    }
    const message = `Someone is trying to fetch the details and is passing the event ID : ${eventId}`;
    console.log(message)
    return response.status(201).json({ message : `Returned from the logger service : ${message}`});
}

// export the module
module.exports = {
    logTheMessage,
}