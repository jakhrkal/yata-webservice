package cz.jakhrkal.testing.webservice.yata.controller.rest

import cz.jakhrkal.testing.webservice.yata.model.service.TodoAppService
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

//    http://localhost:8080/api/rest/task/

@RestController
@RequestMapping("/api/rest")
class RestController(private val todoAppService: TodoAppService) {

    @GetMapping("/hello")
    fun sayHello(@RequestParam("name") text: String) = "Hello, $text"

    @GetMapping("/task")
    fun getAllTasks() = todoAppService.findAllTasks()

    @GetMapping("/task/{id}")
    fun getTask(@PathVariable id: Long) = todoAppService.findTaskById(id)

    @GetMapping("/user")
    fun getAllUsers() = todoAppService.findAllUsers()

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Long) = todoAppService.findUserById(id)
}