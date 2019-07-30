package cz.jakhrkal.testing.webservice.yata.controller.soap

import cz.jakhrkal.testing.webservice.yata.model.data.Task
import cz.jakhrkal.testing.webservice.yata.model.data.User
import cz.jakhrkal.testing.webservice.yata.model.service.TodoAppService
import javax.jws.WebService

@WebService(name = "TodoApp-SOAP-WS", serviceName = "TodoApp", endpointInterface = "cz.jakhrkal.testing.webservice.yata.controller.soap.TodoAppSoapService")
class TodoAppSoapServiceImpl(private val todoAppService : TodoAppService) : TodoAppSoapService {

    override fun sayHello(text: String): String = "Hello, $text"

    override fun getTaskDetails(id: Long): Task = todoAppService.findTaskById(id).get() // todo handle non-existing entries

    override fun getAllTasks(): List<Task> = todoAppService.findAllTasks()

    override fun getUserDetails(id: Long): User = todoAppService.findUserById(id).get()

    override fun getAllUsers(): List<User> = todoAppService.findAllUsers()

    override fun getTasksOfUser(id: Long) = todoAppService.findTasksByUser(id)

    override fun updateTask(task: Task) = todoAppService.updateTask(task)

    override fun updateUser(user: User) = todoAppService.updateUser(user)

    override fun deleteTask(id: Long) = todoAppService.deleteTaskById(id)

    override fun deleteUser(id: Long) = todoAppService.deleteUserById(id)

}
