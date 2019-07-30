package cz.jakhrkal.testing.webservice.yata.model.service.impl

import cz.jakhrkal.testing.webservice.yata.model.data.Task
import cz.jakhrkal.testing.webservice.yata.model.data.TaskRepository
import cz.jakhrkal.testing.webservice.yata.model.data.User
import cz.jakhrkal.testing.webservice.yata.model.data.UserRepository
import cz.jakhrkal.testing.webservice.yata.model.service.TodoAppService
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoAppServiceImpl(private val taskRepository: TaskRepository,
                         private val userRepository: UserRepository) : TodoAppService {

    override fun findAllTasks() : List<Task> = taskRepository.findAll().asSequence().toList()

    override fun findTaskById(id: Long) : Optional<Task> = taskRepository.findById(id)

    override fun findAllUsers() : List<User> = userRepository.findAll().asSequence().toList()

    override fun findUserById(id: Long) : Optional<User> = userRepository.findById(id)

    override fun findTasksByUser(id: Long): List<Task> = taskRepository.findAllByUserId(id).asSequence().toList();

    override fun updateTask(task: Task): Task = taskRepository.save(task)

    override fun updateUser(user: User): User = userRepository.save(user)

    override fun deleteTaskById(id: Long) = taskRepository.deleteById(id)

    override fun deleteUserById(id: Long) = userRepository.deleteById(id)

}
