package phm.example.movieapp.model.network

import io.reactivex.Observable
import phm.example.movieapp.model.Movie
import phm.example.movieapp.model.network.RetrofitCreator.Companion.MOVIE_BASE_URL
import retrofit2.http.GET


class MovieApi {

    interface MovieImpl{
        @GET("/films")
        fun getMovie(): Observable<List<Movie>>
    }

    companion object{
        fun getMovie(): Observable<List<Movie>>{
            return RetrofitCreator.create(MOVIE_BASE_URL, MovieImpl::class.java).getMovie()
        }
    }

}