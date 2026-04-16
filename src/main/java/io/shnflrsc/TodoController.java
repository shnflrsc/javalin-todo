package io.shnflrsc;

import java.util.List;
import java.util.stream.IntStream;
import java.util.ArrayList;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class TodoController {
    private static List<Todo> todos = new ArrayList<>();

    public static void getAll(Context ctx) {
        ctx.json(todos);
    }

    public static void create(Context ctx) {
        Todo input = ctx.bodyAsClass(Todo.class);

        int newId = todos.size();
        Todo finalTodo = new Todo(newId, input.task(), input.completed());

        todos.add(finalTodo);
        ctx.status(201).json(finalTodo);
    }

    public static void getOne(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Todo todo = todos.stream()
            .filter(t -> t.id() == id)
            .findFirst()
            .orElseThrow(() -> new NotFoundResponse("Todo not found"));
        ctx.json(todo);
    }

    public static void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        if (id <= todos.size()) {
            todos.remove(id);
            ctx.status(204);
        } else {
            throw new NotFoundResponse("Todo not found");
        }
    }

    public static void update(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Todo input = ctx.bodyAsClass(Todo.class);
        
        Todo newTodo = IntStream.range(0, todos.size())
            .filter(i -> todos.get(i).id() == id)
            .boxed()
            .findFirst()
            .map(i -> {
                Todo updated = todos.get(i).withTodo(input.task(), input.completed());
                todos.set(i, updated);
                return updated;
            })
            .orElseThrow(() -> new NotFoundResponse("Todo not found"));
        
        ctx.status(200).json(newTodo);
    }
}
