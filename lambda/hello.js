var AWS = require("aws-sdk");

exports.handler = async function(event) {
  console.log("request:", JSON.stringify(event, undefined, 2));
  
  return {
    statusCode: 200,
    headers: { "Content-Type": "text/plain" },
    body: `Hello, it's me CloudController!`
  };
};
