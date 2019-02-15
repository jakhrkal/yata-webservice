package cz.jakhrkal.testing.webservice.library

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

//    TODO Integration tests
//    @BeforeAll
//    fun setup() {
//        println(">> Setup")
//    }
//
//    @Test
//    fun `Assert blog page title, content and status code`() {
//        println(">> Assert blog page title, content and status code")
//        val entity = restTemplate.getForEntity<String>("/")
//        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
//        assertThat(entity.body).contains("<h1>Blog</h1>")
//    }
//
//    @Test
//    fun `Assert article page title, content and status code`() {
//        println(">> Assert article page title, content and status code")
//        val entity = restTemplate.getForEntity<String>("/article/2")
//        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
//        assertThat(entity.body).contains("Reactor Aluminium has landed",
//                "<a href=\"https://projectreactor.io/\">https://projectreactor.io/</a>")
//    }
//
//    @AfterAll
//    fun teardown() {
//        println(">> Tear down")
//    }

}