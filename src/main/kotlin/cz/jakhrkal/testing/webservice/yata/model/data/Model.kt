package cz.jakhrkal.testing.webservice.yata.model.data

import java.time.LocalDateTime
import javax.persistence.*
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlType

@Entity
@XmlType
@XmlAccessorType
data class Task(
        var title: String,
        var description: String,
        var finishBy: LocalDateTime,
        @ManyToOne @JoinColumn var user: User,
        @Id @GeneratedValue var id: Long? = null,
        var createdOn: LocalDateTime = LocalDateTime.now())

@Entity
@XmlType
@XmlAccessorType
data class User(
        var firstName: String,
        var lastName: String,
        var email: String? = null,
        @Id @GeneratedValue var id: Long? = null)
