package io.projects.book_service.mapper

import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.entity.Book
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.Mapping
import java.time.Instant

@Component
class BookRequestMapper {
    fun toEntity(bookRequestDTO: BookRequestDTO): Book{
        return Book(title = bookRequestDTO.title, description = bookRequestDTO.description,
            authors = bookRequestDTO.authors, genres = bookRequestDTO.genres,
            isbn = bookRequestDTO.isbn, publisher = bookRequestDTO.publisher, publishedDate = bookRequestDTO.publishedDate,
            format = bookRequestDTO.format, cover = bookRequestDTO.cover, createdAt = Instant.now(), updatedAt = bookRequestDTO.updatedAt)
    }

}