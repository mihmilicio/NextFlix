package io.github.mihmilicio.nextflix.test_utils

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

@ExperimentalCoroutinesApi
abstract class SuiteDeTesteCoroutines {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
}