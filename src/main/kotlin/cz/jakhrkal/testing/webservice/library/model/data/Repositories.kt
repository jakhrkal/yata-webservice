package cz.jakhrkal.testing.webservice.library.model.data

import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long> {
    fun findAllByTitle(title : String): Iterable<Book>
}

interface AuthorRepository : CrudRepository<Author, Long>