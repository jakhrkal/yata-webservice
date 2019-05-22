package cz.jakhrkal.testing.webservice.yata.controller.soap

import cz.jakhrkal.testing.webservice.yata.model.data.Task
import cz.jakhrkal.testing.webservice.yata.model.data.User
import cz.jakhrkal.testing.webservice.yata.model.service.TodoAppService
import javax.jws.WebService

@WebService(endpointInterface = "cz.jakhrkal.testing.webservice.yata.controller.soap.TodoAppSoapService")
class TodoAppSoapServiceImpl(private val todoAppService : TodoAppService) : TodoAppSoapService {

    override fun sayHello(text: String): String {
        return "Hello, $text"
    }

    override fun getTaskDetails(id: Long): Task {
        return todoAppService.findTaskById(id).get()
    }

    override fun getAllTasks(): List<Task> {
        return todoAppService.findAllTasks()
    }

    override fun getUserDetails(id: Long): User {
        return todoAppService.findUserById(id).get()
    }

    override fun getAllUsers(): List<User> {
        return todoAppService.findAllUsers()
    }

}
