package phm.example.movieapp.presenter

import phm.example.movieapp.base.BasePresenter
import phm.example.movieapp.base.BaseView

interface MovieContract {
    interface View : BaseView{
        fun showMovieList()
    }
    interface Presenter : BasePresenter<View>{
        fun getMovieList()
    }
}