package cz.jakhrkal.testing.webservice.library

import com.nhaarman.mockito_kotlin.whenever
import cz.jakhrkal.testing.webservice.library.model.data.Author
import cz.jakhrkal.testing.webservice.library.model.data.AuthorRepository
import cz.jakhrkal.testing.webservice.library.model.data.Book
import cz.jakhrkal.testing.webservice.library.model.data.BookRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ExtendWith(SpringExtension::class)
@WebMvcTest
class RestApiTests(@Autowired val mockMvc: MockMvc) {

    @MockBean
    private lateinit var authorRepository: AuthorRepository

    @MockBean
    private lateinit var bookRepository: BookRepository

    @Test
    fun `List articles`() {
        val juergen = Author("springjuergen", "Juergen", "Hoeller")
        val spring5Article = Book("Spring Framework 5.0 goes GA", "Dear Spring community ...", 2000, juergen, 1)
        val spring43Article = Book("Spring Framework 4.3 goes GA", "Dear Spring community ...", 2020, juergen, 2)
        whenever(bookRepository.findAll()).thenReturn(listOf(spring5Article, spring43Article))
        mockMvc.perform(get("/api/article/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.[0].author.firstName").value(juergen.firstName))
                .andExpect(jsonPath("\$.[0].id").value(spring5Article.id!!))
                .andExpect(jsonPath("\$.[1].author.firstName").value(juergen.firstName))
                .andExpect(jsonPath("\$.[1].id").value(spring43Article.id!!))
    }

    @Test
    fun `List users`() {
        val juergen = Author("springjuergen", "Juergen", "Hoeller")
        val smaldini = Author("smaldini", "Stéphane", "Maldini")
        whenever(authorRepository.findAll()).thenReturn(listOf(juergen, smaldini))
        mockMvc.perform(get("/api/user/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.[0].firstName").value(juergen.firstName))
                .andExpect(jsonPath("\$.[1].firstName").value(smaldini.firstName))
    }

}