package belajar.kotlin.unit.test

import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MockTest {
    @Test
    fun testMock() {
        val list: List<String> = Mockito.mock(List::class.java) as List<String>

        Mockito.`when`(list.get(0)).thenReturn("Index 0")
        Mockito.`when`(list.get(1)).thenReturn("Index 1")

        println(list.get(0))
        println(list.get(0))
        println(list.get(1))

        Mockito.verify(list, Mockito.times(2)).get(0)
        Mockito.verify(list).get(1)
    }
}