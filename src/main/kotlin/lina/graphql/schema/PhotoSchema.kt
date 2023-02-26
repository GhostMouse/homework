package lina.graphql.schema

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import lina.clients.jsonplaceholder.getAllPhotos
import lina.clients.jsonplaceholder.getPhotoById
import lina.clients.jsonplaceholder.getPhotosByAlbumId
import lina.model.Photo

fun SchemaBuilder.photoSchema() {
    type<Photo> {
        description = "Comment description"
    }
    query("photos") {
        description = "Returns all photos"
        resolver { -> getAllPhotos() }
    }
    query("photosByAlbumId") {
        description = "Returns photos by album Id"
        resolver { albumId: Int -> getPhotosByAlbumId(albumId) }
    }
    query("photo") {
        description = "Returns photo by Id"
        resolver { id: Int -> getPhotoById(id) }
    }
}