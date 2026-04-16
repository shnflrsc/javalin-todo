package io.shnflrsc;

import io.javalin.Javalin;

public class TodoApplication 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create(config -> {
            config.requestLogger.http((ctx, ms) -> {
                System.out.println("Log: " + ctx.method() + " " + ctx.path());
            });
        }).start(7070);

        app.get("/todos", TodoController::getAll);
        app.post("/todos", TodoController::create);
        app.get("/todos/{id}", TodoController::getOne);
        app.delete("/todos/{id}", TodoController::delete);
        app.put("/todos/{id}", TodoController::update);
    }
}
