package com.example.myapplication.main.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.repositories.RecipeRepository
import com.example.myapplication.retrofit.EdamamApi
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainViewModel @Inject constructor(edamamApi: EdamamApi) : ViewModel() {

    val recipeRepository = RecipeRepository(edamamApi);

    class Single : SingleObserver<EdamamResponse> {
        override fun onSuccess(t: EdamamResponse) {
            Log.i("xd", t.to.toString())
        }

        override fun onSubscribe(d: Disposable) {
            TODO("Not yet implemented")
        }

        override fun onError(e: Throwable) {
            Log.i("xd", "nothing")
        }

    }


}