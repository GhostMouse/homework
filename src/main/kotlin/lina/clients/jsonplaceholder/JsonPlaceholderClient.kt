package lina.clients.jsonplaceholder

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import lina.model.*

private val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json()
    }
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = "jsonplaceholder.typicode.com"
        }
    }

}

suspend fun getAllPosts(): List<Post> {
    return client.get("/posts").body()
}

suspend fun getPostsByUserId(userId: Int): List<Post> {
    return client.get("/users/${userId}/posts").body()
}

suspend fun getPostById(id: Int): Post {
    return client.get("/posts/${id}").body()
}

suspend fun getAllComments(): List<Comment> {
    return client.get("/comments").body()
}

suspend fun getCommentsByPostId(postId: Int): List<Comment> {
    return client.get("/posts/${postId}/comments").body()
}

suspend fun getCommentById(id: Int): Comment {
    return client.get("/comments/${id}").body()
}

suspend fun getAllAlbums(): List<Album> {
    return client.get("/albums").body()
}

suspend fun getAlbumsByUserId(userId: Int): List<Album> {
    return client.get("/users/${userId}/albums").body()
}

suspend fun getAlbumById(id: Int): Album {
    return client.get("/albums/${id}").body()
}

suspend fun addAlbum(albumInput: AlbumInput): Album {
    return client.post("albums") {
        contentType(ContentType.Application.Json)
        setBody(albumInput)
    }.body()
}

suspend fun getAllPhotos(): List<Photo> {
    return client.get("/photos").body()
}

suspend fun getPhotosByAlbumId(albumId: Int): List<Photo> {
    return client.get("/albums/${albumId}/photos").body()
}

suspend fun getPhotoById(id: Int): Photo {
    return client.get("/photos/${id}").body()
}

suspend fun getAllTodos(): List<Todo> {
    return client.get("/todos").body()
}

suspend fun getTodosByUserId(userId: Int): List<Todo> {
    return client.get("/users/${userId}/todos").body()
}

suspend fun getAllUsers(): List<User> {
    return client.get("/users").body()
}

suspend fun getTodoById(id: Int): Todo {
    return client.get("/todos/${id}").body()
}

suspend fun getUserById(id: Int): User {
    return client.get("/users/${id}").body()
}
