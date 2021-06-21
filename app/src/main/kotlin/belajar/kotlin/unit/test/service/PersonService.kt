package belajar.kotlin.unit.test.service

import belajar.kotlin.unit.test.model.Person
import belajar.kotlin.unit.test.repository.PersonRepository
import java.util.*

class PersonService(private val personRepository: PersonRepository) {

    fun getById(id: String): Person {
        if (id.isBlank()) {
            throw IllegalArgumentException("Person id is not valid")
        }

        val person = personRepository.selectById(id)

        if (person != null) {
            return person
        } else {
            throw Exception("Person not found")
        }
    }

    fun register(name: String): Person {
        if (name.isBlank()) {
            throw IllegalArgumentException("Person name is blank")
        }
        
        val person = Person (
            id = UUID.randomUUID().toString(),
            name = name
        )

        personRepository.insert(person)

        return person
    }

}