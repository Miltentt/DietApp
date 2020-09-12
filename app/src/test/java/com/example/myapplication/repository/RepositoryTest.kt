package com.example.myapplication.repository


import com.example.myapplication.models.User
import com.example.myapplication.repositories.Repository
import com.example.myapplication.room.UserDAO
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class RepositoryTest {

    @Mock
    private lateinit var userDao : UserDAO


    @InjectMocks
    private lateinit var repository : Repository;
    @BeforeEach
    fun initmocks()
    {


        MockitoAnnotations.initMocks(this)
       repository = Repository(userDao)
    }

    fun returntrue() : Boolean
    {
        return true;
    }
    private fun <T> anyy(type: Class<T>): T = Mockito.any<T>(type)

    // Insert user with success
@Test
fun insertUserSuccess() {
//Arrange
    //Act
repository.addUser("x","x",11,11,11,"male",1.25)
        Thread.sleep(2000)
    //Assert
Mockito.verify(userDao).insertUser(anyy(User::class.java));
    Mockito.verifyNoMoreInteractions(userDao)
}



    @Test
    fun readUser()
    {

        //Arrange
        val username = "james"
       //Act
        repository.loadUser(username);
        // Assert

        Mockito.verify(userDao).loadUser(anyy(String::class.java));
        Mockito.verifyNoMoreInteractions(userDao)




    }


}