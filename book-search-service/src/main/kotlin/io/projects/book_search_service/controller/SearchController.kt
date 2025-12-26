package io.projects.book_search_service.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search")
class SearchController {
    @GetMapping("/books")
    fun searchBooks(): String {
        return "All is well there!"
    }
}