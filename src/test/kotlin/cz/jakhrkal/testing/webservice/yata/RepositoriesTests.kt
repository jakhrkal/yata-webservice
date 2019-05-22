package cz.jakhrkal.testing.webservice.yata

import cz.jakhrkal.testing.webservice.yata.model.data.Task
import cz.jakhrkal.testing.webservice.yata.model.data.TaskRepository
import cz.jakhrkal.testing.webservice.yata.model.data.User
import cz.jakhrkal.testing.webservice.yata.model.data.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@DataJpaTest
class RepositoriesTests(@Autowired val entityManager: TestEntityManager,
                        @Autowired val userRepository: UserRepository,
                        @Autowired val taskRepository: TaskRepository) {

    @Test
    fun `When findById then return Task`() {
        val user = User("New", "User", "newuser@mail.com")
        entityManager.persist(user)
        val task = Task("Learn Spring Framework", "I wanna be the very best", LocalDateTime.now(), user)
        entityManager.persist(task)
        entityManager.flush()

        val found = taskRepository.findById(task.id!!)

        assertThat(found.get()).isEqualTo(task)
    }

    @Test
    fun `When findById then return User`() {
        val user = User("New", "User", "newuser@mail.com")
        entityManager.persist(user)
        entityManager.flush()

        val found = userRepository.findById(user.id!!)

        assertThat(found.get()).isEqualTo(user)
    }

}