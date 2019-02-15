package cz.jakhrkal.testing.webservice.library.controller.rest

import cz.jakhrkal.testing.webservice.library.model.data.AuthorRepository
import cz.jakhrkal.testing.webservice.library.model.data.BookRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//    http://localhost:8080/api/rest/book/

@RestController
@RequestMapping("/api/rest/book")
class BookController(private val repository: BookRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long) = repository.findById(id)
}

@RestController
@RequestMapping("/api/rest/author")
class AuthorController(private val repository: AuthorRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable id: Long) = repository.findById(id)
}