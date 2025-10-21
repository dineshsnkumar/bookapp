package io.projects.book_service.service.impl

import io.projects.book_service.dto.AuthorRequestDTO
import io.projects.book_service.dto.AuthorResponseDTO
import io.projects.book_service.entity.Author
import io.projects.book_service.mapper.AuthorRequestMapper
import io.projects.book_service.mapper.AuthorResponseMapper
import io.projects.book_service.repository.AuthorRepository
import io.projects.book_service.service.AuthorService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.time.Instant
import java.time.LocalDateTime
import java.util.UUID
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
@DisplayName("Author Service Unit Tests")
class AuthorServiceImplTest {

    @Mock
    private lateinit var authorRepository: AuthorRepository
    @Mock
    private  lateinit var authorRequestMapper: AuthorRequestMapper
    @Mock
    private lateinit var authorResponseMapper: AuthorResponseMapper

    @InjectMocks
    private lateinit var authorService: AuthorService

    private lateinit var authorRequestDTO: AuthorRequestDTO
    private lateinit var authorResponseDTO: AuthorResponseDTO
    private lateinit var author: Author

    @BeforeEach
    fun setUp() {
        authorResponseDTO = AuthorResponseDTO(displayName = "Leo Tolstoy", createdDate = Instant.now(),
            id =  UUID.randomUUID().toString())
        authorRequestDTO = AuthorRequestDTO(displayName = "Leo Tolstoy")
        author = Author(displayName = "Leo Tolstoy", createdDate = Instant.now())
    }

    @Test
    fun savedAuthorSuccessfully(){
        authorService.saveAuthor(authorRequestDTO)

    }

}

