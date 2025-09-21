package io.projects.book_service.service

import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Book

interface BookService {
    fun getBookById(id: String): Book?
    fun getAllBooks(): List<Book>
    fun saveBook(bookRequestDTO: BookRequestDTO): BookResponseDTO
    fun updateBook(book: BookRequestDTO): Book
    fun deleteBook(id: String): Boolean
}