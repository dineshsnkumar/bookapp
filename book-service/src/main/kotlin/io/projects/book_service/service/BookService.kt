package io.projects.book_service.service

import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Book
import java.util.Optional

interface BookService {
    fun getBookById(id: String): Optional<BookResponseDTO>
    fun getAllBooks(): List<BookResponseDTO>
    fun saveBook(bookRequestDTO: BookRequestDTO): BookResponseDTO
    fun updateBook(bookRequestDTO: BookRequestDTO): BookResponseDTO
    fun deleteBook(bookId: String): Unit
}