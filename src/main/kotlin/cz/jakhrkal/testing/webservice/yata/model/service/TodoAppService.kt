package cz.jakhrkal.testing.webservice.yata.model.service

import cz.jakhrkal.testing.webservice.yata.model.data.Task
import cz.jakhrkal.testing.webservice.yata.model.data.User
import java.util.*

interface TodoAppService {

    fun findAllTasks() : List<Task>

    fun findTaskById(id: Long) : Optional<Task>

    fun findAllUsers() : List<User>

    fun findUserById(id: Long) : Optional<User>

    fun findTasksByUser(id: Long): List<Task>

    fun updateTask(task: Task): Task

    fun updateUser(user: User): User

    fun deleteTaskById(id: Long)
    
    fun deleteUserById(id: Long)

}
