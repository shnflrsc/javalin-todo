# Todo API (Javalin)

## Fundamental Concepts I Learned

### Java Core Fundamentals
- I learned how to model data using a Java `record` (`Todo`) for a clean and simple data structure.
- I learned the idea of immutability by creating updated objects instead of changing existing ones directly.
- I practiced using `List` and `ArrayList` to store and manage in-memory collections.
- I used lambda expressions and method references to write cleaner, more readable Java code.
- I applied Java Streams (`filter`, `map`, `findFirst`) to search and transform data.

### API and CRUD Fundamentals
- I learned how CRUD maps to HTTP methods: `POST` (Create), `GET` (Read), `PUT` (Update), and `DELETE` (Delete).
- I learned how to define REST routes in Javalin, including resource routes like `/todos` and `/todos/{id}`.
- I practiced reading path parameters (like `id`) from the URL and converting them to Java types.
- I learned how to parse JSON request bodies into Java objects and return Java objects as JSON responses.
- I used meaningful HTTP status codes such as `200`, `201`, and `204` for correct API behavior.

### Project and Tooling Fundamentals
- I learned how Maven manages dependencies and keeps project configuration organized in `pom.xml`.
- I learned the basic Maven workflow: build, test, and package a Java application.
- I was introduced to unit testing structure with JUnit in the project test folder.

### Next Fundamentals I Plan to Learn
- Persisting data with a real database instead of in-memory lists.
- Input validation and better error handling for invalid requests.
- Writing endpoint-level tests for CRUD routes.
- Improving API quality with logging and documentation.
