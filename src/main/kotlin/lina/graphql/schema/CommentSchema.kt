package lina.graphql.schema

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import lina.clients.jsonplaceholder.*
import lina.model.Comment

fun SchemaBuilder.commentSchema() {
    type<Comment> {
        description = "Comment description"
    }
    query("comments") {
        description = "Returns all comments"
        resolver { -> getAllComments() }
    }
    query("commentsByPostId") {
        description = "Returns comments by post Id"
        resolver { postId: Int -> getCommentsByPostId(postId) }
    }
    query("comment") {
        description = "Returns comment by Id"
        resolver { id: Int -> getCommentById(id) }
    }
}