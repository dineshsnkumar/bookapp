package io.projects.book_service.repository

import io.projects.book_service.entity.Book
import org.springframework.data.mongodb.repository.MongoRepository

interface BookRepository: MongoRepository<Book, String> {
}