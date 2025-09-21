package io.projects.book_service.repository

import io.projects.book_service.entity.Author
import org.springframework.data.mongodb.repository.MongoRepository

interface AuthorRepository: MongoRepository<Author, String> {
}