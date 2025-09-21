package io.projects.book_service.service

import io.projects.book_service.dto.AuthorRequestDTO
import io.projects.book_service.dto.AuthorResponseDTO
import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Author
import io.projects.book_service.entity.Book

interface AuthorService {
    fun getAuthorById(id: String): Author?
    fun getAllAuthors(): List<Author>
    fun saveAuthor(authorRequestDTO: AuthorRequestDTO): AuthorResponseDTO
    fun updateAuthor(authorRequestDTO: AuthorRequestDTO): Author
    fun deleteAuthor(id: String): Boolean
}