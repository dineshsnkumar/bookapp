package io.projects.book_service.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collation = "genres")
data class Genre(
    @Id
    val id: String? = null,
    val name: String,
    val description: String?
)
