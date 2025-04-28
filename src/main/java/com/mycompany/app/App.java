package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class App {

    private static final String MESSAGE = "Hello from Spark Web Server! Welcome to the Java world!";

    public App() {}

    public static void main(String[] args) {
        port(8082);  // Ensures the app is listening on port 8082 (or any port you want)

        // Handle GET requests at '/'
        get("/", (req, res) -> MESSAGE);

        // Handle POST requests at '/github-webhook/'
        post("/github-webhook", (req, res) -> {
            String payload = req.body();  // Get the raw body from the POST request
            System.out.println("Received webhook payload: " + payload);  // Log the payload for debugging

            // You can add logic to process the webhook payload here
            // For now, return a response indicating that the webhook was received
            res.status(200);  // Set status code to 200 OK
            return "Webhook received";
        });
    }

    public String getMessage() {
        return MESSAGE;
    }

    // New simple function 2
    public String getMessageUpperCase() {
        return MESSAGE.toUpperCase();
    }
}
