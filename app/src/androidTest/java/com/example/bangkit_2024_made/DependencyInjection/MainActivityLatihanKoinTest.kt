package com.example.bangkit_2024_made.DependencyInjection

import org.junit.Assert.*
import org.junit.*
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.test.*

class MainActivityLatihanKoinTest : KoinTest {
    private val userRepository: UserRepository by inject()
    private val username = "dicoding"

    @Before
    fun before() {
        loadKoinModules(storageModule)
        userRepository.loginUser(username)
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun getUsernameFromRepository() {
        val requestedUsername = userRepository.getUser()
        assertEquals(username, requestedUsername)
    }
}