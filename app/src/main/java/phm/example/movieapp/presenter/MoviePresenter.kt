package phm.example.movieapp.presenter

import android.content.Intent
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import phm.example.movieapp.model.Movie
import phm.example.movieapp.model.network.MovieApi
import phm.example.movieapp.view.MainActivity

class MoviePresenter : MovieContract.Presenter {

    private var ma : MovieContract.View? = null
    lateinit var compositeDisposable: CompositeDisposable
    lateinit var movieList: ArrayList<Movie>

    override fun takeView(view: MovieContract.View) {
        ma = view
    }

    override fun getMovieList() {
     compositeDisposable = CompositeDisposable()

        movieList = ArrayList()
        var n=0
        compositeDisposable.add(MovieApi.getMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({ response: List<Movie> ->
                for (item in response) {
                    movieList.add(item)
                    Log.d("MoviePresenter: ", item.title)
                }
                ma?.showMovieList(movieList)
            }, { error: Throwable ->
                Log.d("MoviePresenter: ", error.localizedMessage)
            }
            ))
    }

    override fun dropView() {
        ma = null
    }
}