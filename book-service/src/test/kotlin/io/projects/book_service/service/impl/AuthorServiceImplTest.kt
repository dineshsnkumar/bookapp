package io.projects.book_service.service.impl

import io.projects.book_service.dto.AuthorRequestDTO
import io.projects.book_service.dto.AuthorResponseDTO
import io.projects.book_service.entity.Author
import io.projects.book_service.exception.ResourceNotFoundException
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
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.argThat
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.time.Instant
import java.time.LocalDateTime
import java.util.Optional
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
    private lateinit var authorService: AuthorServiceImpl

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
        whenever(authorRequestMapper.toEntity(authorRequestDTO)).thenReturn(author)
        whenever(authorResponseMapper.toResponse(author)).thenReturn(authorResponseDTO)
        whenever(authorRepository.save<Author>(author)).thenReturn(author)

        val authorResponse = authorService.saveAuthor(authorRequestDTO)

        assertEquals("Leo Tolstoy", authorResponse.displayName)
        verify(authorRepository, times(1)).save(author)

        verify(authorRepository).save(argThat { author -> author.displayName.equals("Leo Tolstoy") })
    }

    @Test
    fun getAuthorSuccessfully(){
        val authorId = UUID.randomUUID().toString()
        val currAuthor = Author("Leo Tolstoy", authorId, createdDate = Instant.now())
        val authorResponseDTO = AuthorResponseDTO(displayName = "Leo Tolstoy", id = authorId, createdDate = Instant.now())
        whenever(authorRepository.findById(authorId)).thenReturn(Optional.of<Author>(currAuthor))
        whenever(authorResponseMapper.toResponse(currAuthor)).thenReturn(authorResponseDTO)

        val authorResponse = authorService.getAuthorById(authorId)

        assertEquals("Leo Tolstoy", authorResponse.get().displayName)
        verify(authorRepository, times(1)).findById(authorId)
    }

    @Test
    fun updateAuthorNotFound(){
        val authorId = UUID.randomUUID().toString()
        val requestDTO = AuthorRequestDTO("Leo Tolstoy", authorId)

        whenever(authorRepository.findById(authorId)).thenReturn(Optional.empty())

        val resourceNotFoundException = assertThrows(ResourceNotFoundException::class.java){
            authorService.updateAuthor(requestDTO)
        }

        assert(resourceNotFoundException.message!!.contains("Author with authorId ${authorId} does not exist"))

        verify(authorRepository).findById(authorId)


    }

}

