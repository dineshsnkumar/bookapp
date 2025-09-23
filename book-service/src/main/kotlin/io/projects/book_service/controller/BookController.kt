package io.projects.book_service.controller

import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Book
import io.projects.book_service.service.BookService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.Optional

@RestController
@RequestMapping("/books")
class BookController (val bookService: BookService){

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllBooks(): List<BookResponseDTO> {
        return bookService.getAllBooks()
    }

    @GetMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    fun getBookById(@PathVariable("bookId") bookId: String): Optional<Book> {
        return bookService.getBookById(bookId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveBook(@RequestBody @Valid bookRequestDTO: BookRequestDTO): BookResponseDTO {
        return bookService.saveBook(bookRequestDTO)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateBook(book: String): Unit {

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(book: String): Unit {

    }

}