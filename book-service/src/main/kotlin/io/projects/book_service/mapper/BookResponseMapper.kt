package io.projects.book_service.mapper

import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Book
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class BookResponseMapper {
    fun toResponse(book: Book): BookResponseDTO {
        return BookResponseDTO(title = book.title, description = book.description,
            authors = book.authors, genres = book.genres,
            isbn = book.isbn, publisher = book.publisher, publishedDate = book.publishedDate,
            format = book.format, cover = book.cover, createdAt = Instant.now(), updatedAt = book.updatedAt,
            id = book.id)
    }
}