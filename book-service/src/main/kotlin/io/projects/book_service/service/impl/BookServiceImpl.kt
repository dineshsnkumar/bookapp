package io.projects.book_service.service.impl

import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Book
import io.projects.book_service.exception.ResourceNotFoundException
import io.projects.book_service.mapper.BookRequestMapper
import io.projects.book_service.mapper.BookResponseMapper
import io.projects.book_service.repository.BookRepository
import io.projects.book_service.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException
import java.util.Optional

@Service
class BookServiceImpl(
    val bookRepository: BookRepository,
    val bookRequestMapper: BookRequestMapper,
    val bookResponseMapper: BookResponseMapper
) : BookService {
    override fun getBookById(id: String): Optional<BookResponseDTO> {
        val bookResponse = bookRepository.findById(id).map { book -> bookResponseMapper.toResponse(book) }
        if (bookResponse.isPresent) {
            return bookResponse
        } else {
            throw ResourceNotFoundException("message with $id is not found")
        }
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