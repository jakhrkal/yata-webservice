package cz.jakhrkal.testing.webservice.yata.model.service.impl

import cz.jakhrkal.testing.webservice.yata.model.data.Task
import cz.jakhrkal.testing.webservice.yata.model.data.TaskRepository
import cz.jakhrkal.testing.webservice.yata.model.data.UserRepository
import cz.jakhrkal.testing.webservice.yata.model.service.TodoAppService
import org.springframework.stereotype.Service

@Service
class TodoAppServiceImpl(private val taskRepository: TaskRepository,
                         private val userRepository: UserRepository) : TodoAppService {

    override fun findAllTasks() : List<Task> = taskRepository.findAll().asSequence().toList()

    override fun findTaskById(id: Long) = taskRepository.findById(id)

    override fun findAllUsers() = userRepository.findAll().asSequence().toList()

    override fun findUserById(id: Long) = userRepository.findById(id)

}
