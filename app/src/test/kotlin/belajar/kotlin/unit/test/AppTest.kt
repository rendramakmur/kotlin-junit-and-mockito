/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package belajar.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class AppTest {
    @Test fun appHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
}