package com.example.myapplication.auth.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.SessionManager
import com.example.myapplication.models.User
import com.example.myapplication.repositories.Repository
import com.example.myapplication.util.Resource
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AuthViewModel @Inject constructor(
    val repository: Repository,
    val sessionManager: SessionManager
) : ViewModel() {

    private var userlivedata = MutableLiveData<Resource<User>>()

    fun addUser(
        username: String,
        password: String,
        weight: Int,
        height: Int,
        age: Int,
        sex: String,
        exercise: String
    ) {
        val exerciseInt: Double = when (exercise) {
            "Little to no exercise" -> 1.2
            "Light exercise (1–3 days per week)" -> 1.375
            "Moderate exercise (3–5 days per week)" -> 1.55
            "Heavy exercise (6–7 days per week)" -> 1.725
            "Very heavy exercise (twice per day, extra heavy workouts)" -> 1.9
            else -> throw IllegalArgumentException("invalid name")
        }

        repository.addUser(username, password, weight, height, age, sex, exerciseInt)

    }

    fun authenticateUser(username: String, password: String) {
        (repository.authenticateUser(username, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : SingleObserver<User> {
                override fun onSuccess(t: User) {
                    userlivedata.value = Resource.Success(t)
                    sessionManager.authenticateUser(userlivedata)

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    userlivedata.value = Resource.Error("User not found", null)
                    sessionManager.authenticateUser(userlivedata)

                }

            }))

    }


    fun loadUser(username: String): Single<User> {
        return repository.loadUser(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun observeUserState(): LiveData<Resource<User>> {
        return sessionManager.returnUser()
    }
}