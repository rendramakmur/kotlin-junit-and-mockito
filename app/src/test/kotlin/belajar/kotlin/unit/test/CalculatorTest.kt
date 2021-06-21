package belajar.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Assumptions.*
import org.junit.jupiter.api.*
import java.lang.IllegalArgumentException

@DisplayName("Test for Calculator class")
class CalculatorTest {
    val calculator = Calculator()

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll () {
            println("Before all executed")
        }

        @AfterAll
        @JvmStatic
        fun afterAll () {
            println("After all executed")
        }
    }

    @BeforeEach
    fun beforeEach() {
        println("Before test")
    }

    @AfterEach
    fun afterEach() {
        println("After test")
    }

    @Test
    @DisplayName("Test add result on Calculator class")
    fun testAddResult () {
        val result = calculator.add(10, 10)
        assertEquals(20, result, "Hasil harusnya 20")
    }

    @Test
    @DisplayName("Test divide success on Calculator class")
    fun testDivideSuccess() {
        val result = calculator.divide(100, 10)
        assertEquals(10, result, "Hasil seharusnya 10")
    }

    @Test
    @DisplayName("Test divide by zero throw exception")
    fun testDivideError() {
        assertThrows<IllegalArgumentException> {
            calculator.divide(100, 0)
        }
    }

    @Test
    @DisplayName("Assume test")
    fun testAssumtion () {
        assumeTrue(System.getenv()["PROFILE"] == "DEV")
        println("Hasil assume true")

//        Kalau true baru lanjut ke block ini, kalau false diskip
    }

}