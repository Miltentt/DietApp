package com.example.myapplication.Main

import com.example.myapplication.Model.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Session_Manager @Inject constructor() {

    public  var user : User? = null
    private var isAuthenticated = false
   fun authenticateUser(user: User)
   {
this.user = user

isAuthenticated = true;
   }

fun isUserAuthenticated() : Boolean
{
return isAuthenticated
}

    fun returnUser() : User?
    {
return user
    }
fun logout()
{
    isAuthenticated=false;
    user=null;
}



}