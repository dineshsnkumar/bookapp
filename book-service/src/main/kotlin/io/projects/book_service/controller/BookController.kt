package io.projects.book_service.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

@RestController
@RequestMapping("/books")
class BookController {

    val booksList = mutableListOf<String>("Anna Karenina", "War and Peace");

    @GetMapping
    fun getAllBooks(): List<String> {
        return booksList
    }

    @GetMapping("/{bookId}")
    fun getBookById(@PathVariable("bookId") bookId: Int): String {
        return "You asked for ${bookId}"
    }

    @PostMapping
    fun addBook(): Unit {
        
    }

    @PutMapping
    fun updateBook(book: String): Unit {

    }

    @DeleteMapping
    fun deleteBook(book: String): Unit {

    }

}