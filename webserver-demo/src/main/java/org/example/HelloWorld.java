package org.example;
import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        port(8080); // Set the port to 8080
        get("/", (req, res) -> "<html><head><title>Hello World</title></head><body><h1>Hello World!</h1></body></html>");
    }
}



