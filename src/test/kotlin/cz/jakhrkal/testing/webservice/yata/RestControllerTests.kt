package cz.jakhrkal.testing.webservice.yata

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class RestControllerTests {

    @Autowired
    private val mvc: MockMvc? = null

    // todo test other methods

    @Test
    fun getAllTasks() {
        mvc!!.perform(get("/api/rest/task/").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.[0].user.firstName").isNotEmpty)
                .andExpect(jsonPath("$.[0].id").isNotEmpty)
                .andExpect(jsonPath("$.[0].title").isNotEmpty)
                .andExpect(jsonPath("$.[1].user.firstName").isNotEmpty)
                .andExpect(jsonPath("$.[1].id").isNotEmpty)
                .andExpect(jsonPath("$.[1].title").isNotEmpty)
    }
}