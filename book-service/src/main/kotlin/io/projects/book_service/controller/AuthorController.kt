package io.projects.book_service.controller

import io.projects.book_service.dto.AuthorRequestDTO
import io.projects.book_service.dto.AuthorResponseDTO
import io.projects.book_service.entity.Author
import io.projects.book_service.service.AuthorService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/authors")
class AuthorController(val authorService: AuthorService) {

    @GetMapping("/{authorId}")
    fun getAuthorById(@PathVariable("authorId") authorId: String): Optional<AuthorResponseDTO> {
        return authorService.getAuthorById(authorId)
    }

    @GetMapping
    fun getAllAuthors(): List<AuthorResponseDTO> {
        return authorService.getAllAuthors()
    }

    @PostMapping
    fun saveAuthor(@RequestBody @Valid authorRequestDTO: AuthorRequestDTO): AuthorResponseDTO {
        return authorService.saveAuthor(authorRequestDTO)
    }

    @PutMapping
    fun updateAuthor(@RequestBody @Valid authorRequestDTO: AuthorRequestDTO): AuthorResponseDTO {
        return authorService.updateAuthor(authorRequestDTO)
    }

    @DeleteMapping("/{authorId}")
    fun deleteAuthor(@PathVariable("authorId") authorId: String) {
        return authorService.deleteAuthor(authorId)
    }

}