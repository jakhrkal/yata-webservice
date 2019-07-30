package cz.jakhrkal.testing.webservice.yata.model.data

import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<Task, Long> {
    fun findAllByUserId(id: Long): Iterable<Task>
}

interface UserRepository : CrudRepository<User, Long>