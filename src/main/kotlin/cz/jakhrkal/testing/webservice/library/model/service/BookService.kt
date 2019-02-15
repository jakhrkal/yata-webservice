package cz.jakhrkal.testing.webservice.library.model.service

import cz.jakhrkal.testing.webservice.library.model.data.AuthorRepository
import cz.jakhrkal.testing.webservice.library.model.data.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository,
                  private val authorRepository: AuthorRepository) {

    fun findAllBooks() = bookRepository.findAll()

    fun findBookById(id: Long) = bookRepository.findById(id)

    fun findAllAuthors() = authorRepository.findAll()

    fun findAuthorById(id: Long) = authorRepository.findById(id)

}
