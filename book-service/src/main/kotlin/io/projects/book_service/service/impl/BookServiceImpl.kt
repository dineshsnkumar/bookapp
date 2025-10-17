package io.projects.book_service.service.impl

import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Book
import io.projects.book_service.exception.ResourceAlreadyExistsException
import io.projects.book_service.exception.ResourceNotFoundException
import io.projects.book_service.mapper.BookRequestMapper
import io.projects.book_service.mapper.BookResponseMapper
import io.projects.book_service.repository.BookRepository
import io.projects.book_service.service.BookService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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
        val checkBook = bookRepository.findByIsbn(bookRequestDTO.isbn)
        if (checkBook.isPresent){
            throw ResourceAlreadyExistsException("Book with ${checkBook.get().title}  and " +
                    "isbn ${checkBook.get().isbn} already exists")
        }
        val book = bookRequestMapper.toEntity(bookRequestDTO)
        val savedBook = bookRepository.save(book)
        return bookResponseMapper.toResponse(savedBook)
    }

    @Transactional
    override fun updateBook(bookRequestDTO: BookRequestDTO): BookResponseDTO {
        val checkBook = bookRepository.findByIsbn(bookRequestDTO.isbn?.trim())
        if (!checkBook.isPresent){
            throw ResourceAlreadyExistsException("Book with ${bookRequestDTO.title}  and " +
                    "isbn ${bookRequestDTO.isbn} does not exist. Please check the details again")
        }
        val book = bookRequestMapper.toEntity(bookRequestDTO)
        val updatedBook = bookRepository.save(book)
        return bookResponseMapper.toResponse(updatedBook)
    }

    override fun deleteBook(bookId: String): Unit {
        val checkBook = bookRepository.findById(bookId)
        if (!checkBook.isPresent){
            throw ResourceNotFoundException("Book with ${bookId} does not exist. Please check the details again")
        }
        bookRepository.deleteById(bookId)
    }
}