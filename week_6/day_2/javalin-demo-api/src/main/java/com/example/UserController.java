package com.example;
import java.util.Objects;
import java.util.Optional;

import io.javalin.http.Handler;

public class UserController {
    public static Handler fetchAllUsernames = ctx -> {
        UserDao dao = UserDao.instance();
        Iterable<String> users = dao.getAllUsernames();
        ctx.json(users);
    };

    public static Handler fetchById = ctx -> {
        int id = Integer.parseInt(Objects.requireNonNull(ctx.pathParam("id")));
        UserDao dao = UserDao.instance();
        Optional<User> user = dao.getUserById(id);

        if (user.isPresent()) ctx.json(user.get());
        else ctx.html("Not Found");
    };
}
