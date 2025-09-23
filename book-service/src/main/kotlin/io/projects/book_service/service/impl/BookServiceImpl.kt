package io.projects.book_service.service.impl

import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Book
import io.projects.book_service.mapper.BookRequestMapper
import io.projects.book_service.mapper.BookResponseMapper
import io.projects.book_service.repository.BookRepository
import io.projects.book_service.service.BookService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class BookServiceImpl(val bookRepository: BookRepository, val bookRequestMapper: BookRequestMapper, val bookResponseMapper: BookResponseMapper): BookService {
    override fun getBookById(id: String): Optional<Book> {
        TODO("Not yet implemented")
    }

    override fun getAllBooks(): List<BookResponseDTO> {
         val bookList = bookRepository.findAll()
        return bookList.map { book -> bookResponseMapper.toResponse(book) }
    }
    @Transactional
    override fun saveBook(bookRequestDTO: BookRequestDTO): BookResponseDTO {
        val book = bookRequestMapper.toEntity(bookRequestDTO)
        val savedBook = bookRepository.save(book)
        return bookResponseMapper.toResponse(savedBook)
    }

    override fun updateBook(book: BookRequestDTO): Book {
        TODO("Not yet implemented")
    }

    override fun deleteBook(id: String): Boolean {
        TODO("Not yet implemented")
    }
}