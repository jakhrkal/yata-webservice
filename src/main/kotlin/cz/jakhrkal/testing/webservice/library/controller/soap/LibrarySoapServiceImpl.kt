package cz.jakhrkal.testing.webservice.library.controller.soap

import cz.jakhrkal.testing.webservice.library.model.data.Book
import cz.jakhrkal.testing.webservice.library.model.service.BookService
import javax.jws.WebService

@WebService(endpointInterface = "cz.jakhrkal.testing.webservice.library.controller.soap.LibrarySoapService")
class LibrarySoapServiceImpl(private val bookService : BookService) : LibrarySoapService {

    override fun sayHello(text: String): String {
        return "Hello $text"
    }

    override fun getBookDetails(id: Long): Book {
        return bookService.findBookById(id).get()
    }

//    override fun getAllBooks(): MutableIterable<Book> {
//        return bookService.findAllBooks()
//    }

}