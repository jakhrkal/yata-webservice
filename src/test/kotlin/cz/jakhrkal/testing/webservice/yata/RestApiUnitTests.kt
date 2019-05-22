package cz.jakhrkal.testing.webservice.yata

import com.nhaarman.mockito_kotlin.whenever
import cz.jakhrkal.testing.webservice.yata.model.data.Task
import cz.jakhrkal.testing.webservice.yata.model.data.TaskRepository
import cz.jakhrkal.testing.webservice.yata.model.data.User
import cz.jakhrkal.testing.webservice.yata.model.data.UserRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class RestApiUnitTests(@Autowired val mockMvc: MockMvc) {

    @MockBean
    private lateinit var userRepository: UserRepository

    @MockBean
    private lateinit var taskRepository: TaskRepository

    @Test
    fun `List tasks`() {
        val user = User("New", "User", "newuser@mail.com")
        val task1 = Task("Learn Spring Framework", "I wanna be the very best", LocalDateTime.now(), user)
        val task2 = Task("Save the dolphins", "I wish I could swim", LocalDateTime.now(), user)
        whenever(taskRepository.findAll()).thenReturn(listOf(task1, task2))
        mockMvc.perform(get("/api/rest/task/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.[0].user.firstName").value(user.firstName))
                .andExpect(jsonPath("\$.[0].title").value(task1.title))
                .andExpect(jsonPath("\$.[1].user.firstName").value(user.firstName))
                .andExpect(jsonPath("\$.[1].title").value(task2.title))
    }

    @Test
    fun `List users`() {
        val user = User("New", "User", "newuser@mail.com")
        val friend = User("Harry", "Potter", "harry_potter@hogwards.com")
        whenever(userRepository.findAll()).thenReturn(listOf(user, friend))
        mockMvc.perform(get("/api/rest/user/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.[0].firstName").value(user.firstName))
                .andExpect(jsonPath("\$.[1].firstName").value(friend.firstName))
    }

}