package cz.jakhrkal.testing.webservice.yata.controller.rest

import cz.jakhrkal.testing.webservice.yata.model.data.Task
import cz.jakhrkal.testing.webservice.yata.model.data.User
import cz.jakhrkal.testing.webservice.yata.model.service.TodoAppService
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

//    http://localhost:8080/api/rest/tasks/

@RestController
@RequestMapping("/api/rest")
class RestController(private val todoAppService: TodoAppService) {

    @GetMapping("/hello")
    fun sayHello(@RequestParam("name") text: String) = "Hello, $text"

    @GetMapping("/tasks")
    fun getAllTasks() = todoAppService.findAllTasks()

    @GetMapping("/tasks/{id}")
    fun getTask(@PathVariable id: Long) = todoAppService.findTaskById(id)

    @GetMapping("/users")
    fun getAllUsers() = todoAppService.findAllUsers()

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long) = todoAppService.findUserById(id)

    @GetMapping("/users/{id}/tasks")
    fun getTasksOfUser(@PathVariable id: Long) = todoAppService.findTasksByUser(id)

    @PostMapping("/tasks")
    fun updateTask(@RequestBody task: Task) = todoAppService.updateTask(task)

    @PostMapping("/users")
    fun updateUser(@RequestBody user: User) = todoAppService.updateUser(user)

    @DeleteMapping("/tasks/{id}")
    fun deleteTask(@PathVariable id: Long) = todoAppService.deleteTaskById(id)

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Long) = todoAppService.deleteUserById(id)
}