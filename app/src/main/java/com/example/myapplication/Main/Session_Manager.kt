package com.example.myapplication.Main

import com.example.myapplication.Model.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Session_Manager @Inject constructor() {

    private  var user : User? = null
    private var isAuthenticated = false
    private  var BLM : Double = 0.0
    fun authenticateUser(user: User)
   {
this.user = user
       if(user.sex.equals("male")) {
           BLM = user.exercise * (13.397*user.weight + 4.799*user.height -5.677*user.age + 88.362)
       }
       else
       {
           BLM = user.exercise * (9.247*user.weight + 3.098*user.height -4.330*user.age + 447.593)
       }

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