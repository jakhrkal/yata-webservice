package cz.jakhrkal.testing.webservice.library

import cz.jakhrkal.testing.webservice.library.model.data.Author
import cz.jakhrkal.testing.webservice.library.model.data.AuthorRepository
import cz.jakhrkal.testing.webservice.library.model.data.Book
import cz.jakhrkal.testing.webservice.library.model.data.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
class RepositoriesTests(@Autowired val entityManager: TestEntityManager,
                        @Autowired val authorRepository: AuthorRepository,
                        @Autowired val bookRepository: BookRepository) {

    @Test
    fun `When findById then return Article`() {
        val juergen = Author("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        val article = Book("Spring Framework 5.0 goes GA", "Dear Spring community ...", 2010, juergen)
        entityManager.persist(article)
        entityManager.flush()

        val found = bookRepository.findById(article.id!!)

        assertThat(found.get()).isEqualTo(article)
    }

    @Test
    fun `When findById then return User`() {
        val juergen = Author("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        entityManager.flush()

        val found = authorRepository.findById(juergen.id!!)

        assertThat(found.get()).isEqualTo(juergen)
    }

}