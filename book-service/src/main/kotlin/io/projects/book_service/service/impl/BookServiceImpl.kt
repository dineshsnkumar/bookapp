package io.projects.book_service.service.impl

import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.entity.Book
import io.projects.book_service.service.BookService

class BookServiceImpl: BookService {
    override fun getBookById(id: String): Book? {
        TODO("Not yet implemented")
    }

    override fun getAllBooks(): List<Book> {
        TODO("Not yet implemented")
    }

    override fun saveBook(book: BookRequestDTO): Book {
        TODO("Not yet implemented")
    }

    override fun updateBook(book: BookRequestDTO): Book {
        TODO("Not yet implemented")
    }

    override fun deleteBook(id: String): Boolean {
        TODO("Not yet implemented")
    }
}