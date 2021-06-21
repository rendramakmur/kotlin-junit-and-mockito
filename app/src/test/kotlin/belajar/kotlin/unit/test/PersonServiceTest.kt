package belajar.kotlin.unit.test

import belajar.kotlin.unit.test.model.Person
import belajar.kotlin.unit.test.repository.PersonRepository
import belajar.kotlin.unit.test.service.PersonService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(value = [MockitoExtension::class])
class PersonServiceTest {
    @Mock
    lateinit var personRepository: PersonRepository

    lateinit var personService: PersonService

    @BeforeEach
    fun beforeEach () {
        personService = PersonService(personRepository)
    }

    @Test
    fun testPersonIdIsNotValid () {
        assertThrows<IllegalArgumentException> {
            personService.getById("   ")
        }
    }

    @Test
    fun testPersonNotFound () {
        assertThrows<Exception> {
            personService.getById("99999")
        }
    }

    @Test
    fun testGetPersonSuccess () {
        Mockito.`when`(personRepository.selectById("1")).thenReturn(Person(
            id = "1",
            name = "Rendra"
        ))

        val person = personService.getById("1")
        assertEquals("1", person.id)
        assertEquals("Rendra", person.name)
    }

    @Test
    fun testPersonNameIsBlank() {
        assertThrows<IllegalArgumentException> {
            personService.register("")
        }
    }

    @Test
    fun testRegisterSuccess() {
        val person = personService.register("Rendra")
        assertEquals("Rendra", person.name)
        assertNotNull(person.id)

        Mockito.verify(personRepository, Mockito.times(1)).insert(Person(person.id, "Rendra"))
    }
}