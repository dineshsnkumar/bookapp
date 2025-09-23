package io.projects.book_service.mapper

import io.projects.book_service.dto.AuthorRequestDTO
import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.entity.Author
import io.projects.book_service.entity.Book
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class AuthorRequestMapper {
    fun toEntity(authorRequestDTO: AuthorRequestDTO): Author{
        return Author(displayName = authorRequestDTO.displayName, firstName = authorRequestDTO.firstName,
            lastName = authorRequestDTO.lastName, suffix = authorRequestDTO.suffix, birthDate = authorRequestDTO.birthDate,
            deathDate = authorRequestDTO.deathDate, nationality = authorRequestDTO.nationality,
            biography = authorRequestDTO.biography, createdDate = Instant.now())
    }
}