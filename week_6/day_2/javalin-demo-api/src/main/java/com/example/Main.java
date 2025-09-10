package com.example;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        app.get("/users", UserController.fetchAllUsernames);
        app.get("/users/{id}", UserController.fetchById);
    }
}