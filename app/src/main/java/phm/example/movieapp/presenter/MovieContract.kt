package phm.example.movieapp.presenter

import phm.example.movieapp.base.BasePresenter
import phm.example.movieapp.base.BaseView
import phm.example.movieapp.model.Movie

interface MovieContract {
    interface View : BaseView{
        fun showMovieList(movieList: ArrayList<Movie>)
    }
    interface Presenter : BasePresenter<View>{
        fun getMovieList()
    }
}