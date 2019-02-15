package cz.jakhrkal.testing.webservice.library

import cz.jakhrkal.testing.webservice.library.model.data.Author
import cz.jakhrkal.testing.webservice.library.model.data.AuthorRepository
import cz.jakhrkal.testing.webservice.library.model.data.Book
import cz.jakhrkal.testing.webservice.library.model.data.BookRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class LibraryApplication {

	@Bean
	fun databaseInitializer(authorRepository: AuthorRepository,
									bookRepository: BookRepository) = CommandLineRunner {
		val smaldini = Author("Stéphane", "Maldini", "Rising star of thriller")
		authorRepository.save(smaldini)

		bookRepository.save(Book(
				"Reactor Bismuth is out",
				"Lorem ipsum",
				2019,
				smaldini
		))
		bookRepository.save(Book(
				"Reactor Aluminium has landed",
				"Lorem ipsum",
				2015,
				smaldini
		))
	}
}

fun main(args: Array<String>) {
	runApplication<LibraryApplication>(*args)
}

