package lina.graphql.schema

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import lina.clients.jsonplaceholder.getAllUsers
import lina.clients.jsonplaceholder.getUserById
import lina.model.User

fun SchemaBuilder.userSchema() {
    type<User> {
        description = "User description"
    }
    query("users") {
        description = "Returns all users"
        resolver { -> getAllUsers() }
    }
    query("user") {
        description = "Returns user by Id"
        resolver { id: Int -> getUserById(id) }
    }
}