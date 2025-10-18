package io.projects.book_service.service

import io.projects.book_service.dto.AuthorRequestDTO
import io.projects.book_service.dto.AuthorResponseDTO
import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Author
import io.projects.book_service.entity.Book
import java.util.Optional

interface AuthorService {
    fun getAuthorById(authorId: String): Optional<AuthorResponseDTO>
    fun getAllAuthors(): List<AuthorResponseDTO>
    fun saveAuthor(authorRequestDTO: AuthorRequestDTO): AuthorResponseDTO
    fun updateAuthor(authorRequestDTO: AuthorRequestDTO): AuthorResponseDTO
    fun deleteAuthor(authorId: String): Unit
}