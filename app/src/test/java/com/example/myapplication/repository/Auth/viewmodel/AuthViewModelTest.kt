package com.example.myapplication.repository.Auth.viewmodel

import com.example.myapplication.auth.viewmodels.AuthViewModel
import com.example.myapplication.SessionManager
import com.example.myapplication.models.User
import com.example.myapplication.repositories.Repository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AuthViewModelTest {

    // system under testing
    private lateinit var authViewmodel: AuthViewModel

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var sessionManager: SessionManager

    @BeforeEach
    fun initMocks() {
        MockitoAnnotations.initMocks(this)
        authViewmodel = AuthViewModel(repository, sessionManager)
    }

    private fun <T> anyy(type: Class<T>): T = Mockito.any<T>(type)

    // Insert user with sucess
    @ParameterizedTest
    @ValueSource(strings = ["Little to no exercise", "Light exercise (1–3 days per week)", "Moderate exercise (3–5 days per week)", "Heavy exercise (6–7 days per week)", "Very heavy exercise (twice per day, extra heavy workouts)"])
    fun adduser(exrecise: String) {
        //Act
        authViewmodel.addUser("x", "x", 11, 11, 11, "male", exrecise)

        //Assert
        Mockito.verify(repository).addUser(
            anyy(String::class.java),
            anyy(String::class.java),
            anyy(Int::class.java),
            anyy(Int::class.java),
            anyy(Int::class.java),
            anyy(String::class.java),
            anyy(Double::class.java)
        )
        Mockito.verifyNoMoreInteractions(repository)

    }

    //insert user with failure
    @ParameterizedTest
    @ValueSource(strings = ["Little to no exercise", "Light exercise (1–3 days per week)", "Moderate exercise (3–5 days per week)", "Heavy exercise (6–7 days per week)", "testfail"])
    fun adduserFail(exrecise: String) {
        //Act
        authViewmodel.addUser("x", "x", 11, 11, 11, "male", exrecise)

        //Assert
        Mockito.verify(repository).addUser(
            anyy(String::class.java),
            anyy(String::class.java),
            anyy(Int::class.java),
            anyy(Int::class.java),
            anyy(Int::class.java),
            anyy(String::class.java),
            anyy(Double::class.java)
        )
        Mockito.verifyNoMoreInteractions(repository)
    }

    @Test
    fun loaduser() {
        //Arrange
        val username = "james"
        val user = User(0, "james", "x", 11, 11, 11, "male", 1.25)
        //Act
        authViewmodel.addUser("james", "x", 11, 11, 11, "male", "Little to no exercise")
        authViewmodel.loadUser(username)
            .test()
            .assertValue(user)


    }


}




