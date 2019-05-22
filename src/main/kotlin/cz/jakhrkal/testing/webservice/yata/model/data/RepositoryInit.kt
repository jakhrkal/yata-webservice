package cz.jakhrkal.testing.webservice.yata.model.data

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class RepositoryInit {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            taskRepository: TaskRepository) = CommandLineRunner {
        val user = User("Test", "User", "test.user@exmple.com")
        userRepository.save(user)

        taskRepository.save(Task("Eat sandwich", "Lorem ipsum", LocalDateTime.of(2020, 1, 1, 1, 1), user))
        taskRepository.save(Task("Save the world", "dolor sit amet", LocalDateTime.of(2100, 1, 1, 1, 1), user))
    }
}