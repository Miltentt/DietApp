package com.example.myapplication.Main.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.User
import com.example.myapplication.Repository.Repository
import com.example.myapplication.Session_Manager
import com.example.myapplication.Util.Resource
import javax.inject.Inject

class EditUser_ViewModel @Inject constructor(val sessionManager: Session_Manager, val repository: Repository) : ViewModel() {

fun loaduser() : LiveData<Resource<User>>
{
  return  sessionManager.returnUser()
}

  fun return_exercise(amount : Double) : String
  {
   var stringamount=""
    when (amount)
    {
      1.2 -> stringamount= "Little to no exercise"
      1.375 ->stringamount= "Light exercise (1–3 days per week)"
      1.55 ->stringamount= "Moderate exercise (3–5 days per week)"
      1.725 ->stringamount= "Heavy exercise (6–7 days per week)"
      1.9 -> stringamount="Very heavy exercise (twice per day, extra heavy workouts)"
    }
return stringamount
  }

    fun updateUser(id: Int,username : String,  password : String,  weight : Int,  height : Int,  age : Int,sex : String,exercise : String) {
        var exerciseInt : Double
        when(exercise)
        {
            "Little to no exercise" -> exerciseInt=1.2
            "Light exercise (1–3 days per week)" -> exerciseInt=1.375
            "Moderate exercise (3–5 days per week)" -> exerciseInt=1.55
            "Heavy exercise (6–7 days per week)" ->  exerciseInt=1.725
            "Very heavy exercise (twice per day, extra heavy workouts)" ->exerciseInt=1.9
            else -> throw IllegalArgumentException("invalid name")
        }
        val user = User(id,username,password,weight,height,age,sex,exerciseInt)
        repository.updateUser(user)
        sessionManager.authenticateUser(MutableLiveData<Resource<User>>(Resource.Success(user)))

    }

}