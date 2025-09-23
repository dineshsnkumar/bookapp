package io.projects.book_service.mapper

import io.projects.book_service.dto.AuthorResponseDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Author
import io.projects.book_service.entity.Book
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class AuthorResponseMapper {
    fun toResponse(author: Author): AuthorResponseDTO {
        return AuthorResponseDTO(id = author.id, displayName = author.displayName, firstName = author.firstName,
            lastName = author.lastName, suffix = author.suffix, birthDate = author.birthDate,
            deathDate = author.deathDate, nationality = author.nationality,
            biography = author.biography, createdDate = author.createdDate)
    }
}