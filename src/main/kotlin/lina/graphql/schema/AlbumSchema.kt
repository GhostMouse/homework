package lina.graphql.schema

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import lina.clients.jsonplaceholder.*
import lina.model.Album
import lina.model.AlbumInput

fun SchemaBuilder.albumSchema() {
    type<Album> {
        description = "Album description"
    }
    inputType<AlbumInput> {
        name = "albumInput"
    }
    query("albums") {
        description = "Returns all albums"
        resolver { -> getAllAlbums() }
    }
    query("albumsByUserId") {
        description = "Returns albums by user Id"
        resolver { userId: Int -> getAlbumsByUserId(userId) }
    }
    query("album") {
        description = "Returns album by Id"
        resolver { id: Int -> getAlbumById(id) }
    }
    mutation("addAlbum") {
        description = "Adds album"
        resolver { albumInput: AlbumInput -> addAlbum(albumInput) }
    }
}