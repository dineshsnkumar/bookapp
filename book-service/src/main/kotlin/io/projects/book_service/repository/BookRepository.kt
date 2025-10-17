package io.projects.book_service.repository

import io.projects.book_service.entity.Book
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface BookRepository: MongoRepository<Book, String> {
    @Query("{'isbn' : ?0}")
    fun findByIsbn(isbn: String?): Optional<Book>
    fun deleteByIsbn(isbn: String?): Optional<Book>
}