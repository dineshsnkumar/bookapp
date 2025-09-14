package io.projects.book_service.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.time.LocalDate

@Document(collection = "books")
data class Book(
    @Id
    val id: String,
    val title: String,
    val description: String,
    val authors: List<Author>,
    val genres: List<Genre>,
    val rating: Double,
    val reviews: List<Review>,

    val isbn: String?,
    val publisher: String?,
    val publishedDate: LocalDate?,
    val format: String?,



    val cover: String?,
    val createdAt: Instant,
    val updatedAt: Instant?
)
