package io.projects.book_service.service.impl

import io.projects.book_service.dto.AuthorRequestDTO
import io.projects.book_service.dto.AuthorResponseDTO
import io.projects.book_service.entity.Author
import io.projects.book_service.exception.ResourceNotFoundException
import io.projects.book_service.mapper.AuthorRequestMapper
import io.projects.book_service.mapper.AuthorResponseMapper
import io.projects.book_service.repository.AuthorRepository
import io.projects.book_service.service.AuthorService
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class AuthorServiceImpl(
    val authorRepository: AuthorRepository, val authorRequestMapper: AuthorRequestMapper,
    val authorResponseMapper: AuthorResponseMapper
) : AuthorService {
    override fun getAuthorById(authorId: String): Optional<AuthorResponseDTO> {
        val author = authorRepository.findById(authorId.trim()).map { author -> authorResponseMapper.toResponse(author) }
        if (!author.isPresent) {
            throw ResourceNotFoundException("Author with ${authorId} is not present}")
        }
        return author
    }

    override fun getAllAuthors(): List<AuthorResponseDTO> {
        return authorRepository.findAll().map { author -> authorResponseMapper.toResponse(author) }
    }

    override fun saveAuthor(authorRequestDTO: AuthorRequestDTO): AuthorResponseDTO {
        val author = authorRequestMapper.toEntity(authorRequestDTO)
        val savedAuthor = authorRepository.save(author)
        return authorResponseMapper.toResponse(savedAuthor)
    }

    override fun updateAuthor(authorRequestDTO: AuthorRequestDTO): AuthorResponseDTO {
        val authorId = authorRequestDTO.authorId?.trim()
        if (authorId != null){
            val author = authorRepository.findById(authorId)
            if (!author.isPresent){
                throw ResourceNotFoundException("Author with authorId ${authorId} does not exist")
            }
        }
        val updatedAuthor = authorRequestMapper.toEntity(authorRequestDTO)
        val savedAuthor = authorRepository.save(updatedAuthor)

        return authorResponseMapper.toResponse(savedAuthor)

    }

    override fun deleteAuthor(authorId: String): Unit {
        val author = authorRepository.findById(authorId)
        if (!author.isPresent){
           throw ResourceNotFoundException("Author with authorId ${authorId} does not exist")
        }
        authorRepository.deleteById(authorId)
    }
}