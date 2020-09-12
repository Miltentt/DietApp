package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.myapplication.models.User
import com.example.myapplication.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private var cacheduser = MediatorLiveData<Resource<User>>()
    private var user: User? = null
    private var isAuthenticated = false
    private var BLM: Double = 0.0
    fun authenticateUser(user: User) {
        this.user = user
        BLM = if (user.sex == "male") {
            user.exercise * (13.397 * user.weight + 4.799 * user.height - 5.677 * user.age + 88.362)
        } else {
            user.exercise * (9.247 * user.weight + 3.098 * user.height - 4.330 * user.age + 447.593)
        }
        isAuthenticated = true;
    }

    fun authenticateUser(source: LiveData<Resource<User>>) {
        cacheduser.addSource(source) { t -> cacheduser.value = t }
        cacheduser.removeSource(source)
    }

    fun logout() {
        cacheduser.value = (Resource.Logout())
    }

    fun returnUser(): LiveData<Resource<User>> {
        return cacheduser
    }

}