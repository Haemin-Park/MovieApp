package phm.example.movieapp.presenter

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import phm.example.movieapp.model.Image
import phm.example.movieapp.model.Movie
import phm.example.movieapp.model.network.ImageAPI
import phm.example.movieapp.model.network.MovieApi

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

        compositeDisposable.add(MovieApi.getMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({ response: List<Movie> ->
                for (item in response) {
                    movieList.add(item)
                    Log.d("Movie: ", item.title)

                    val query= mutableMapOf("query" to item.title, "filter" to "small")

                    compositeDisposable.add(ImageAPI.getImage(query)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe({ response: Image ->

                            Log.d("Image: ", response.items?.toString())


                        }, { error: Throwable ->
                            Log.d("ImageError: ", error.localizedMessage)
                        }
                        ))

                }
                ma?.showMovieList(movieList)
            }, { error: Throwable ->
                Log.d("MovieError: ", error.localizedMessage)
            }
            ))
    }

    override fun dropView() {
        ma = null
    }
}