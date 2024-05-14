package io.github.mihmilicio.nextflix.test_utils

import org.junit.Before
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.stubbing.OngoingStubbing

interface SuiteDeTesteMockito {

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }
}

inline fun <reified T> mock(): T =
    Mockito.mock(T::class.java)

fun <T> whenever(methodCall: T): OngoingStubbing<T> =
    Mockito.`when`(methodCall)