package com.example.myapplication.repository


import com.example.myapplication.Model.User
import com.example.myapplication.Repository.Repository
import com.example.myapplication.Room.User_DAO
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.Callable


class Repository_Test {

    @Mock
    private lateinit var userDao : User_DAO


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
fun InsertUserSuccess() {
//Arrange
    //Act
repository.addUser("x","x",11,11,11,"male",1.25)
        Thread.sleep(2000)
    //Assert
Mockito.verify(userDao).insertUser(anyy(User::class.java));
    Mockito.verifyNoMoreInteractions(userDao)
}



    @Test
    fun ReadUser()
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