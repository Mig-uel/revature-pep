package net.miguel.social_media_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dtos.MessageUpdateDto;
import entities.Message;
import entities.User;
import io.javalin.Javalin;

// TODO => add try/catch for json deserialization errors
public class Main {
    public static List<User> users = new ArrayList<User>();
    public static List<Message> messages = new ArrayList<Message>();

    public static void main(String[] args) {
        users.add(new User("jason", "password"));
        messages.add(new Message("Hello, world!", users.get(0).getAccount_id()));

        // Init Javalin app
        Javalin app = Javalin.create().start(3000);

        // Dummy data
        System.out.println(users.get(0).getAccount_id());
        System.out.println(messages.get(0).getMessage_id());

        /* Routes */

        // Register
        app.post("/register", (ctx) -> {
            try {
                User newUser = ctx.bodyAsClass(User.class);

                User existingUser = users.stream()
                        .filter(u -> u.getUsername().equals(newUser.getUsername()))
                        .findFirst()
                        .orElse(null);

                if (existingUser != null)
                    throw new Exception("Username already exists!");

                if (newUser.getPassword().length() < 4)
                    throw new Exception("Password must be at least 4 characters long!");

                // TODO => Add user to database
                // Locally saving user for now
                users.add(newUser);

                ctx.status(200).json(newUser);
            } catch (Exception e) {
                ctx.status(400).json("{\"message\": \"" + e.getLocalizedMessage() + "\" }");
            }
        });

        // Login
        app.post("/login", (ctx) -> {
            try {
                User user = ctx.bodyAsClass(User.class);

                User matches = users.stream()
                        .filter(u -> {
                            // Can simplify this without if/else
                            if (u.getUsername().equals(user.getUsername())
                                    && u.getPassword().equals(user.getPassword()))
                                return true;
                            return false;
                        })
                        .findFirst()
                        .orElse(null);

                if (matches == null)
                    throw new Exception("Invalid username/password!");

                ctx.status(200).json(user);
            } catch (Exception e) {
                ctx.status(401).json("{\"message\": \"" + e.getLocalizedMessage() + "\" }");
            }
        });

        // Create new message
        app.post("/messages", (ctx) -> {
            Message newMessage = ctx.bodyAsClass(Message.class);

            String userRef = newMessage.getPosted_by();

            User existingUser = users.stream()
                    .filter(u -> u.getAccount_id().equals(userRef))
                    .findFirst()
                    .orElse(null);

            if (existingUser == null) {
                ctx.status(400).json(Map.of("message", "User not found!"));
                return;
            }

            if (newMessage.getMessage_text().length() == 0 || newMessage.getMessage_text().length() > 255) {
                ctx.status(400).json(Map.of("message", "Invalid message!"));
                return;
            }

            messages.add(newMessage);
            ctx.status(200).json(newMessage);
        });

        // Get all messages
        app.get("/messages", (ctx) -> {
            ctx.status(200).json(messages);
        });

        // Get message by ID
        app.get("/messages/{message_id}", (ctx) -> {
            String messageId = ctx.pathParam("message_id");

            Message existingMessage = messages.stream()
                    .filter(m -> m.getMessage_id().equals(messageId))
                    .findFirst()
                    .orElse(null);

            if (existingMessage == null)
                ctx.status(200).result();
            else
                ctx.status(200).json(existingMessage);

        });

        // Delete a message by ID
        app.delete("/messages/{message_id}", (ctx) -> {
            String messageId = ctx.pathParam("message_id");

            Message existingMessage = messages.stream()
                    .filter(m -> m.getMessage_id().equals(messageId))
                    .findFirst()
                    .orElse(null);

            if (existingMessage == null) {
                ctx.status(200).result();
                return;
            } else {
                messages = messages.stream()
                        .filter(m -> !m.getMessage_id().equals(existingMessage.getMessage_id()))
                        .toList();

                ctx.status(200).json(existingMessage);
            }
        });

        // Update message by ID
        app.patch("/messages/{message_id}", (ctx) -> {
            String messageId = ctx.pathParam("message_id");
            MessageUpdateDto messageText = ctx.bodyAsClass(MessageUpdateDto.class);

            if (messageText.getMessage_text().length() == 0 || messageText.getMessage_text().length() > 255) {
                ctx.status(400).result();
                return;
            }

            Message messageToUpdate = messages.stream()
                    .filter(m -> m.getMessage_id().equals(messageId))
                    .findFirst()
                    .orElse(null);

            if (messageToUpdate == null) {
                ctx.status(400).result();
                return;
            } else {
                messageToUpdate.setMessage_text(messageText.getMessage_text());
                ctx.status(200).json(messageToUpdate);
            }
        });

        // Get all user messages by ID
        app.get("/accounts/{account_id}/messages", (ctx) -> {
            try {
                String accountId = ctx.pathParam("account_id");

                List<Message> userMessages = messages.stream()
                        .filter(m -> m.getPosted_by().equals(accountId))
                        .toList();

                ctx.status(200).json(userMessages);
            } catch (Exception e) {
                // Catch deserialization or unexpected runtime errors
                ctx.status(400).json(Map.of("message", "Invalid request body"));
            }

        });
    }
}