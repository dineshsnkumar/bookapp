package io.projects.book_service.controller

import io.projects.book_service.dto.BookRequestDTO
import io.projects.book_service.dto.BookResponseDTO
import io.projects.book_service.entity.Book
import io.projects.book_service.service.BookService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/books")
class BookController (val bookService: BookService){

    @GetMapping
    fun getAllBooks(): List<Book> {
        return bookService.getAllBooks()
    }

    @GetMapping("/{bookId}")
    fun getBookById(@PathVariable("bookId") bookId: Int): String {
        return "You asked for ${bookId}"
    }

    @PostMapping
    fun saveBook(@RequestBody @Valid bookRequestDTO: BookRequestDTO): BookResponseDTO {
        return bookService.saveBook(bookRequestDTO)
    }

    @PutMapping
    fun updateBook(book: String): Unit {

    }

    @DeleteMapping
    fun deleteBook(book: String): Unit {

    }

}