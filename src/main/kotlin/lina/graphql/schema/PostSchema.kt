package lina.graphql.schema

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import lina.clients.jsonplaceholder.getAllPosts
import lina.clients.jsonplaceholder.getPostById
import lina.clients.jsonplaceholder.getPostsByUserId
import lina.model.Post

fun SchemaBuilder.postSchema() {
    type<Post> {
        description = "Post description"
    }
    query("posts") {
        description = "Returns all posts"
        resolver { -> getAllPosts() }
    }
    query("postsByUserId") {
        description = "Returns posts by user Id"
        resolver { userId: Int -> getPostsByUserId(userId) }
    }
    query("post") {
        description = "Returns post by Id"
        resolver { id: Int -> getPostById(id) }
    }
}