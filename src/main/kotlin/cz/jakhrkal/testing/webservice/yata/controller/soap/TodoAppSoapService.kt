package cz.jakhrkal.testing.webservice.yata.controller.soap

import cz.jakhrkal.testing.webservice.yata.model.data.Task
import cz.jakhrkal.testing.webservice.yata.model.data.User
import javax.jws.WebMethod
import javax.jws.WebParam
import javax.jws.WebResult
import javax.jws.WebService

@WebService
interface TodoAppSoapService {

    @WebMethod
    @WebResult(name = "Greeting")
    fun sayHello(@WebParam(name = "GreetName") text: String): String

    @WebMethod
    @WebResult(name = "Task")
    fun getAllTasks(): List<Task>

    @WebMethod
    @WebResult(name = "Task")
    fun getTaskDetails(@WebParam(name = "TaskId") id: Long): Task

    @WebMethod
    @WebResult(name = "User")
    fun getAllUsers(): List<User>

    @WebMethod
    @WebResult(name = "User")
    fun getUserDetails(@WebParam(name = "UserId") id: Long): User

    @WebMethod
    @WebResult(name = "Task")
    fun getTasksOfUser(@WebParam(name = "UserId") id: Long): List<Task>

    @WebMethod
    @WebResult(name = "Task")
    fun updateTask(@WebParam(name = "TaskId") task: Task): Task

    @WebMethod
    @WebResult(name = "User")
    fun updateUser(@WebParam(name = "UserId") user: User): User

    @WebMethod
    @WebResult(name = "ActionSuccessful")
    fun deleteTask(@WebParam(name = "TaskId") id: Long)

    @WebMethod
    @WebResult(name = "ActionSuccessful")
    fun deleteUser(@WebParam(name = "UserId") id: Long)
}
