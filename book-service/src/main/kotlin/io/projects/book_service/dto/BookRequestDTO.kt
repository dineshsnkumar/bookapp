package io.projects.book_service.dto

import io.projects.book_service.entity.Author
import io.projects.book_service.entity.Genre
import java.time.Instant
import java.time.LocalDate

data class BookRequestDTO(
    val title: String,
    val description: String,

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
