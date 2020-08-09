package phm.example.movieapp.model.network

import phm.example.movieapp.model.Movie
import io.reactivex.Observable
import retrofit2.http.GET

class MovieApi {

    interface MovieImpl{
        @GET("/films")
        fun getMovie(): Observable<List<Movie>>
    }

    companion object{
        fun getMovie(): Observable<List<Movie>>{
            return RetrofitCreator.create(MovieImpl::class.java).getMovie()
        }
    }

}