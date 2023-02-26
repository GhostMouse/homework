package lina.plugins

import com.apurebase.kgraphql.GraphQL
import io.ktor.server.application.*
import lina.graphql.schema.albumSchema
import lina.graphql.schema.commentSchema
import lina.graphql.schema.userSchema
import lina.graphql.schema.photoSchema
import lina.graphql.schema.postSchema
import lina.graphql.schema.todoSchema

fun Application.configureGraphQL() {
    install(GraphQL) {
        playground = true
        schema {
            albumSchema()
            commentSchema()
            photoSchema()
            postSchema()
            todoSchema()
            userSchema()
        }
    }
}