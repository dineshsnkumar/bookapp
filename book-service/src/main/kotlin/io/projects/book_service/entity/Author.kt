package io.projects.book_service.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.time.LocalDate

@Document(collection = "authors")
data class Author(
    @Id
    val id: String? = null,
    val displayName: String,
    val firstName: String? = null,
    val lastName: String? = null,
    val suffix: String? = null,

    val birthDate: LocalDate? = null,
    val deathDate: LocalDate? = null,
    val nationality: String? = null,
    val biography: String? = null,

    val createdDate: Instant?

)
