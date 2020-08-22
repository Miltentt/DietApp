package com.example.myapplication.Main.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.Edamam_Response
import com.example.myapplication.Repository.Recipe_Repository
import com.example.myapplication.Repository.Repository
import com.example.myapplication.Retrofit.Edamam_Api
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Main_ViewModel @Inject constructor(edamamApi: Edamam_Api) : ViewModel()  {

val recipeRepository = Recipe_Repository(edamamApi);
class single : SingleObserver<Edamam_Response> {
    override fun onSuccess(t: Edamam_Response) {
        Log.i("xd",t.to.toString())
    }

    override fun onSubscribe(d: Disposable) {
        TODO("Not yet implemented")
    }

    override fun onError(e: Throwable) {
        Log.i("xd","nothing")
    }

}
    val singlee = single()

    fun loadRecipe()
    {

    }




}