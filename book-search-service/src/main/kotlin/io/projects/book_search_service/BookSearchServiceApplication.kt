package io.projects.book_search_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookSearchServiceApplication

fun main(args: Array<String>) {
	runApplication<BookSearchServiceApplication>(*args)
}
