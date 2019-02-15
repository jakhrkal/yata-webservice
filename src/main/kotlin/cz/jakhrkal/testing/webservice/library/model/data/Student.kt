package cz.jakhrkal.testing.webservice.library.model.data

import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlType

@XmlType
@XmlAccessorType
data class Student (
    var id: Long? = null,
    var name: String? = null,
    var passportNumber: String? = null
)