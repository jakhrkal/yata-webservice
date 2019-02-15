package cz.jakhrkal.testing.webservice.library.controller.soap

import cz.jakhrkal.testing.webservice.library.model.data.Book
import javax.jws.WebService

@WebService
interface LibrarySoapService {
//    todo name parameters
    fun sayHello(text : String) : String
    fun getBookDetails(id: Long): Book
//    todo fun getAllBooks(): MutableIterable<Book>
}