package io.projects.book_service.service.impl

import io.projects.book_service.dto.AuthorRequestDTO
import io.projects.book_service.dto.AuthorResponseDTO
import io.projects.book_service.entity.Author
import io.projects.book_service.mapper.AuthorRequestMapper
import io.projects.book_service.mapper.AuthorResponseMapper
import io.projects.book_service.repository.AuthorRepository
import io.projects.book_service.service.AuthorService
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class AuthorServiceImpl(val authorRepository: AuthorRepository, val authorRequestMapper: AuthorRequestMapper,
    val  authorResponseMapper: AuthorResponseMapper): AuthorService {
    override fun getAuthorById(id: String): Optional<Author>{
//        val author = authorRepository.findById(id)
//        if (author.isPresent){
//            return author
//        } else {
//            throw new
//        }
        TODO("Not yet implemented")
    }

    override fun getAllAuthors(): List<Author> {
        TODO("Not yet implemented")
    }

    override fun saveAuthor(authorRequestDTO: AuthorRequestDTO): AuthorResponseDTO {
        val author = authorRequestMapper.toEntity(authorRequestDTO)
        val savedAuthor = authorRepository.save(author)
        return authorResponseMapper.toResponse(savedAuthor)
    }

    override fun updateAuthor(authorRequestDTO: AuthorRequestDTO): Author {
        TODO("Not yet implemented")
    }

    override fun deleteAuthor(id: String): Boolean {
        TODO("Not yet implemented")
    }
}