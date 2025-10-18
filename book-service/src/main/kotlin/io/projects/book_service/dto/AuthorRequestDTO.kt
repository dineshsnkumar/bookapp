package io.projects.book_service.dto

import java.time.LocalDate

data class AuthorRequestDTO (
    val authorId: String? = null,
    val displayName: String,
    val firstName: String? = null,
    val lastName: String? = null,
    val suffix: String? = null,

    val birthDate: LocalDate? = null,
    val deathDate: LocalDate? = null,
    val nationality: String? = null,
    val biography: String? = null
)