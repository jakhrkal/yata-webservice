package cz.jakhrkal.testing.webservice.library.model.data

import java.time.LocalDateTime
import javax.persistence.*
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlType

@Entity
@XmlType
@XmlAccessorType
data class Book(
        var title: String,
        var subtitle: String,
        var publishYear: Int,
        @ManyToOne @JoinColumn var author: Author,
        @Id @GeneratedValue var id: Long? = null,
        var addedAt: LocalDateTime = LocalDateTime.now())

@Entity
@XmlType
@XmlAccessorType
data class Author(
        var firstName: String,
        var lastName: String,
        var description: String? = null,
        @Id @GeneratedValue var id: Long? = null)
