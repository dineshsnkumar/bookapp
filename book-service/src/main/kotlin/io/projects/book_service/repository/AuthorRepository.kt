package io.projects.book_service.repository

import io.projects.book_service.entity.Author
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository: MongoRepository<Author, String> {
}