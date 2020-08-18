package com.example.myapplication.Room

import com.example.myapplication.Model.User

import io.reactivex.Single
import org.junit.Assert
import org.junit.Test

class UserDAO_Test : User_Database_Test() {



    // Insert, Read
@Test
fun InsertRead()
    {
        var  user = User(1,"james","pass",70,180,24,"male",1.25)
getDao().insertUser(user).blockingAwait()
      val inserteduser = getDao().loadUser("james").test().assertValue(user)

    }


    //Insert, Read, Update, Read
    @Test
    fun InsertReadUpdateRead() {

        var  user = User(1,"james","pass",70,180,24,"male",1.25)


        getDao().insertUser(user).blockingAwait()
        var inserteduser = getDao().loadUser("james").test().assertValue(user)
           user.age=11
        getDao().updateUser(user)

         inserteduser = getDao().loadUser("james").test().assertValue(user)





    }

    //Insert, Read, Update, compare to old value
@Test
fun InsertReadUpdateRead_FAIL()
    {

        var  user = User(1,"james","pass",70,180,24,"male",1.25)
        var user1 = User(1,"james","pass",70,180,24,"male",1.25)

        getDao().insertUser(user).blockingAwait()
        user.username="Adam"
       getDao().updateUser(user).blockingAwait()

        getDao().loadUser("james").test().assertNever(user1)
    }




}