package io.projects.book_service.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.yaml.snakeyaml.constructor.Constructor
import java.time.Instant
import java.time.LocalDate

@Document(collection = "books")
data class Book(
    @Id
    val id: String? = null,
    val title: String,
    val description: String?,
    @DBRef
    val authors: List<Author>,
    val genres: List<Genre>?,


    val isbn: String?,
    val publisher: String?,
    val publishedDate: LocalDate?,
    val format: String?,

    val cover: String?,
    val createdAt: Instant?,
    val updatedAt: Instant?
)
