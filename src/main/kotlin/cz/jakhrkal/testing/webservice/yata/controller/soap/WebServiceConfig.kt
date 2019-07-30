package cz.jakhrkal.testing.webservice.yata.controller.soap

import cz.jakhrkal.testing.webservice.yata.model.service.TodoAppService
import org.apache.cxf.Bus
import org.apache.cxf.jaxws.EndpointImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.ws.Endpoint

//    http://localhost:8080/services/api/soap?WSDL
// todo name the service

@Configuration
class WebServiceConfig {

    @Autowired
    private val bus: Bus? = null

    @Autowired
    private val todoAppService: TodoAppService? = null

    @Bean
    fun endpoint(): Endpoint {
        val endpoint = EndpointImpl(bus, TodoAppSoapServiceImpl(todoAppService!!))
        endpoint.publish("/api/soap")
        return endpoint
    }
}
