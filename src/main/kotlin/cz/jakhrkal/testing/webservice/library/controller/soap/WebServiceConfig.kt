package cz.jakhrkal.testing.webservice.library.controller.soap

import cz.jakhrkal.testing.webservice.library.model.service.BookService
import org.apache.cxf.Bus
import org.apache.cxf.jaxws.EndpointImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.ws.Endpoint

//    http://localhost:8080/services/api/soap?WSDL

@Configuration
class WebServiceConfig {

    @Autowired
    private val bus: Bus? = null

    @Autowired
    private val bookService: BookService? = null

    @Bean
    fun endpoint(): Endpoint {
        val endpoint = EndpointImpl(bus, LibrarySoapServiceImpl(bookService!!))
        endpoint.publish("/api/soap")
        return endpoint
    }
}
