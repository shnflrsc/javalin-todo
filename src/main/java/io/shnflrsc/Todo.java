package io.shnflrsc;

public record Todo(int id, String task, boolean completed) {
    public Todo withTodo(String newTask, boolean newCompleted) {
        return new Todo(this.id, newTask, newCompleted);
    }
}
