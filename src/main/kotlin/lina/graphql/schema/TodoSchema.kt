package lina.graphql.schema

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import lina.clients.jsonplaceholder.getAllTodos
import lina.clients.jsonplaceholder.getTodoById
import lina.clients.jsonplaceholder.getTodosByUserId
import lina.model.Todo

fun SchemaBuilder.todoSchema() {
    type<Todo> {
        description = "Todo description"
    }
    query("todos") {
        description = "Returns all todos"
        resolver { -> getAllTodos() }
    }
    query("todosByUserId") {
        description = "Returns todos by user Id"
        resolver { userId: Int -> getTodosByUserId(userId) }
    }
    query("todo") {
        description = "Returns todo by Id"
        resolver { id: Int -> getTodoById(id) }
    }
}